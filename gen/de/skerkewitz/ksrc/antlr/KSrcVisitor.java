// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/java/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
package de.skerkewitz.ksrc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KSrcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KSrcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KSrcParser#translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslation_unit(KSrcParser.Translation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(KSrcParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(KSrcParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link KSrcParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(KSrcParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#loop_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_statement(KSrcParser.Loop_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link KSrcParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(KSrcParser.StatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(KSrcParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link KSrcParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(KSrcParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStatement}
	 * labeled alternative in {@link KSrcParser#break_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(KSrcParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAssign}
	 * labeled alternative in {@link KSrcParser#assign_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAssign(KSrcParser.StatementAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationConstant}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationConstant(KSrcParser.DeclarationConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationVariable}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationVariable(KSrcParser.DeclarationVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationFunction}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationFunction(KSrcParser.DeclarationFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationClass}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationClass(KSrcParser.DeclarationClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#constant_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_declaration(KSrcParser.Constant_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(KSrcParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#class_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_declaration(KSrcParser.Class_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declaration(KSrcParser.Function_declarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationFieldVariable}
	 * labeled alternative in {@link KSrcParser#field_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationFieldVariable(KSrcParser.DeclarationFieldVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationFieldConstant}
	 * labeled alternative in {@link KSrcParser#field_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationFieldConstant(KSrcParser.DeclarationFieldConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#type_annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_annotation(KSrcParser.Type_annotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(KSrcParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIdEqual}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdEqual(KSrcParser.ExprIdEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPow}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPow(KSrcParser.ExprPowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParens}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParens(KSrcParser.ExprParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultiplication}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplication(KSrcParser.ExprMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnaryMinus}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaryMinus(KSrcParser.ExprUnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(KSrcParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLogicalOr}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogicalOr(KSrcParser.ExprLogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRelational}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelational(KSrcParser.ExprRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEquality}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEquality(KSrcParser.ExprEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPostFix}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPostFix(KSrcParser.ExprPostFixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdditive}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdditive(KSrcParser.ExprAdditiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLogicalAnd}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogicalAnd(KSrcParser.ExprLogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPrimary}
	 * labeled alternative in {@link KSrcParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimary(KSrcParser.ExprPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprExplicitMemberAccess}
	 * labeled alternative in {@link KSrcParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprExplicitMemberAccess(KSrcParser.ExprExplicitMemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#literal_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_expression(KSrcParser.Literal_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallArgumentClause}
	 * labeled alternative in {@link KSrcParser#function_call_argument_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgumentClause(KSrcParser.FunctionCallArgumentClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallArgumentList}
	 * labeled alternative in {@link KSrcParser#function_call_argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgumentList(KSrcParser.FunctionCallArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#type_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_literal(KSrcParser.Type_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(KSrcParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionSignature}
	 * labeled alternative in {@link KSrcParser#function_signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(KSrcParser.FunctionSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#function_result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_result(KSrcParser.Function_resultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParameters}
	 * labeled alternative in {@link KSrcParser#function_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters(KSrcParser.FunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParameter}
	 * labeled alternative in {@link KSrcParser#function_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(KSrcParser.FunctionParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#statements_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements_list(KSrcParser.Statements_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link KSrcParser#code_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(KSrcParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralInteger}
	 * labeled alternative in {@link KSrcParser#numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralInteger(KSrcParser.LiteralIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralFloat}
	 * labeled alternative in {@link KSrcParser#numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralFloat(KSrcParser.LiteralFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(KSrcParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(KSrcParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#nil_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil_literal(KSrcParser.Nil_literalContext ctx);
}