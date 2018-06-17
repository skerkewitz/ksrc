package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcBaseVisitor;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.antlr.SourceLocation;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Builder extends KSrcBaseVisitor<AstStatement> {

  @Override
  public AstStatement visitStmt_list(KSrcParser.Stmt_listContext ctx) {

    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    final AstStatement[] args = new AstStatement[childCount];
    for (var i = 0; i < childCount; ++i) {
      args[i] = visit(ctx.children.get(i));
    }

    return new AstStatements(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStatement visitFile_input(KSrcParser.File_inputContext ctx) {
    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    var args = new AstStatement[childCount - 1];
    for (int i = 0; i < childCount - 1; ++i) {
      args[i] = visit(ctx.children.get(i));
    }

    return new AstStatements(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStatement visitDeclFunc(KSrcParser.DeclFuncContext ctx) {
    var hasParameter = ctx.getChildCount() == 6;

    var ident = (AstExprIdent) visit(ctx.children.get(1));
    AstExprIdent[] params;
    if (hasParameter) {
      ParseTree tree = ctx.children.get(3);
      /* Get the parameters. */
      final int childCount = tree.getChildCount();

      List<AstExprIdent> result = new ArrayList<>(childCount);
      for (int i = 0; i < childCount; ++i) {
        ParseTree child = tree.getChild(i);
        if (!(child instanceof TerminalNode)) {
          result.add((AstExprIdent) visit(child));
        }
      }
      params = result.toArray(new AstExprIdent[result.size()]);
    } else {
      params = null;
    }

    var expr = (AstStatements) visit(ctx.children.get(hasParameter ? 5 : 2));
    var srcLoc = new SourceLocation(ctx.start, ctx.stop);
    return new AstStatementDeclFunc(srcLoc, ident, params, expr);
  }

  @Override
  public AstStatement visitFunctionBody(KSrcParser.FunctionBodyContext ctx) {

    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    var args = new AstStatement[childCount - 2];
    for (int i = 1; i < childCount - 1; ++i) {
      args[i - 1] = visit(ctx.children.get(i));
    }

    return new AstStatements(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStatement visitDeclLet(KSrcParser.DeclLetContext ctx) {
    var ident = (AstExprIdent) visit(ctx.children.get(1));
    var expr = (AstExpr) visit(ctx.children.get(3));
    return new AstStatementDeclLet(SourceLocation.fromContext(ctx), ident, expr);
  }

  @Override
  public AstStatement visitExprMul(KSrcParser.ExprMulContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprMul(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStatement visitExprSub(KSrcParser.ExprSubContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprSub(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStatement visitIdent(KSrcParser.IdentContext ctx) {
    return new AstExprIdent(SourceLocation.fromContext(ctx), ctx.NAME().getText());
  }

  @Override
  public AstStatement visitExprCall(KSrcParser.ExprCallContext ctx) {

    /* Get the parameters. */
    final ParseTree arguments = ctx.children.get(2);
    final int childCount = arguments.getChildCount();
    final AstExpr[] args;

    List<AstExpr> result = new ArrayList<>(childCount);
    for (int i = 0; i < childCount; ++i) {
      ParseTree child = arguments.getChild(i);
      if (!(child instanceof TerminalNode)) {
        result.add((AstExpr) visit(child));
      }
    }
    args = result.toArray(new AstExpr[result.size()]);
    return new AstExprFuncCall(SourceLocation.fromContext(ctx), ctx.NAME().getText(), args);
  }

  @Override
  public AstStatement visitExprValue(KSrcParser.ExprValueContext ctx) {
    return new AstExprValue(SourceLocation.fromContext(ctx), ctx.getText());
  }
}
