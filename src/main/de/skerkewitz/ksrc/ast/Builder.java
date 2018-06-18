package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcBaseVisitor;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.*;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprValue;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprAdd;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprEqual;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprMul;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprSub;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationLet;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.BuilderDeclaration;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Builder extends KSrcBaseVisitor<AstNode> {

  /* Util method. */
  public <T> T visit(RuleContext ctx, Class<T> type) {
    if (ctx == null) {
      return null;
    }

    return type.cast(visit(ctx));
  }


  @Override
  public AstStatement visitStatements(KSrcParser.StatementsContext ctx) {

    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    final AstStatement[] args = new AstStatement[childCount];
    for (var i = 0; i < childCount; ++i) {
      args[i] = (AstStatement) visit(ctx.children.get(i));
    }

    return new AstStatements(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStatement visitFile_input(KSrcParser.File_inputContext ctx) {
    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    var args = new AstStatement[childCount - 1];
    for (int i = 0; i < childCount - 1; ++i) {
      args[i] = (AstStatement) visit(ctx.children.get(i));
    }

    return new AstStatements(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStatement visitDeclFunc(KSrcParser.DeclFuncContext ctx) {
    return BuilderDeclaration.functionDeclaration(this, ctx);
  }

  @Override
  public AstNode visitFunctionParameter(KSrcParser.FunctionParameterContext ctx) {
    return BuilderDeclaration.functionDeclarationParameter(this, ctx);
  }

  @Override
  public AstNode visitDeclarationVariable(KSrcParser.DeclarationVariableContext ctx) {
    return BuilderDeclaration.declarationVariable(this, ctx);
  }

  @Override
  public AstNode visitTypename(KSrcParser.TypenameContext ctx) {
    return new AstTypeIdentifier(SourceLocation.fromContext(ctx), ctx.NAME().getText());
  }

  @Override
  public AstStatement visitCodeBlock(KSrcParser.CodeBlockContext ctx) {
    /* Get the parameters. */
    final int childCount = ctx.getChildCount();

    var args = new AstStatement[childCount - 2];
    for (int i = 1; i < childCount - 1; ++i) {
      args[i - 1] = (AstStatement) visit(ctx.children.get(i));
    }

    return new AstStatements(SourceLocation.fromContext(ctx), args);
  }

  @Override
  public AstStatementIf visitIfStatement(KSrcParser.IfStatementContext ctx) {
    var condition = (AstExpr) visit(ctx.children.get(1));
    var statement = (AstStatement) visit(ctx.children.get(2));

    return new AstStatementIf(SourceLocation.fromContext(ctx), condition, statement);
  }

  @Override
  public AstStatementWhile visitStatementWhile(KSrcParser.StatementWhileContext ctx) {
    var condition = (AstExpr) visit(ctx.children.get(1));
    var statements = (AstStatements) visit(ctx.children.get(2));

    return new AstStatementWhile(SourceLocation.fromContext(ctx), condition, statements);
  }

  @Override
  public AstStatement visitReturnStatement(KSrcParser.ReturnStatementContext ctx) {
    var expr = (AstExpr) visit(ctx.children.get(1));
    return new AstStatementReturn(SourceLocation.fromContext(ctx), expr);
  }

  @Override
  public AstStatement visitDeclLet(KSrcParser.DeclLetContext ctx) {
    var ident = (AstExprIdent) visit(ctx.children.get(1));
    var expr = (AstExpr) visit(ctx.children.get(3));
    return new AstDeclarationLet(SourceLocation.fromContext(ctx), ident, expr);
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
  public AstStatement visitExprAdd(KSrcParser.ExprAddContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprAdd(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstStatement visitExprEqual(KSrcParser.ExprEqualContext ctx) {
    var lhs = (AstExpr) visit(ctx.children.get(0));
    var rhs = (AstExpr) visit(ctx.children.get(2));
    return new AstExprEqual(SourceLocation.fromContext(ctx), lhs, rhs);
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
    return new AstExprFunctionCall(SourceLocation.fromContext(ctx), ctx.NAME().getText(), args);
  }

  @Override
  public AstStatement visitExprValue(KSrcParser.ExprValueContext ctx) {
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
