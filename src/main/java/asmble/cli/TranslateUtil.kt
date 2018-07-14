package asmble.cli

import asmble.ast.SExpr
import asmble.ast.Script
import asmble.io.*
import asmble.util.Logger
import asmble.util.toIntExact
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStream

object TranslateUtil {

    enum class WasmFormat {
        Text,
        Binary;

        companion object {
            fun fromString(format: String): WasmFormat {
                return when (format) {
                    "wast" -> Text
                    "wasm" -> Binary
                    else -> error("Unknown in format '$format'")
                }
            }
        }

    }
        lateinit var logger: Logger

    fun inToAst(inFile: String, inFormat: String): Script {
        val inBytes =
                if (inFile == "--") System.`in`.use { it.readBytes() }
                else File(inFile).let { f -> FileInputStream(f).use { it.readBytes(f.length().toIntExact()) } }
        return when (inFormat) {
            "wast" -> StrToSExpr.parse(inBytes.toString(Charsets.UTF_8)).let { res ->
                when (res) {
                    is StrToSExpr.ParseResult.Error -> error("Error [${res.pos.line}:${res.pos.char}] - ${res.pos}")
                    is StrToSExpr.ParseResult.Success -> SExprToAst.toScript(SExpr.Multi(res.vals))
                }
            }
            "wasm" ->
                Script(listOf(Script.Cmd.Module(BinaryToAst(logger = logger).toModule(
                        ByteReader.InputStream(inBytes.inputStream())), null)))
            else -> error("Unknown in format '$inFormat'")
        }
    }

    fun astToOut(outFile: String, outFormat: String, compact: Boolean, script: Script) {
        val outStream =
                if (outFile == "--") System.out
                else FileOutputStream(outFile)

        astToStream(outStream, WasmFormat.fromString(outFormat), compact, script)
    }

    fun astToStream(outStream: OutputStream, outFormat: WasmFormat, compact: Boolean, script: Script) {
        outStream.use { outputStream ->
            when (outFormat) {
                WasmFormat.Text -> {
                    val sexprToStr = if (compact) SExprToStr.Compact else SExprToStr
                    val sexprs = AstToSExpr.fromScript(script)
                    outputStream.write(sexprToStr.fromSExpr(*sexprs.toTypedArray()).toByteArray())
                }
                WasmFormat.Binary -> {
                    val mod = (script.commands.firstOrNull() as? Script.Cmd.Module)?.module
                            ?: error("Output to WASM requires input be just a single module")
                    AstToBinary.fromModule(ByteWriter.OutputStream(outputStream), mod)
                }
            }
        }
    }
}