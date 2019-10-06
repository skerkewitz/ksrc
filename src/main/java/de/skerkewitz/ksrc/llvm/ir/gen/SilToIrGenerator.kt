package de.skerkewitz.ksrc.llvm.ir.gen

import de.skerkewitz.ksrc.llvm.ir.ast.LlvmIr
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstruction
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstructionDefinition
import de.skerkewitz.ksrc.sil.ast.SilAstNodeTerminator


object SilToIrGenerator {

  /**
   * Converts the Sil instruction definition into a IR instruction definition.
   */
  fun intructionDefinition(input: SilAstNodeInstructionDefinition) : LlvmIr.Node.InstructionDefinition {
    val irInstruction = instruction(input.instruction)
    return LlvmIr.Node.InstructionDefinition(input.srcLocation, input.result, irInstruction)
  }

  /**
   * Converts the Sil instruction into a IR instruction definition.
   */
  private fun instruction(instruction: SilAstNodeInstruction): LlvmIr.Node.Instruction {
    when(instruction) {
      is SilAstNodeInstruction.IntegerLiteral -> TODO()
      is SilAstNodeInstruction.Builtin -> {
        val i32 = LlvmIr.Node.Type.Simple(instruction.operands.first().type.srcLocation, "i32")
        val lhs = instruction.operands[0].identifier
        val rhs = instruction.operands[1].identifier
        return LlvmIr.Node.Instruction.IntegerCompare(instruction.sourceLocation, LlvmIr.Node.Instruction.IntegerCompare.Condition.Equal, i32, lhs, rhs)
      }
      is SilAstNodeInstruction.FunctionRef -> TODO()
      is SilAstNodeInstruction.Apply -> TODO()
    }
  }

  fun terminatorInstruction(terminator: SilAstNodeTerminator): LlvmIr.Node.TerminatorInstruction {
    when(terminator) {
      is SilAstNodeTerminator.Return -> TODO()
      is SilAstNodeTerminator.Branch -> TODO()
      is SilAstNodeTerminator.BranchConditionally -> {
        val i1 = LlvmIr.Node.Type.Simple(terminator.condition.srcLocation, "i1")
        val condition = LlvmIr.Node.Operand(terminator.condition.srcLocation, terminator.condition.identifier, i1)
        return LlvmIr.Node.TerminatorInstruction.ConditionalBranch(terminator.sourceLocation, condition, terminator.thenJumpTarget.identifier, terminator.elseJumpTarget.identifier)
      }
    }
  }
}