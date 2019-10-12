package de.skerkewitz.ksrc.llvm.ir.gen

import de.skerkewitz.ksrc.sil.SilAstParser
import de.skerkewitz.ksrc.sil.antlr.SilParserUtil
import de.skerkewitz.ksrc.sil.ast.*
import de.skerkewitz.ksrc.sil.validator.ErrorEmitter
import de.skerkewitz.ksrc.sil.validator.FunctionValidatorImpl
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.InputStream
import java.net.URL

internal class SilToIrGeneratorTest {

  @Test
  fun instructionDefinitionBuiltIn() {

    val input =    "%eq = builtin \"eq\"(%zero : \$Builtin.Int, %n : \$Builtin.Int) : \$Builtin.Int"
    val expected = "%eq = icmp eq i32 %zero, %n"

    val instructionDef = SilParserUtil.parserFromString(input).sil_instruction_def()
    val instructionDefAst = Builder().visitSil_instruction_def(instructionDef) as SilAstNodeInstructionDefinition

    println("SIL: ${instructionDefAst.toSilString()}")

    val irInstructionDef = SilToIrGenerator.intructionDefinition(instructionDefAst)

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

  @Test
  fun basicBlock() {

    val input =    """
      is_zero(%n: §Builtin.Int):
        %0 = builtin "eq"(%zero : §Builtin.Int, %n : §Builtin.Int) : §Builtin.Int
        return %n : §Builtin.Int
    """.replace('§', '$')
    val expected = "br i1 %0, label %is_zero, label %is_not_zero"

    val node = SilParserUtil.parserFromString(input).sil_basic_block()
    val silTerminatorNode = Builder().visitSil_basic_block(node) as SilAstNodeBlock

    println("SIL: ${silTerminatorNode.toSilString()}")

    val irInstructionDef = SilToIrGenerator.basicBlock(silTerminatorNode)
//
    val output = irInstructionDef.toLlvmIrString()
    println("IR:  $output")
//
//    assertEquals(expected, output)
  }

  @Test
  fun function() {

    val input =    """
    sil @fib : ${'$'}(Builtin.Int) -> Builtin.Int {
      is_zero(%n: §Builtin.Int):
        %0 = builtin "eq"(%zero : §Builtin.Int, %n : §Builtin.Int) : §Builtin.Int
        return %n : §Builtin.Int
    """.replace('§', '$')

    val expected = "br i1 %0, label %is_zero, label %is_not_zero"

    val node = SilParserUtil.parserFromString(input).translation_unit()
    val silTerminatorNode = Builder().visitTranslation_unit(node) as SilAstNodeFunction

    println("SIL: ${silTerminatorNode.toSilString()}")

    val irInstructionDef = SilToIrGenerator.function(silTerminatorNode)
//
    val output = irInstructionDef.toLlvmIrString()
    println("IR:  $output")
//
//    assertEquals(expected, output)
  }

  @Test
  fun functionFib() {

    val resource: URL = this.javaClass.getResource("fib.sil")
    val inputStream: InputStream? = resource.openStream()
    val silFunction = SilAstParser.parse(CharStreams.fromStream(inputStream)) as SilAstNodeFunction
    println("${silFunction.toSilString()}")

    FunctionValidatorImpl.validate(silFunction, ErrorEmitter)

    println("SIL: ${silFunction.toSilString()}")

    val irFunction = SilToIrGenerator.function(silFunction)
//
    val output = irFunction.toLlvmIrString()
    println("IR:  $output")
//
//    assertEquals(expected, output)
  }






}