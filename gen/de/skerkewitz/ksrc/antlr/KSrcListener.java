// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
package de.skerkewitz.ksrc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KSrcParser}.
 */
public interface KSrcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KSrcParser#file_input}.
	 * @param ctx the parse tree
	 */
	void enterFile_input(KSrcParser.File_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#file_input}.
	 * @param ctx the parse tree
	 */
	void exitFile_input(KSrcParser.File_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(KSrcParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(KSrcParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(KSrcParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(KSrcParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link KSrcParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(KSrcParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link KSrcParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(KSrcParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(KSrcParser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(KSrcParser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link KSrcParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhile(KSrcParser.StatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link KSrcParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhile(KSrcParser.StatementWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(KSrcParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(KSrcParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link KSrcParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(KSrcParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link KSrcParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(KSrcParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementAssign}
	 * labeled alternative in {@link KSrcParser#assign_statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementAssign(KSrcParser.StatementAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementAssign}
	 * labeled alternative in {@link KSrcParser#assign_statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementAssign(KSrcParser.StatementAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationConstant}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationConstant(KSrcParser.DeclarationConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationConstant}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationConstant(KSrcParser.DeclarationConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationVariable}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationVariable(KSrcParser.DeclarationVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationVariable}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationVariable(KSrcParser.DeclarationVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(KSrcParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(KSrcParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#type_annotation}.
	 * @param ctx the parse tree
	 */
	void enterType_annotation(KSrcParser.Type_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#type_annotation}.
	 * @param ctx the parse tree
	 */
	void exitType_annotation(KSrcParser.Type_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(KSrcParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(KSrcParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultiplication}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplication(KSrcParser.ExprMultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultiplication}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplication(KSrcParser.ExprMultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(KSrcParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(KSrcParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLogicalOr}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogicalOr(KSrcParser.ExprLogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLogicalOr}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogicalOr(KSrcParser.ExprLogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRelational}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprRelational(KSrcParser.ExprRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRelational}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprRelational(KSrcParser.ExprRelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAdditive}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAdditive(KSrcParser.ExprAdditiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAdditive}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAdditive(KSrcParser.ExprAdditiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIdEqual}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprIdEqual(KSrcParser.ExprIdEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIdEqual}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprIdEqual(KSrcParser.ExprIdEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPow}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPow(KSrcParser.ExprPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPow}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPow(KSrcParser.ExprPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnaryMinus}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaryMinus(KSrcParser.ExprUnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnaryMinus}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaryMinus(KSrcParser.ExprUnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEquality}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprEquality(KSrcParser.ExprEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEquality}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprEquality(KSrcParser.ExprEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLogicalAnd}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogicalAnd(KSrcParser.ExprLogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLogicalAnd}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogicalAnd(KSrcParser.ExprLogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallArgumentList}
	 * labeled alternative in {@link KSrcParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArgumentList(KSrcParser.FunctionCallArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallArgumentList}
	 * labeled alternative in {@link KSrcParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArgumentList(KSrcParser.FunctionCallArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(KSrcParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(KSrcParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(KSrcParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(KSrcParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(KSrcParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(KSrcParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionSignature}
	 * labeled alternative in {@link KSrcParser#function_signature}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSignature(KSrcParser.FunctionSignatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionSignature}
	 * labeled alternative in {@link KSrcParser#function_signature}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSignature(KSrcParser.FunctionSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link KSrcParser#function_result}.
	 * @param ctx the parse tree
	 */
	void enterFunction_result(KSrcParser.Function_resultContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#function_result}.
	 * @param ctx the parse tree
	 */
	void exitFunction_result(KSrcParser.Function_resultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionParameters}
	 * labeled alternative in {@link KSrcParser#function_parameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(KSrcParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionParameters}
	 * labeled alternative in {@link KSrcParser#function_parameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(KSrcParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionParameter}
	 * labeled alternative in {@link KSrcParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(KSrcParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionParameter}
	 * labeled alternative in {@link KSrcParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(KSrcParser.FunctionParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link KSrcParser#code_block}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(KSrcParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link KSrcParser#code_block}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(KSrcParser.CodeBlockContext ctx);
}