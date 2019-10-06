package de.skerkewitz.ksrc.llvm.ir.ast

import de.skerkewitz.ksrc.common.SourceLocation
import org.junit.jupiter.api.Test

internal class LlvmIrTest {


  @Test
  fun test() {

    val sourceLocation = SourceLocation(null, null)

    val typeI32 = LlvmIr.AstNode.Type.Simple(sourceLocation, "i32")
    val arguments = arrayListOf(LlvmIr.AstNode.Operand(sourceLocation, "a", typeI32))

    val returnInstruction = LlvmIr.AstNode.TerminatorInstruction.Return(sourceLocation, LlvmIr.AstNode.Operand(sourceLocation, "1", typeI32))

    val mul = LlvmIr.AstNode.Instruction.Mul(sourceLocation, typeI32, "a", "b")
    val instructionDef =  LlvmIr.AstNode.InstructionDefinition(sourceLocation, "1", mul)

    val basicBlock = LlvmIr.AstNode.BasicBlock(sourceLocation, "entry", arrayListOf(instructionDef), returnInstruction)

    val f = LlvmIr.AstNode.Function(sourceLocation, "test", typeI32, arguments, arrayListOf(basicBlock))

    println(f.toLlvmIrString())

  }



}