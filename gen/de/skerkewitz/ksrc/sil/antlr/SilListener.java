// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/java/de/skerkewitz/ksrc/sil/antlr\Sil.g4 by ANTLR 4.7.2
package de.skerkewitz.ksrc.sil.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SilParser}.
 */
public interface SilListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SilParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void enterTranslation_unit(SilParser.Translation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void exitTranslation_unit(SilParser.Translation_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_type}.
	 * @param ctx the parse tree
	 */
	void enterSil_type(SilParser.Sil_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_type}.
	 * @param ctx the parse tree
	 */
	void exitSil_type(SilParser.Sil_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_types}.
	 * @param ctx the parse tree
	 */
	void enterSil_types(SilParser.Sil_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_types}.
	 * @param ctx the parse tree
	 */
	void exitSil_types(SilParser.Sil_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_function_type}.
	 * @param ctx the parse tree
	 */
	void enterSil_function_type(SilParser.Sil_function_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_function_type}.
	 * @param ctx the parse tree
	 */
	void exitSil_function_type(SilParser.Sil_function_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_function_type_arguments}.
	 * @param ctx the parse tree
	 */
	void enterSil_function_type_arguments(SilParser.Sil_function_type_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_function_type_arguments}.
	 * @param ctx the parse tree
	 */
	void exitSil_function_type_arguments(SilParser.Sil_function_type_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Simple}
	 * labeled alternative in {@link SilParser#sil_basic_type}.
	 * @param ctx the parse tree
	 */
	void enterSimple(SilParser.SimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Simple}
	 * labeled alternative in {@link SilParser#sil_basic_type}.
	 * @param ctx the parse tree
	 */
	void exitSimple(SilParser.SimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pointer}
	 * labeled alternative in {@link SilParser#sil_basic_type}.
	 * @param ctx the parse tree
	 */
	void enterPointer(SilParser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pointer}
	 * labeled alternative in {@link SilParser#sil_basic_type}.
	 * @param ctx the parse tree
	 */
	void exitPointer(SilParser.PointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_identifier}.
	 * @param ctx the parse tree
	 */
	void enterSil_identifier(SilParser.Sil_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_identifier}.
	 * @param ctx the parse tree
	 */
	void exitSil_identifier(SilParser.Sil_identifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_value}.
	 * @param ctx the parse tree
	 */
	void enterSil_value(SilParser.Sil_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_value}.
	 * @param ctx the parse tree
	 */
	void exitSil_value(SilParser.Sil_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_operand}.
	 * @param ctx the parse tree
	 */
	void enterSil_operand(SilParser.Sil_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_operand}.
	 * @param ctx the parse tree
	 */
	void exitSil_operand(SilParser.Sil_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_function}.
	 * @param ctx the parse tree
	 */
	void enterSil_function(SilParser.Sil_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_function}.
	 * @param ctx the parse tree
	 */
	void exitSil_function(SilParser.Sil_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_function_name}.
	 * @param ctx the parse tree
	 */
	void enterSil_function_name(SilParser.Sil_function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_function_name}.
	 * @param ctx the parse tree
	 */
	void exitSil_function_name(SilParser.Sil_function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_basic_block}.
	 * @param ctx the parse tree
	 */
	void enterSil_basic_block(SilParser.Sil_basic_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_basic_block}.
	 * @param ctx the parse tree
	 */
	void exitSil_basic_block(SilParser.Sil_basic_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_label_target}.
	 * @param ctx the parse tree
	 */
	void enterSil_label_target(SilParser.Sil_label_targetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_label_target}.
	 * @param ctx the parse tree
	 */
	void exitSil_label_target(SilParser.Sil_label_targetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_label}.
	 * @param ctx the parse tree
	 */
	void enterSil_label(SilParser.Sil_labelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_label}.
	 * @param ctx the parse tree
	 */
	void exitSil_label(SilParser.Sil_labelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction_result}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction_result(SilParser.Sil_instruction_resultContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction_result}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction_result(SilParser.Sil_instruction_resultContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction_def}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction_def(SilParser.Sil_instruction_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction_def}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction_def(SilParser.Sil_instruction_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_terminator}.
	 * @param ctx the parse tree
	 */
	void enterSil_terminator(SilParser.Sil_terminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_terminator}.
	 * @param ctx the parse tree
	 */
	void exitSil_terminator(SilParser.Sil_terminatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_terminator_return}.
	 * @param ctx the parse tree
	 */
	void enterSil_terminator_return(SilParser.Sil_terminator_returnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_terminator_return}.
	 * @param ctx the parse tree
	 */
	void exitSil_terminator_return(SilParser.Sil_terminator_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_terminator_br}.
	 * @param ctx the parse tree
	 */
	void enterSil_terminator_br(SilParser.Sil_terminator_brContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_terminator_br}.
	 * @param ctx the parse tree
	 */
	void exitSil_terminator_br(SilParser.Sil_terminator_brContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_terminator_cond_br}.
	 * @param ctx the parse tree
	 */
	void enterSil_terminator_cond_br(SilParser.Sil_terminator_cond_brContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_terminator_cond_br}.
	 * @param ctx the parse tree
	 */
	void exitSil_terminator_cond_br(SilParser.Sil_terminator_cond_brContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction(SilParser.Sil_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction(SilParser.Sil_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction_integer_literal}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction_integer_literal(SilParser.Sil_instruction_integer_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction_integer_literal}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction_integer_literal(SilParser.Sil_instruction_integer_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction_buildin}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction_buildin(SilParser.Sil_instruction_buildinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction_buildin}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction_buildin(SilParser.Sil_instruction_buildinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction_function_ref}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction_function_ref(SilParser.Sil_instruction_function_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction_function_ref}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction_function_ref(SilParser.Sil_instruction_function_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#sil_instruction_apply}.
	 * @param ctx the parse tree
	 */
	void enterSil_instruction_apply(SilParser.Sil_instruction_applyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#sil_instruction_apply}.
	 * @param ctx the parse tree
	 */
	void exitSil_instruction_apply(SilParser.Sil_instruction_applyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SilParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(SilParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SilParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(SilParser.IntegerContext ctx);
}