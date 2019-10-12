package de.skerkewitz.ksrc.llvm.ir.gen

import de.skerkewitz.ksrc.llvm.ir.ast.LlvmIr
import de.skerkewitz.ksrc.sil.ast.*
import java.lang.IllegalArgumentException


object SilToIrGenerator {

  /**
   * Converts the Sil instruction definition into a IR instruction definition.
   */
  fun intructionDefinition(input: SilAstNodeInstructionDefinition) : LlvmIr.Node.InstructionDefinition {
    val irInstruction = instruction(input.instruction)
//    if (irInstruction is LlvmIr.Node.Instruction.Nop) {
//
//    }
    return LlvmIr.Node.InstructionDefinition(input.srcLocation, input.result, irInstruction)
  }

  /**
   * Converts the Sil instruction into a IR instruction definition.
   */
  private fun instruction(instruction: SilAstNodeInstruction): LlvmIr.Node.Instruction {
    return when(instruction) {
      is SilAstNodeInstruction.IntegerLiteral -> LlvmIr.Node.Instruction.Nop(instruction.sourceLocation, instruction.javaClass.simpleName)
      is SilAstNodeInstruction.Builtin -> {
        val i32 = LlvmIr.Node.Type.Simple(instruction.operands.first().type.srcLocation, "i32")
        val lhs = instruction.operands[0].identifier
        val rhs = instruction.operands[1].identifier
        LlvmIr.Node.Instruction.IntegerCompare(instruction.sourceLocation, LlvmIr.Node.Instruction.IntegerCompare.Condition.Equal, i32, lhs, rhs)
      }
      is SilAstNodeInstruction.FunctionRef -> LlvmIr.Node.Instruction.Nop(instruction.sourceLocation, instruction.javaClass.simpleName)
      is SilAstNodeInstruction.Apply -> LlvmIr.Node.Instruction.Call(instruction.sourceLocation, instruction.functionValue, arrayListOf(), type(instruction.returnType.returnType))
    }
  }

  fun typeMapper(typename: String): String {
    return when(typename) {
      "Builtin.Int" -> "int32"
      else -> throw IllegalArgumentException("Unknown type '$typename'")
    }
  }


  fun type(type: SilAstNodeType): LlvmIr.Node.Type {
    return when(type) {
      is SilAstNodeType.Simple -> LlvmIr.Node.Type.Simple(type.sourceLocation, typeMapper(type.name))
      is SilAstNodeType.Function -> TODO()
    }
  }

  fun operand(operand: SilAstNodeOperand): LlvmIr.Node.Operand {
    return LlvmIr.Node.Operand(operand.srcLocation, operand.identifier, type(operand.type))
  }

  fun terminatorInstruction(terminator: SilAstNodeTerminator): LlvmIr.Node.TerminatorInstruction {
    return when(terminator) {
      is SilAstNodeTerminator.Return ->
        LlvmIr.Node.TerminatorInstruction.Return(terminator.sourceLocation, operand(terminator.operand))
      is SilAstNodeTerminator.Branch -> TODO()
      is SilAstNodeTerminator.BranchConditionally -> {
        val i1 = LlvmIr.Node.Type.Simple(terminator.condition.srcLocation, "i1")
        val condition = LlvmIr.Node.Operand(terminator.condition.srcLocation, terminator.condition.identifier, i1)
        LlvmIr.Node.TerminatorInstruction.ConditionalBranch(terminator.sourceLocation, condition, terminator.thenJumpTarget.identifier, terminator.elseJumpTarget.identifier)
      }
    }
  }

  fun basicBlock(basicBlock: SilAstNodeBlock): LlvmIr.Node.BasicBlock {

    val instructions = basicBlock.instructionsDefinitions
            .map { intructionDefinition(it) }
            .filter { it.instruction !is LlvmIr.Node.Instruction.Nop }

    return LlvmIr.Node.BasicBlock(basicBlock.srcLocation, basicBlock.identifier,
            instructions, terminatorInstruction(basicBlock.terminator) )
  }

  fun function(function: SilAstNodeFunction): LlvmIr.Node.Function {

    val blocks = function.blocks.map { basicBlock(it) }

    return LlvmIr.Node.Function(function.sourceLocation, function.functionName,
            type(function.type.returnType), arrayListOf(), blocks)

  }
}