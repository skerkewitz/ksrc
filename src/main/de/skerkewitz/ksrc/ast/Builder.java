package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcBaseVisitor;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Builder extends KSrcBaseVisitor<AstStmt> {

  @Override
  public AstStmt visitStmt_list(KSrcParser.Stmt_listContext ctx) {

    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    final AstStmt[] args = new AstStmt[childCount];
    for (var i = 0; i < childCount; ++i) {
      args[i] = visit(ctx.children.get(i));
    }

    return new AstStmtList(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStmt visitFile_input(KSrcParser.File_inputContext ctx) {
    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    var args = new AstStmt[childCount - 1];
    for (int i = 0; i < childCount - 1; ++i) {
      args[i] = visit(ctx.children.get(i));
    }

    return new AstStmtList(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStmt visitDeclFunc(KSrcParser.DeclFuncContext ctx) {
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

    var expr = (AstStmtList) visit(ctx.children.get(hasParameter ? 5 : 2));
    var srcLoc = new SourceLocation(ctx.start, ctx.stop);
    return new AstStmtDeclFunc(srcLoc, ident, params, expr);
  }

  @Override
  public AstStmt visitCodeBlock(KSrcParser.CodeBlockContext ctx) {
    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    var args = new AstStmt[childCount - 2];
    for (int i = 1; i < childCount - 1; ++i) {
      args[i - 1] = visit(ctx.children.get(i));
    }

    return new AstStmtList(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStmt visitDeclIf(KSrcParser.DeclIfContext ctx) {
    var expr = (AstExpr) visit(ctx.children.get(1));
    var stmt = (AstStmt) visit(ctx.children.get(2));

    return new AstStmtDeclIf(SourceLocation.fromContext(ctx), expr, stmt);
  }

  @Override
  public AstStmt visitStmtReturn(KSrcParser.StmtReturnContext ctx) {
    //return super.visitStmtReturn(ctx);
    var expr = (AstExpr) visit(ctx.children.get(1));
    return new AstStmtReturn(SourceLocation.fromContext(ctx), expr);
  }

  @Override
  public AstStmt visitDeclLet(KSrcParser.DeclLetContext ctx) {
    var ident = (AstExprIdent) visit(ctx.children.get(1));
    var expr = (AstExpr) visit(ctx.children.get(3));
    return new AstStmtDeclLet(SourceLocation.fromContext(ctx), ident, expr);
  }

  @Override
  public AstStmt visitExprMul(KSrcParser.ExprMulContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprMul(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStmt visitExprSub(KSrcParser.ExprSubContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprSub(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStmt visitExprAdd(KSrcParser.ExprAddContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprAdd(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStmt visitExprEqual(KSrcParser.ExprEqualContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprEqual(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStmt visitIdent(KSrcParser.IdentContext ctx) {
    return new AstExprIdent(SourceLocation.fromContext(ctx), ctx.NAME().getText());
  }

  @Override
  public AstStmt visitExprCall(KSrcParser.ExprCallContext ctx) {

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
  public AstStmt visitExprValue(KSrcParser.ExprValueContext ctx) {
    var type = Type.fromToken(ctx.start);
    String value;
    String text = ctx.getText();
    if (type == Type.STRING) {
      value = text.substring(1, text.length() - 1);
    } else {
      value = text;
    }
    return new AstExprValue(SourceLocation.fromContext(ctx), value, type);
  }
}
