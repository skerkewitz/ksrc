package de.skerkewitz.ksrc.sil.ast

import de.skerkewitz.ksrc.common.SourceLocation
import de.skerkewitz.ksrc.sil.antlr.SilBaseVisitor
import de.skerkewitz.ksrc.sil.antlr.SilParser.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RuleContext

class Builder : SilBaseVisitor<SilAstNode?>() {

  /* Util method. */
  private fun <T> visit(ctx: RuleContext, type: Class<T>): T {
    return type.cast(visit(ctx))
  }

  override fun visitTranslation_unit(ctx: Translation_unitContext): SilAstNode {

    val sil_functionContext: Sil_functionContext = ctx.sil_function()

    /* Convert all blocks */
    val blocks = sil_functionContext.sil_basic_block().mapNotNull { visit(it, SilAstNodeBlock::class.java) }
    val functionName: String = sil_functionContext.sil_function_name().text
    val type = visit(sil_functionContext.sil_type(), SilAstNodeType.Function::class.java)
    return SilAstNodeFunction(SourceLocation.fromContext(ctx), functionName, type, blocks)
  }

  override fun visitSil_function_type(ctx: Sil_function_typeContext): SilAstNode {
    val map = ctx.sil_function_type_arguments().sil_types().mapNotNull { visit(it, SilAstNodeType::class.java) }
    val returnType = visit(ctx.returnType, SilAstNodeType::class.java)
    return SilAstNodeType.Function(src(ctx), map, returnType)
  }

  override fun visitSimple(ctx: SimpleContext): SilAstNode {
    return SilAstNodeType.Simple(src(ctx), ctx.sil_identifier().text)
  }

  override fun visitSil_basic_block(ctx: Sil_basic_blockContext): SilAstNode {

    val silLabel = ctx.sil_label()

    val identifier = silLabel.sil_identifier().text
    val arguments = silLabel.sil_operand().mapNotNull { visit(it, SilAstNodeOperand::class.java) }

    val instructionDefinitions = ctx.sil_instruction_def().mapNotNull { visit(it, SilAstNodeInstructionDefinition::class.java) }
    val terminator = visit(ctx.sil_terminator(), SilAstNodeTerminator::class.java)

    return SilAstNodeBlock(src(ctx), identifier, arguments, instructionDefinitions, terminator)
  }

  override fun visitSil_terminator_return(ctx: Sil_terminator_returnContext): SilAstNode {
    val operand = visit(ctx.sil_operand(), SilAstNodeOperand::class.java)
    return SilAstNodeTerminator.Return(src(ctx), operand)
  }

  override fun visitSil_terminator_br(ctx: Sil_terminator_brContext): SilAstNode {
    val jumpTarget = visit(ctx.sil_label_target(), SilAstNodeJumpTarget::class.java)
    return SilAstNodeTerminator.Branch(src(ctx), jumpTarget)
  }

  override fun visitSil_terminator_cond_br(ctx: Sil_terminator_cond_brContext): SilAstNode {

    val condition = visit(ctx.condition, SilAstNodeOperand::class.java)
    val thenLabel = visit(ctx.thenLabel, SilAstNodeJumpTarget::class.java)
    val elseLabel = visit(ctx.elseLabel, SilAstNodeJumpTarget::class.java)

    return SilAstNodeTerminator.BranchConditionally(src(ctx), condition, thenLabel, elseLabel)
  }

  override fun visitSil_instruction_def(ctx: Sil_instruction_defContext): SilAstNode {

    val instruction = visit(ctx.sil_instruction(), SilAstNodeInstruction::class.java)
    val result = ctx.sil_instruction_result().SIL_VALUE_NAME().text

    return SilAstNodeInstructionDefinition(src(ctx), result, instruction)
  }


  override fun visitSil_instruction_integer_literal(ctx: Sil_instruction_integer_literalContext): SilAstNode {
    val integer = ctx.integer().text.toInt()
    val type = visit(ctx.sil_type(), SilAstNodeType.Simple::class.java)
    return SilAstNodeInstruction.IntegerLiteral(src(ctx), integer, type)
  }

  override fun visitSil_instruction_buildin(ctx: Sil_instruction_buildinContext): SilAstNode {
    val opName = ctx.STRING().text

    val operands = ctx.sil_operand().mapNotNull { visit(it, SilAstNodeOperand::class.java) }
    val returnType = visit(ctx.sil_type(), SilAstNodeType::class.java)

    return SilAstNodeInstruction.Builtin(src(ctx), opName, operands, returnType)
  }

  override fun visitSil_instruction_function_ref(ctx: Sil_instruction_function_refContext): SilAstNode {

    val name = ctx.sil_function_name().NAME().text
    val type = visit(ctx.sil_type(), SilAstNodeType.Function::class.java)

    return SilAstNodeInstruction.FunctionRef(src(ctx), name, type)
  }

  override fun visitSil_instruction_apply(ctx: Sil_instruction_applyContext): SilAstNode {
    val functionValue = ctx.function.SIL_VALUE_NAME().text

    // Drop first as it is the same a the function value
    val argumentValues = ctx.sil_value().drop(1).mapNotNull { it.SIL_VALUE_NAME().text }
    val returnType = visit(ctx.returnType, SilAstNodeType.Function::class.java)

    return SilAstNodeInstruction.Apply(src(ctx), functionValue, argumentValues, returnType)
  }

  override fun visitSil_operand(ctx: Sil_operandContext): SilAstNode {
    val type = visit(ctx.sil_type(), SilAstNodeType::class.java)
    return SilAstNodeOperand(src(ctx), ctx.sil_value().text, type)
  }

  override fun visitSil_label_target(ctx: Sil_label_targetContext): SilAstNode {
    val identifier = ctx.sil_identifier().text
    val operands = ctx.sil_operand().mapNotNull { visit(it, SilAstNodeOperand::class.java) }
    return SilAstNodeJumpTarget(src(ctx), identifier, operands)
  }

  private fun src(ctx: ParserRuleContext): SourceLocation {
    return SourceLocation.fromContext(ctx)
  }
}