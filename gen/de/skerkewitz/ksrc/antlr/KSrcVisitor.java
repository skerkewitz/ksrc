// Generated from C:/Users/stefa/IdeaProjects/kode/src/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link KSrcParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(KSrcParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclLet}
	 * labeled alternative in {@link KSrcParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclLet(KSrcParser.DeclLetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link KSrcParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(KSrcParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(KSrcParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMul(KSrcParser.ExprMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDiv(KSrcParser.ExprDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(KSrcParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncArguments}
	 * labeled alternative in {@link KSrcParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArguments(KSrcParser.FuncArgumentsContext ctx);
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
	 * Visit a parse tree produced by {@link KSrcParser#func_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body(KSrcParser.Func_bodyContext ctx);
}