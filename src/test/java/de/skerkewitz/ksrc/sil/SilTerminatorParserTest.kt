package de.skerkewitz.ksrc.sil

import de.skerkewitz.ksrc.sil.antlr.SilParserUtil
import de.skerkewitz.ksrc.sil.ast.Builder
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstruction
import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstructionDefinition
import de.skerkewitz.ksrc.sil.ast.SilAstNodeTerminator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class SilTerminatorParserTest {

    @Test
    fun parseBranchConditionally() {

        val silInstructionDef = "cond_br %0 : \$Builtin.Int, is_zero (%n : \$Buildin.Int), is_not_zero (%n : \$Buildin.Int)"

        val node = SilParserUtil.parserFromString(silInstructionDef).sil_terminator()
        val silInstructionNode = Builder().visitSil_terminator(node) as SilAstNodeTerminator.BranchConditionally

        print("SIL: ${silInstructionNode.toSilString()}")

        assertEquals("%0", silInstructionNode.condition.identifier)
        assertEquals("Builtin.Int", silInstructionNode.condition.type.toSilString())
    }

}