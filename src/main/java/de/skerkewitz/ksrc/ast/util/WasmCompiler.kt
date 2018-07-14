package de.skerkewitz.ksrc.ast.util

import asmble.ast.Node
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction
import de.skerkewitz.ksrc.backend.wasm.FunctionCompiler
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class WasmCompiler() {

  data class NameSection(
          val moduleName: String?,
          val funcNames: Map<Int, String>,
          val localNames: Map<Int, Map<Int, String>>
  )

  private lateinit var functions: List<AstDeclarationFunction>

  val types: List<Node.Type.Func> = emptyList()
  val imports: List<Node.Import> = emptyList()
  val tables: List<Node.Type.Table> = emptyList()
  val memories: List<Node.Type.Memory> = emptyList()
  val globals: List<Node.Global> = emptyList()
  val exports: List<Node.Export> = emptyList()
  val startFuncIndex: Int? = null
  val elems: List<Node.Elem> = emptyList()
  val funcs: MutableList<Node.Func> = mutableListOf()
  val data: List<Node.Data> = emptyList()
  val names: Node.NameSection? = null
  val customSections: List<Node.CustomSection> = emptyList()

  val funcNames: MutableMap<Int, String> = mutableMapOf()
  val localNames: MutableMap<Int, Map<Int, String>> = mutableMapOf()

  fun createModule(): Node.Module {

    funcNames[funcNames.size] = "print"

    for (function in functions) {
      declareFunction(function)
    }

    for (function in functions) {
      compileFunction(function)
    }

    val exports = arrayListOf<Node.Export>()
    exports.add(Node.Export("factorial", Node.ExternalKind.FUNCTION, 0))
    exports.add(Node.Export("fib", Node.ExternalKind.FUNCTION, 1))

    val types = arrayListOf<Node.Type.Func>()
    val type = Node.Type.Func(arrayListOf(Node.Type.Value.I32), null)
    types.add(type)

    val imports = arrayListOf<Node.Import>()
    val import = Node.Import("native", "print", Node.Import.Kind.Func(0))
    imports.add(import)

    return Node.ModuleBuilder()
            .withFunctions(funcs)
            .withNames(Node.NameSection("testModule", funcNames, localNames))
            .withData(Node.Data(0, arrayListOf(Node.Instr.I32Const(0)), "abcd".toByteArray()))
            .withExports(exports)
            .withImports(imports)
            .withTypes(types)
            .create()
  }

  fun compileFunction(node: AstDeclarationFunction) {

    val wasmFunction = FunctionCompiler.compile(node, Resolver(this))

    this.localNames[this.localNames.size] = wasmFunction.localNames

    addFunction(wasmFunction.function, wasmFunction.functionName)
  }

  private fun addFunction(function: Node.Func, withName: String) {

    /* Make sure we didn't mess up the index. */
    val indexOfFunction = Resolver(this).indexOfFunction(withName)
//    if (indexOfFunction != funcs.size) throw IllegalStateException("index seems to be messed up")
    funcs.add(function)
  }

  fun declareFunction(functionDeclaration: AstDeclarationFunction) {
    funcNames[funcNames.size] = functionDeclaration.name.ident
  }

  fun withFunctions(functions: List<AstDeclarationFunction>): WasmCompiler {
    this.functions = functions
    return this
  }

  class Resolver(val ref: WasmCompiler): FunctionCompiler.FunctionResolver {

    override fun indexOfFunction(name: String): Int {
      val index = ref.funcNames.entries.indexOfFirst { it.value == name }
      if (index < 0 ) {
        throw IllegalArgumentException("Unknown function '${name}'")
      }

      return index
    }

  }

}