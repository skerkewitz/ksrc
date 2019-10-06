package de.skerkewitz.ksrc.llvm.ir.ast

import de.skerkewitz.ksrc.common.SourceLocation
import org.junit.jupiter.api.Test

internal class LlvmIrTest {


  @Test
  fun test() {
    val sourceLocation = SourceLocation(null, null)

    val typeI32 = LlvmIr.Node.Type.Simple(sourceLocation, "i32")
    val arguments = arrayListOf(LlvmIr.Node.Operand(sourceLocation, "a", typeI32))

    val returnInstruction = LlvmIr.Node.TerminatorInstruction.Return(sourceLocation, LlvmIr.Node.Operand(sourceLocation, "1", typeI32))

    val mul = LlvmIr.Node.Instruction.Mul(sourceLocation, typeI32, "a", "a")
    val instructionDef =  LlvmIr.Node.InstructionDefinition(sourceLocation, "1", mul)

    val basicBlock = LlvmIr.Node.BasicBlock(sourceLocation, "entry", arrayListOf(instructionDef), returnInstruction)

    val f = LlvmIr.Node.Function(sourceLocation, "test", typeI32, arguments, arrayListOf(basicBlock))

    println(f.toLlvmIrString())
  }





}