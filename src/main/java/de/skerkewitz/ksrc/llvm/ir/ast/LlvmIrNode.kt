package de.skerkewitz.ksrc.llvm.ir.ast

import de.skerkewitz.ksrc.common.SourceLocation


class LlvmIr {

  data class Module(val name: String)

  sealed class Node(open val srcLocation: SourceLocation) {
    abstract fun toLlvmIrString(): String

    data class Function(
            val sourceLocation: SourceLocation,
            val functionName: String,
            val returnType: Type,
            val arguments: List<Operand>,
            val blocks: List<BasicBlock>) : Node(sourceLocation) {

      override fun toLlvmIrString(): String {
        return """
      |define ${returnType.toLlvmIrString()} @$functionName (${arguments.joinToString(", ") { it.toLlvmIrString() }}) {
      |${blocks.joinToString(separator = "\n  ", prefix = "  ") { it.toLlvmIrString() }}
      |}
      |""".trimMargin()
      }
    }

    data class Operand(override val srcLocation: SourceLocation, val identifier: String, val type: Type) : Node(srcLocation) {
      override fun toLlvmIrString(): String {
        return "${type.toLlvmIrString()} %$identifier"
      }
    }

    sealed class Type(srcLocation: SourceLocation) : Node(srcLocation) {

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

    data class BasicBlock(override val srcLocation: SourceLocation, val identifier: String, val instructionsDefinitions: List<Node>, val terminator: TerminatorInstruction) : Node(srcLocation) {

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

    sealed class TerminatorInstruction(srcLocation: SourceLocation) : Node(srcLocation) {

      data class Return(val sourceLocation: SourceLocation, val operand: Operand) : TerminatorInstruction(sourceLocation) {
        override fun toLlvmIrString(): String = "ret ${operand.toLlvmIrString()}"
      }

      data class UnconditionalBranch(val sourceLocation: SourceLocation, val jumpTarget: String) : TerminatorInstruction(sourceLocation) {
        override fun toLlvmIrString(): String {
          return "br label %$jumpTarget"
        }
      }

      data class ConditionalBranch(val sourceLocation: SourceLocation, val condition: Operand, val thenJumpTarget: String, val elseJumpTarget: String) : TerminatorInstruction(sourceLocation) {
        override fun toLlvmIrString(): String {
          return "br ${condition.toLlvmIrString()}, label %$thenJumpTarget, label %$elseJumpTarget"
        }
      }
    }

    data class InstructionDefinition(override val srcLocation: SourceLocation, val result: String, val instruction: Instruction) : Node(srcLocation) {
      override fun toLlvmIrString(): String {
        return "%$result = ${instruction.toLlvmIrString()}"
      }
    }

    sealed class Instruction(srcLocation: SourceLocation) : Node(srcLocation) {
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
      /**
       * The ‘icmp’ instruction returns a boolean value or a vector of boolean values based on comparison of its two integer,
       * integer vector, pointer, or pointer vector operands.
       */
      data class IntegerCompare(val sourceLocation: SourceLocation, val condition: Condition, val type: Type.Simple, val lhs: String, val rhs: String) : Instruction(sourceLocation) {

        /** The ‘icmp’ compares op1 and op2 according to the given condition. */
        enum class Condition(val s: String) {

          /** yields true if the operands are equal, false otherwise. No sign interpretation is necessary or performed. */
          Equal("eq"),

          /** yields true if the operands are unequal, false otherwise. No sign interpretation is necessary or performed. */
          NotEqual("ne"),

          /** interprets the operands as unsigned values and yields true if op1 is greater than op2. */
          UnsignedGreaterThan("ugt"),

          /** uge: interprets the operands as unsigned values and yields true if op1 is greater than or equal to op2. */
          UnsignedGreaterOrEqual("uge"),

          /** ult: interprets the operands as unsigned values and yields true if op1 is less than op2. */
          UnsignedLessThan("ult"),

          /** ule: interprets the operands as unsigned values and yields true if op1 is less than or equal to op2. */
          UnsignedLessOrEqual("ule"),

          /** interprets the operands as signed values and yields true if op1 is greater than op2. */
          SignedGreaterThan("sgt"),

          /** interprets the operands as signed values and yields true if op1 is greater than or equal to op2. */
          SignedGreaterOrEqual("sge"),

          /** interprets the operands as signed values and yields true if op1 is less than op2. */
          SignedLessThan("slt"),

          /** sle: interprets the operands as signed values and yields true if op1 is less than or equal to op2. */
          SignedLessOrEqual("sle")
        }
        override fun toLlvmIrString(): String = "icmp ${condition.s} ${type.toLlvmIrString()} %$lhs, %$rhs"
      }

      data class Mul(val sourceLocation: SourceLocation, val returnType: Type.Simple, val lhs: String, val rhs: String) : Instruction(sourceLocation) {
        override fun toLlvmIrString(): String = "mul ${returnType.toLlvmIrString()} %$lhs, %$rhs"
      }

      data class Sub(val sourceLocation: SourceLocation, val returnType: Type.Simple, val lhs: String, val rhs: String) : Instruction(sourceLocation) {
        override fun toLlvmIrString(): String = "sub ${returnType.toLlvmIrString()} %$lhs, %$rhs"
      }

      data class Add(val sourceLocation: SourceLocation, val returnType: Type.Simple, val lhs: String, val rhs: String) : Instruction(sourceLocation) {
        override fun toLlvmIrString(): String = "add ${returnType.toLlvmIrString()} %$lhs, %$rhs"
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


