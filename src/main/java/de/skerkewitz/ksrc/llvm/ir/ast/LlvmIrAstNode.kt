package de.skerkewitz.ksrc.llvm.ir.ast

import de.skerkewitz.ksrc.common.SourceLocation


class LlvmIr {

  data class Module(val name: String)

  sealed class AstNode(open val srcLocation: SourceLocation) {
    abstract fun toLlvmIrString(): String

    data class Function(
            val sourceLocation: SourceLocation,
            val functionName: String,
            val returnType: Type,
            val arguments: List<Operand>,
            val blocks: List<AstNode>) : AstNode(sourceLocation) {

      override fun toLlvmIrString(): String {
        return """
      |define ${returnType.toLlvmIrString()} @$functionName (${arguments.joinToString(", ") { it.toLlvmIrString() }}) {
      |${blocks.joinToString(separator = "\n  ", prefix = "  ") { it.toLlvmIrString() }}
      |}
      |""".trimMargin()
      }
    }

    data class Operand(override val srcLocation: SourceLocation, val identifier: String, val type: Type) : AstNode(srcLocation) {
      override fun toLlvmIrString(): String {
        return "${type.toLlvmIrString()} %$identifier"
      }
    }

    sealed class Type(srcLocation: SourceLocation) : AstNode(srcLocation) {

      data class Simple(val sourceLocation: SourceLocation, val name: String) : Type(sourceLocation) {
        override fun toLlvmIrString(): String = this.name
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

      data class Function(val sourceLocation: SourceLocation, val arguments: List<Type>, val returnType: Type) : Type(sourceLocation) {
        override fun toLlvmIrString(): String {

          val arguments = this.arguments.joinToString { it.toLlvmIrString() }
          return "($arguments) -> ${returnType.toLlvmIrString()}"
        }
      }
    }

    data class BasicBlock(override val srcLocation: SourceLocation, val identifier: String, val instructionsDefinitions: List<AstNode>, val terminator: TerminatorInstruction) : AstNode(srcLocation) {

      override fun toLlvmIrString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$identifier: \n")
        if (instructionsDefinitions.isNotEmpty()) {
          stringBuilder.append(instructionsDefinitions.joinToString("\n") { "    ${it.toLlvmIrString()}" })
          stringBuilder.append('\n')
        }
        stringBuilder.append("    ${terminator.toLlvmIrString()}\n")
        return stringBuilder.toString()
      }
    }

    sealed class TerminatorInstruction(srcLocation: SourceLocation) : AstNode(srcLocation) {

      data class Return(val sourceLocation: SourceLocation, val operand: Operand) : TerminatorInstruction(sourceLocation) {
        override fun toLlvmIrString(): String = "ret ${operand.toLlvmIrString()}"
      }

//      data class Branch(val sourceLocation: SourceLocation, val jumpTarget: SilAstNodeJumpTarget) : SilAstNodeTerminator(sourceLocation) {
//        override fun toSilString(): String {
//          return "br ${jumpTarget.toSilString()}"
//        }
//      }
//
//      data class BranchConditionally(val sourceLocation: SourceLocation, val condition: SilAstNodeOperand, val thenJumpTarget: SilAstNodeJumpTarget, val elseJumpTarget: SilAstNodeJumpTarget) : SilAstNodeTerminator(sourceLocation) {
//        override fun toSilString(): String {
//          return "cond_br ${condition.toSilString()}, ${thenJumpTarget.toSilString()}, ${elseJumpTarget.toSilString()}"
//        }
//      }
    }

    data class InstructionDefinition(override val srcLocation: SourceLocation, val result: String, val instruction: Instruction) : AstNode(srcLocation) {
      override fun toLlvmIrString(): String {
        return "%$result = ${instruction.toLlvmIrString()}"
      }
    }

    sealed class Instruction(srcLocation: SourceLocation) : AstNode(srcLocation) {
      //
//  data class IntegerLiteral(val sourceLocation: SourceLocation, val integer: Int, val type: SilAstNodeType.Simple) : SilAstNodeInstruction(sourceLocation) {
//    override fun toSilString(): String = "integer_literal ${type.toSilString()}, $integer"
//  }
//
//  data class Builtin(val sourceLocation: SourceLocation, val opName: String, val operands: List<SilAstNodeOperand>, val returnType: SilAstNodeType) : SilAstNodeInstruction(sourceLocation) {
//    override fun toSilString(): String = "builtin $opName (${operands.joinToString(separator = ", ") { it.toSilString() }}) : ${returnType.toSilString()}"
//  }
//
//  data class FunctionRef(val sourceLocation: SourceLocation, val name: String, val type: SilAstNodeType.Function) : SilAstNodeInstruction(sourceLocation)  {
//    override fun toSilString(): String = "function_ref @$name : \$${type.toSilString()}"
//  }
//
      data class Mul(val sourceLocation: SourceLocation, val returnType: Type.Simple, val lhs: String, val rhs: String) : Instruction(sourceLocation) {
        override fun toLlvmIrString(): String = "mul ${returnType.toLlvmIrString()} %$lhs, %$rhs"
      }

      data class Call(val sourceLocation: SourceLocation, val functionValue: String, val argumentValues: List<String>, val returnType: Type.Function) : Instruction(sourceLocation) {
        override fun toLlvmIrString(): String = "apply $functionValue (${argumentValues.joinToString(", ")}) : \$${returnType.toLlvmIrString()}"
      }
    }


  }
}


//
//data class SilAstNodeJumpTarget(override val srcLocation: SourceLocation, val identifier: String, val operands: List<SilAstNodeOperand>) : SilAstNode(srcLocation) {
//  override fun toSilString(): String {
//    return "$identifier(${this.operands.joinToString(separator = ", ") { it.toSilString() }})"
//  }
//}
//


//
//


