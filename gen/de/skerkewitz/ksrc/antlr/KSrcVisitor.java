// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link KSrcParser#file_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_input(KSrcParser.File_inputContext ctx);
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
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link KSrcParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(KSrcParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclLet}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclLet(KSrcParser.DeclLetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link KSrcParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(KSrcParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(KSrcParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMul(KSrcParser.ExprMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEqual}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEqual(KSrcParser.ExprEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDiv(KSrcParser.ExprDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link KSrcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(KSrcParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallArgumentList}
	 * labeled alternative in {@link KSrcParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgumentList(KSrcParser.FunctionCallArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(KSrcParser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(KSrcParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KSrcParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(KSrcParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclFunc}
	 * labeled alternative in {@link KSrcParser#func_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclFunc(KSrcParser.DeclFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParameters}
	 * labeled alternative in {@link KSrcParser#func_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters(KSrcParser.FunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParameter}
	 * labeled alternative in {@link KSrcParser#func_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(KSrcParser.FunctionParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBlock}
	 * labeled alternative in {@link KSrcParser#code_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(KSrcParser.CodeBlockContext ctx);
}