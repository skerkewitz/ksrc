package de.skerkewitz.ksrc.llvm.ir.gen

import de.skerkewitz.ksrc.sil.antlr.SilParserUtil
import de.skerkewitz.ksrc.sil.ast.Builder
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstructionDefinition
import de.skerkewitz.ksrc.sil.ast.SilAstNodeTerminator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SilToIrGeneratorTest {

  @Test
  fun instructionDefinitionBuiltIn() {

    val input =    "%eq = builtin \"eq\"(%zero : \$Builtin.Int, %n : \$Builtin.Int) : \$Builtin.Int"
    val expected = "%eq = icmp eq i32 %zero, %n"

    val node = SilParserUtil.parserFromString(input).sil_instruction_def()
    val silInstructionNode = Builder().visitSil_instruction_def(node) as SilAstNodeInstructionDefinition

    println("SIL: ${silInstructionNode.toSilString()}")

    val irInstructionDef = SilToIrGenerator.intructionDefinition(silInstructionNode)

    val output = irInstructionDef.toLlvmIrString()
    println("IR:  $output")

    assertEquals(expected, output)
  }

  @Test
  fun terminatorInstructionConditionalBranch() {

    val input =    "cond_br %0 : \$Builtin.Int, is_zero (%n : \$Builtin.Int), is_not_zero (%n : \$Builtin.Int)"
    val expected = "br i1 %0, label %is_zero, label %is_not_zero"

    val node = SilParserUtil.parserFromString(input).sil_terminator()
    val silTerminatorNode = Builder().visitSil_terminator(node) as SilAstNodeTerminator

    println("SIL: ${silTerminatorNode.toSilString()}")

    val irInstructionDef = SilToIrGenerator.terminatorInstruction(silTerminatorNode)

    val output = irInstructionDef.toLlvmIrString()
    println("IR:  $output")

    assertEquals(expected, output)
  }




}