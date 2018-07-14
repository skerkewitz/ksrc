package asmble.run.jvm

import asmble.ast.Node


interface ModuleBuilder<T : Module> {
  fun build(imports: Module.ImportResolver, mod: Node.Module, name: String?): T

}