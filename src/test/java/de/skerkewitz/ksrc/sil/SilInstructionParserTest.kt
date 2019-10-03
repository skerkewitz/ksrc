package de.skerkewitz.ksrc.sil

import de.skerkewitz.ksrc.sil.antlr.SilParserUtil
import de.skerkewitz.ksrc.sil.ast.Builder
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstruction
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstructionDefinition
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class SilInstructionParserTest {

  @Test
  fun parseIntegerLiteral() {

    val silInstructionDef = "%zero = integer_literal \$Builtin.Int, 0"

    val node = SilParserUtil.parserFromString(silInstructionDef).sil_instruction_def()
    val silInstructionNode = Builder().visitSil_instruction_def(node) as SilAstNodeInstructionDefinition

    print("SIL: ${silInstructionNode.toSilString()}")

    assertNotNull(silInstructionNode)
    assertEquals("%zero", silInstructionNode.result)

    val integerLiteral = silInstructionNode.instruction as SilAstNodeInstruction.IntegerLiteral
    assertEquals(0, integerLiteral.integer)
    assertEquals("Builtin.Int", integerLiteral.type.name)

  }

  @Test
  fun parseBuiltin() {

    val silInstructionDef = "%0 = builtin \"eq\"(%zero : \$Builtin.Int, %n : \$Builtin.Int) : \$Builtin.Int"

    val node = SilParserUtil.parserFromString(silInstructionDef).sil_instruction_def()
    val silInstructionNode = Builder().visitSil_instruction_def(node) as SilAstNodeInstructionDefinition

    print("SIL: ${silInstructionNode.toSilString()}")

    assertNotNull(silInstructionNode)
    assertEquals("%0", silInstructionNode.result)

    val integerLiteral = silInstructionNode.instruction as SilAstNodeInstruction.Builtin
    assertEquals("\"eq\"", integerLiteral.opName)
    assertEquals("Builtin.Int", integerLiteral.returnType.toSilString())
  }

  @Test
  fun parseFunctionRef() {

    val silInstructionDef = "%fib = function_ref @foo : \$(Builtin.Int) -> Builtin.Int"

    val node = SilParserUtil.parserFromString(silInstructionDef).sil_instruction_def()
    val silInstructionNode = Builder().visitSil_instruction_def(node) as SilAstNodeInstructionDefinition

    print("SIL: ${silInstructionNode.toSilString()}")

    assertNotNull(silInstructionNode)
    assertEquals("%fib", silInstructionNode.result)

    val integerLiteral = silInstructionNode.instruction as SilAstNodeInstruction.FunctionRef
    assertEquals("foo", integerLiteral.name)
    assertEquals("(Builtin.Int) -> Builtin.Int", integerLiteral.type.toSilString())
  }

  @Test
  fun parseApply() {
    val silInstructionDef = "%result = apply %fib(%first, %second) : \$(Builtin.Int) -> Builtin.Int"

    val node = SilParserUtil.parserFromString(silInstructionDef).sil_instruction_def()
    val silInstructionNode = Builder().visitSil_instruction_def(node) as SilAstNodeInstructionDefinition

    print("SIL: ${silInstructionNode.toSilString()}")

    assertNotNull(silInstructionNode)
    assertEquals("%result", silInstructionNode.result)

    val integerLiteral = silInstructionNode.instruction as SilAstNodeInstruction.Apply
    assertEquals("%fib", integerLiteral.functionValue)
    assertEquals("%first, %second", integerLiteral.argumentValues.joinToString(", "))
    assertEquals("(Builtin.Int) -> Builtin.Int", integerLiteral.returnType.toSilString())
  }

}