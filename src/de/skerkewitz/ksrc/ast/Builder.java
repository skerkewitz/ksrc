package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcBaseVisitor;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class Builder extends KSrcBaseVisitor<AstStatement> {

	@Override
	public AstStatement visitStmt_list(KSrcParser.Stmt_listContext ctx) {

		/* Get the parameters. */
		final int childCount = ctx.getChildCount();

		final AstStatement[] args = new AstStatement[childCount];
		for (var i = 0; i < childCount; ++i) {
			args[i] = visit(ctx.children.get(i));
		}

		return new AstStatements(args);
	}

	@Override
	public AstStatement visitFile_input(KSrcParser.File_inputContext ctx) {
		/* Get the parameters. */
		final int childCount = ctx.getChildCount();

		var args = new AstStatement[childCount - 1];
		for (int i = 0; i < childCount - 1; ++i) {
			args[i] = visit(ctx.children.get(i));
		}

		return new AstStatements(args);
	}

	@Override
	public AstStatement visitDeclFunc(KSrcParser.DeclFuncContext ctx) {
		var hasParameter = ctx.getChildCount() == 6;

		var ident = (AstExpressionIdent) visit(ctx.children.get(1));
		AstExpressionIdent[] params;
		if (hasParameter) {
			ParseTree tree = ctx.children.get(3);
			/* Get the parameters. */
			final int childCount = tree.getChildCount();

			params = new AstExpressionIdent[childCount];
			for (int i = 0; i < childCount; ++i) {
				params[i] = (AstExpressionIdent) visit(tree.getChild(i));
			}
		} else {
			params = null;
		}

		var expr = (AstStatements) visit(ctx.children.get(hasParameter ? 5 : 2));
		return new AstStatementDeclFunc(ident, params, expr);
	}

	@Override
	public AstStatement visitFunctionBody(KSrcParser.FunctionBodyContext ctx) {

		/* Get the parameters. */
		final int childCount = ctx.getChildCount();

		var args = new AstStatement[childCount - 2];
		for (int i = 1; i < childCount - 1; ++i) {
			args[i - 1] = visit(ctx.children.get(i));
		}

		return new AstStatements(args);
	}

	@Override
	public AstStatement visitDeclLet(KSrcParser.DeclLetContext ctx) {
		var ident = (AstExpressionIdent) visit(ctx.children.get(1));
		var expr = (AstExpression) visit(ctx.children.get(3));
		return new AstStatementDeclLet(ident, expr);
	}

	@Override
	public AstStatement visitExprMul(KSrcParser.ExprMulContext ctx) {
		var lhs = (AstExpression) visit(ctx.children.get(0));
		var rhs = (AstExpression) visit(ctx.children.get(2));
		return new AstExpressionMul(lhs, rhs);
	}

	@Override
	public AstStatement visitExprSub(KSrcParser.ExprSubContext ctx) {
		var lhs = (AstExpression) visit(ctx.children.get(0));
		var rhs = (AstExpression) visit(ctx.children.get(2));
		return new AstExpressionSub(lhs, rhs);
	}

	@Override
	public AstStatement visitIdent(KSrcParser.IdentContext ctx) {
		return new AstExpressionIdent(ctx.NAME().getText());
	}

	@Override
	public AstStatement visitExprCall(KSrcParser.ExprCallContext ctx) {

		/* Get the parameters. */
		final ParseTree arguments = ctx.children.get(2);
		final int childCount = arguments.getChildCount();
		final AstExpression[] args = new AstExpression[childCount];
		for (int i = 0; i < childCount; ++i) {
			args[i] = (AstExpression) visit(arguments);
		}

		return new AstExpressionFuncCall(ctx.NAME().getText(), args);
	}

	@Override
	public AstStatement visitExprValue(KSrcParser.ExprValueContext ctx) {
		return new AstExpressionValue(ctx.getText());
	}
}
