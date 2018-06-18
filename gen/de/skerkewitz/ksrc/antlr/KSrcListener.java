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
	 * Enter a parse tree produced by the {@code DeclLet}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclLet(KSrcParser.DeclLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclLet}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclLet(KSrcParser.DeclLetContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSub(KSrcParser.ExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSub(KSrcParser.ExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMul(KSrcParser.ExprMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMul(KSrcParser.ExprMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprEqual(KSrcParser.ExprEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprEqual(KSrcParser.ExprEqualContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprDiv(KSrcParser.ExprDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprDiv(KSrcParser.ExprDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(KSrcParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(KSrcParser.ExprAddContext ctx);
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
	 * Enter a parse tree produced by the {@code DeclFunc}
	 * labeled alternative in {@link KSrcParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclFunc(KSrcParser.DeclFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclFunc}
	 * labeled alternative in {@link KSrcParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclFunc(KSrcParser.DeclFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionParameters}
	 * labeled alternative in {@link KSrcParser#func_params}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(KSrcParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionParameters}
	 * labeled alternative in {@link KSrcParser#func_params}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(KSrcParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionParameter}
	 * labeled alternative in {@link KSrcParser#func_param}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(KSrcParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionParameter}
	 * labeled alternative in {@link KSrcParser#func_param}.
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