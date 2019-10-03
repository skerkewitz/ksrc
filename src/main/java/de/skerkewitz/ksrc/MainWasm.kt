package de.skerkewitz.ksrc

import asmble.ast.Node
import asmble.ast.Script
import asmble.cli.TranslateUtil
import asmble.run.jvm.Module
import asmble.run.jvm.interpret.Interpreter
import asmble.run.jvm.interpret.RunModule
import de.skerkewitz.ksrc.parse.KSrcAstParser
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatement
import de.skerkewitz.ksrc.parse.ast.util.Walker
import de.skerkewitz.ksrc.parse.ast.util.WasmCompiler
import de.skerkewitz.ksrc.sema.SemaFactory
import org.antlr.v4.runtime.CharStreams
import java.io.IOException
import java.io.PrintStream
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType


object MainWasm {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val inputFilename = args[0]
        println("Input file is: $inputFilename")

        /* Build AST tree. */
        println("Parsing...")
        val charStream = CharStreams.fromFileName(inputFilename)
        val rootStatement = KSrcAstParser.parse(charStream) as AstStatement

        /* Build Sema */
        println("Analyze...")
        val sema = SemaFactory.buildSemaFromRootStatement(rootStatement)

        /* Print source. */
        Walker(Walker.PrintContext(PrintStream(System.out))).walk(rootStatement)

        /* Compile to wasm. */
        println("Compile...")

        val functions = sema.functionsDeclarations
                .filter { it.buildIn == null }
                .map { it.methodInfo.functionDeclaration }


        val wasmCompiler = WasmCompiler()
        wasmCompiler.withFunctions(functions)
        val module = wasmCompiler.createModule()


        println("Writing binary...")
        //TranslateUtil.astToStream(System.out, TranslateUtil.WasmFormat.Text,false, Script(arrayListOf(Script.Cmd.Module(walkerWasm.createModule(), "testModule"))))
        TranslateUtil.astToOut("test.wasm", "wasm",false, Script(arrayListOf(Script.Cmd.Module(module, "testModule"))))

        println("Exceuting...")
        val build = RunModule.Builder().build(MyResolver(), module, null)


        val char = build.ctx.mem[0].toChar()

        val execFunc = Interpreter.execFunc(build.ctx, 1, 4)
        println("Result: $execFunc")
    }




    class MyResolver : Module.ImportResolver {

        override fun resolveImportFunc(module: String, field: String, type: Node.Type.Func): MethodHandle {

            this.javaClass.declaredMethods.forEach { println(it); }
            val forName = Class.forName("java.lang.Object")

            return MethodHandles.lookup().findStatic(NativeFunctions.javaClass, "print", MethodType.methodType(forName, forName))
        }

        override fun resolveImportGlobal(module: String, field: String, type: Node.Type.Global): Pair<MethodHandle, MethodHandle?> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T> resolveImportMemory(module: String, field: String, type: Node.Type.Memory, memClass: Class<T>): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun resolveImportTable(module: String, field: String, type: Node.Type.Table): Array<MethodHandle?> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        object NativeFunctions {
            @JvmStatic
            fun print(i: Any): Any? {
                //val i: Int = 0
                println("print: $i")
                return null
            }
        }
    }
}