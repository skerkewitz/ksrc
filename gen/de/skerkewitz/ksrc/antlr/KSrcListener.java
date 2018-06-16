// Generated from C:/Users/stefa/IdeaProjects/kode/src/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
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
	 * Enter a parse tree produced by {@link KSrcParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(KSrcParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(KSrcParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclLet}
	 * labeled alternative in {@link KSrcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclLet(KSrcParser.DeclLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclLet}
	 * labeled alternative in {@link KSrcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclLet(KSrcParser.DeclLetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link KSrcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpression(KSrcParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link KSrcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpression(KSrcParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCall}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCall(KSrcParser.ExprCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprValue(KSrcParser.ExprValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSub(KSrcParser.ExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSub(KSrcParser.ExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMul(KSrcParser.ExprMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMul(KSrcParser.ExprMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIdent}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIdent(KSrcParser.ExprIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDiv(KSrcParser.ExprDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDiv(KSrcParser.ExprDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(KSrcParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link KSrcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(KSrcParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncArguments}
	 * labeled alternative in {@link KSrcParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterFuncArguments(KSrcParser.FuncArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncArguments}
	 * labeled alternative in {@link KSrcParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitFuncArguments(KSrcParser.FuncArgumentsContext ctx);
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
	 * Enter a parse tree produced by {@link KSrcParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(KSrcParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KSrcParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(KSrcParser.Func_bodyContext ctx);
}