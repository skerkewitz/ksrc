package asmble.run.jvm

import asmble.ast.Node
import java.lang.invoke.MethodHandle

interface Module {
  val name: String?

  fun exportedFunc(field: String): MethodHandle?

  fun exportedGlobal(field: String): Pair<MethodHandle, MethodHandle?>?

  fun <T> exportedMemory(field: String, memClass: Class<T>): T?

  fun exportedTable(field: String): Array<MethodHandle?>?

  interface ImportResolver {
    fun resolveImportFunc(module: String, field: String, type: Node.Type.Func): MethodHandle
    fun resolveImportGlobal(module: String, field: String, type: Node.Type.Global): Pair<MethodHandle, MethodHandle?>
    fun <T> resolveImportMemory(module: String, field: String, type: Node.Type.Memory, memClass: Class<T>): T
    fun resolveImportTable(module: String, field: String, type: Node.Type.Table): Array<MethodHandle?>
  }
}