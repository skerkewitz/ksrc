package de.skerkewitz.ksrc.sil.ast

import de.skerkewitz.ksrc.common.SourceLocation

data class SilAstNodeBlock(override val srcLocation: SourceLocation, val identifier: String, val arguments: List<SilAstNodeOperand>, val terminator: SilAstNode) : SilAstNode(srcLocation) {

  override fun toSilString(): String {
    return """
      |$identifier: (${arguments.joinToString(separator = ", ") { it.toSilString() }}}
      |    ${terminator.toSilString()}      
    """.trimMargin()
  }
}

data class SilAstNodeOperand(override val srcLocation: SourceLocation, val identifier: String, val type: SilAstNodeType) : SilAstNode(srcLocation) {
  override fun toSilString(): String {
    return "$identifier : ${type.toSilString()}"
  }
}

data class SilAstNodeJumpTarget(override val srcLocation: SourceLocation, val identifier: String, val operands: List<SilAstNodeOperand>) : SilAstNode(srcLocation) {
  override fun toSilString(): String {
    return "$identifier(${this.operands.joinToString(separator = ", ") { it.toSilString() }})"
  }
}

data class SilAstNodeFunction(
        val sourceLocation: SourceLocation,
        val functionName: String,
        val type: SilAstNodeType.Function,
        val blocks: List<SilAstNodeBlock>): SilAstNode(sourceLocation) {

  override fun toSilString(): String {
    return """
      |sil @$functionName : ${type.toSilString()} {
      |${blocks.joinToString(separator = "\n  ", prefix = "  ") { it.toSilString() }}
      |}
      |""".trimMargin()
  }
}


sealed class SilAstNodeType(srcLocation: SourceLocation) : SilAstNode(srcLocation) {

  data class Simple(val sourceLocation: SourceLocation, val name: String) : SilAstNodeType(sourceLocation) {
    override fun toSilString(): String = this.name
    override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (other !is Simple) return false

      if (name != other.name) return false
      return true
    }

    override fun hashCode(): Int {
      return name.hashCode()
    }
  }
  data class Function(val sourceLocation: SourceLocation, val arguments: List<SilAstNodeType>, val returnType: SilAstNodeType) : SilAstNodeType(sourceLocation) {
    override fun toSilString(): String {

      val arguments = this.arguments.joinToString { it.toSilString() }
      return "($arguments) -> ${returnType.toSilString()}"
    }
  }
}

sealed class SilAstNodeTerminator(srcLocation: SourceLocation) : SilAstNode(srcLocation) {

  data class Return(val sourceLocation: SourceLocation, val operand: SilAstNodeOperand) : SilAstNode(sourceLocation) {
    override fun toSilString(): String = "return ${operand.toSilString()}"
  }
  data class Branch(val sourceLocation: SourceLocation, val jumpTarget: SilAstNodeJumpTarget) : SilAstNode(sourceLocation) {
    override fun toSilString(): String {
      return "br ${jumpTarget.toSilString()}"
    }
  }

  data class BranchConditionally(val sourceLocation: SourceLocation, val condition: SilAstNodeOperand, val thenJumpTarget: SilAstNodeJumpTarget, val elseJumpTarget: SilAstNodeJumpTarget) : SilAstNode(sourceLocation) {
    override fun toSilString(): String {
      return "cond_br ${condition.toSilString()}, ${thenJumpTarget.toSilString()}, ${elseJumpTarget.toSilString()}"
    }
  }
}





