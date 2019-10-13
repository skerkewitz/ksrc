package de.skerkewitz.ksrc.llvm.ir.gen

import de.skerkewitz.ksrc.llvm.ir.ast.LlvmIr
import de.skerkewitz.ksrc.sil.ast.*
import java.lang.IllegalArgumentException

typealias TConstTable = Map<String, SilAstNodeInstructionDefinition>

object SilToIrGenerator {

  /**
   * Converts the Sil instruction definition into a IR instruction definition.
   */
  fun intructionDefinition(input: SilAstNodeInstructionDefinition, constTable: TConstTable) : LlvmIr.Node.InstructionDefinition {
    val irInstruction = instruction(input.instruction, constTable)
//    if (irInstruction is LlvmIr.Node.Instruction.Nop) {
//
//    }
    return LlvmIr.Node.InstructionDefinition(input.srcLocation, input.result, irInstruction)
  }




  /**
   * Converts the Sil instruction into a IR instruction definition.
   */
  private fun instruction(instruction: SilAstNodeInstruction, constTable: TConstTable): LlvmIr.Node.Instruction {
    return when(instruction) {
      is SilAstNodeInstruction.IntegerLiteral -> LlvmIr.Node.Instruction.Nop(instruction.sourceLocation, instruction.javaClass.simpleName)
      is SilAstNodeInstruction.Builtin -> builtIn(instruction, constTable)
      is SilAstNodeInstruction.FunctionRef -> LlvmIr.Node.Instruction.Nop(instruction.sourceLocation, instruction.javaClass.simpleName)
      is SilAstNodeInstruction.Apply -> LlvmIr.Node.Instruction.Call(instruction.sourceLocation, instruction.functionValue, arrayListOf(), type(instruction.returnType.returnType))
    }
  }

  private fun builtIn(builtin: SilAstNodeInstruction.Builtin, constTable: TConstTable): LlvmIr.Node.Instruction {

    return when(builtin.opName) {
      "eq" -> {
        val i32 = LlvmIr.Node.Type.Simple(builtin.operands.first().type.srcLocation, "i32")
        val lhs = value(builtin.operands[0], constTable)
        val rhs = value(builtin.operands[1], constTable)

        LlvmIr.Node.Instruction.IntegerCompare(builtin.sourceLocation, LlvmIr.Node.Instruction.IntegerCompare.Condition.Equal, i32, lhs, rhs)
      }
      "sub" -> {
        val i32 = LlvmIr.Node.Type.Simple(builtin.operands.first().type.srcLocation, "i32")
        val lhs = value(builtin.operands[0], constTable)
        val rhs = value(builtin.operands[1], constTable)

        LlvmIr.Node.Instruction.Sub(builtin.sourceLocation, i32, lhs, rhs)
      }
      "add" -> {
        val i32 = LlvmIr.Node.Type.Simple(builtin.operands.first().type.srcLocation, "i32")
        val lhs = value(builtin.operands[0], constTable)
        val rhs = value(builtin.operands[1], constTable)

        LlvmIr.Node.Instruction.Add(builtin.sourceLocation, i32, lhs, rhs)
      }

      else -> TODO("Unknown builtin ${builtin.opName}")
    }
  }

  private fun value(identifier: SilAstNodeOperand, constTable: TConstTable): LlvmIr.Node.Value {

    val item = constTable[identifier.identifier]
            ?: return LlvmIr.Node.Value.Ref(identifier.srcLocation, identifier.identifier)

    return when(item.instruction) {
      is SilAstNodeInstruction.IntegerLiteral -> LlvmIr.Node.Value.ConstInt(item.instruction.sourceLocation, item.instruction.integer)

      else -> TODO("should not happen")
    }
  }

  fun typeMapper(typename: String): String {
    return when(typename) {
      "Builtin.Int" -> "i32"
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

  fun basicBlock(basicBlock: SilAstNodeBlock, constTable: TConstTable): LlvmIr.Node.BasicBlock {

    val instructions = basicBlock.instructionsDefinitions
            .map { intructionDefinition(it, constTable) }
            .filter { it.instruction !is LlvmIr.Node.Instruction.Nop }

    return LlvmIr.Node.BasicBlock(basicBlock.srcLocation, basicBlock.identifier, instructions, terminatorInstruction(basicBlock.terminator) )
  }

  fun function(function: SilAstNodeFunction): LlvmIr.Node.Function {

    /* We need to build a const and a function table. */
    val constTable = buildConstTable(function)

    val blocks = function.blocks.map { basicBlock(it, constTable) }

    return LlvmIr.Node.Function(function.sourceLocation, function.functionName,
            type(function.type.returnType), arrayListOf(), blocks)

  }


  private fun buildConstTable(function: SilAstNodeFunction): TConstTable {

    return function.blocks
            .map { buildConstTableFromBlock(it) }
            .reduce { acc, map -> acc + map }
            .also { println(it) }

  }

  private fun buildConstTableFromBlock(block: SilAstNodeBlock): TConstTable {

    return block.instructionsDefinitions
            .filter { it.instruction is SilAstNodeInstruction.IntegerLiteral }
            .map { it.result to it }
            .toMap()
  }
}