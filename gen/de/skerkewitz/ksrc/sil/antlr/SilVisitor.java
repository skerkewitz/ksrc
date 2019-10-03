// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/java/de/skerkewitz/ksrc/sil/antlr\Sil.g4 by ANTLR 4.7.2
package de.skerkewitz.ksrc.sil.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SilParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SilVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SilParser#translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslation_unit(SilParser.Translation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_type(SilParser.Sil_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_types(SilParser.Sil_typesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_function_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_function_type(SilParser.Sil_function_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_function_type_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_function_type_arguments(SilParser.Sil_function_type_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Simple}
	 * labeled alternative in {@link SilParser#sil_basic_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(SilParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pointer}
	 * labeled alternative in {@link SilParser#sil_basic_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(SilParser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_identifier(SilParser.Sil_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_value(SilParser.Sil_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_operand(SilParser.Sil_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_function(SilParser.Sil_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_function_name(SilParser.Sil_function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_basic_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_basic_block(SilParser.Sil_basic_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_label_target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_label_target(SilParser.Sil_label_targetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_label(SilParser.Sil_labelContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction_result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction_result(SilParser.Sil_instruction_resultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction_def(SilParser.Sil_instruction_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_terminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_terminator(SilParser.Sil_terminatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_terminator_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_terminator_return(SilParser.Sil_terminator_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_terminator_br}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_terminator_br(SilParser.Sil_terminator_brContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_terminator_cond_br}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_terminator_cond_br(SilParser.Sil_terminator_cond_brContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction(SilParser.Sil_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction_integer_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction_integer_literal(SilParser.Sil_instruction_integer_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction_buildin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction_buildin(SilParser.Sil_instruction_buildinContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction_function_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction_function_ref(SilParser.Sil_instruction_function_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#sil_instruction_apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSil_instruction_apply(SilParser.Sil_instruction_applyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SilParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(SilParser.IntegerContext ctx);
}