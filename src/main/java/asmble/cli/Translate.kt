package asmble.cli

import asmble.ast.SExpr
import asmble.ast.Script
import asmble.io.*
import asmble.util.Logger
import asmble.util.toIntExact
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

open class Translate {

    fun run(args: Args) {
        // Get format
        val inFormat =
            if (args.inFormat != "<use file extension>") args.inFormat
            else args.inFile.substringAfterLast('.', "<unknown>")
        val script = inToAst(args.inFile, inFormat)
        val outFormat =
            if (args.outFormat != "<use file extension or wast for stdout>") args.outFormat
            else if (args.outFile == "--") "wast"
            else args.outFile.substringAfterLast('.', "<unknown>")
        TranslateUtil.astToOut(args.outFile, outFormat, args.compact, script)
    }

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
            "wasm" -> {
                val inStream = ByteReader.InputStream(inBytes.inputStream())
                val module = BinaryToAst(logger = Logger.Print(Logger.Level.OFF)).toModule(inStream)
                Script(listOf(Script.Cmd.Module(module, null)))
            }
            else -> error("Unknown in format '$inFormat'")
        }
    }

    data class Args(
        val inFile: String,
        val inFormat: String,
        val outFile: String,
        val outFormat: String,
        val compact: Boolean
    )

    companion object : Translate()
}