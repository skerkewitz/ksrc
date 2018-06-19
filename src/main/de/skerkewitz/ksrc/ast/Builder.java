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
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.*;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Builder extends KSrcBaseVisitor<AstNode> {

  /* Util method. */
  private <T> T visit(RuleContext ctx, Class<T> type) {
    if (ctx == null) {
      return null;
    }

    return type.cast(visit(ctx));
  }


  @Override
  public AstStatement visitStatements(KSrcParser.StatementsContext ctx) {

   var statements = ctx.statement()
            .stream()
            .map(c -> visit(c, AstStatement.class))
            .collect(Collectors.toList());

    return new AstStatements(SourceLocation.fromContext(ctx), statements);
  }

  @Override
  public AstStatements visitFile_input(KSrcParser.File_inputContext ctx) {

    var statements = ctx.statements()
            .stream()
            .map(c -> visit(c, AstStatements.class))
            .flatMap(astStatements -> astStatements.statements.stream())
            .collect(Collectors.toList());

    return new AstStatements(SourceLocation.fromContext(ctx), statements);
  }


  @Override
  public AstNode visitFunctionDeclaration(KSrcParser.FunctionDeclarationContext ctx) {
    var srcLoc = new SourceLocation(ctx.start, ctx.stop);

    var ident = visit(ctx.ident(), AstExprIdent.class);
    var signature = visit(ctx.function_signature(), AstDeclarationFunction.Signature.class);
    var codeBlock = visit(ctx.code_block(), AstStatements.class);
    return new AstDeclarationFunction(srcLoc, ident, signature, codeBlock);
  }

  @Override
  public AstNode visitFunctionSignature(KSrcParser.FunctionSignatureContext ctx) {
    var parameters = visit(ctx.function_parameters(), AstFunctionParameters.class);
    var returnType = visit(ctx.function_result(), AstTypeIdentifier.class);
    return new AstDeclarationFunction.Signature(SourceLocation.fromContext(ctx), parameters, returnType);
  }

  @Override
  public AstNode visitFunctionParameters(KSrcParser.FunctionParametersContext ctx) {
    var params = ctx.function_parameter()
            .stream()
            .map(c -> visit(c, AstDeclarationFunction.Parameter.class))
            .collect(Collectors.toList());

    return new AstFunctionParameters(SourceLocation.fromContext(ctx), params);
  }

  @Override
  public AstNode visitFunctionParameter(KSrcParser.FunctionParameterContext ctx) {
    var expr = visit(ctx.ident(), AstExprIdent.class);
    var stmt = visit(ctx.typename(), AstTypeIdentifier.class);
    return new AstDeclarationFunction.Parameter(SourceLocation.fromContext(ctx), expr, stmt);
  }

  @Override
  public AstNode visitDeclarationVariable(KSrcParser.DeclarationVariableContext ctx) {
    var ident = visit(ctx.ident(), AstExprIdent.class);
    var typeIdentifier = visit(ctx.type_annotation(), AstTypeIdentifier.class);
    var expr = ctx.initializer() == null ? null : visit(ctx.initializer().expression(), AstExpr.class);
    return new AstDeclarationVar(SourceLocation.fromContext(ctx), ident, typeIdentifier, expr);
  }

  @Override
  public AstNode visitTypename(KSrcParser.TypenameContext ctx) {
    return new AstTypeIdentifier(SourceLocation.fromContext(ctx), ctx.NAME().getText());
  }

  @Override
  public AstStatement visitCodeBlock(KSrcParser.CodeBlockContext ctx) {

    var statements = ctx.statements()
            .stream()
            .map(c -> visit(c, AstStatements.class))
            .flatMap(astStatements -> astStatements.statements.stream())
            .collect(Collectors.toList());

    return new AstStatements(SourceLocation.fromContext(ctx), statements);
  }

  @Override
  public AstStatementIf visitIfStatement(KSrcParser.IfStatementContext ctx) {
    var condition = visit(ctx.condition(), AstExpr.class);
    var statements = visit(ctx.code_block(), AstStatements.class);
    return new AstStatementIf(SourceLocation.fromContext(ctx), condition, statements);
  }

  @Override
  public AstStatementWhile visitStatementWhile(KSrcParser.StatementWhileContext ctx) {
    var condition = visit(ctx.condition(), AstExpr.class);
    var statements = visit(ctx.code_block(), AstStatements.class);
    return new AstStatementWhile(SourceLocation.fromContext(ctx), condition, statements);
  }

  @Override
  public AstStatement visitReturnStatement(KSrcParser.ReturnStatementContext ctx) {
    var expression = visit(ctx.expression(), AstExpr.class);
    return new AstStatementReturn(SourceLocation.fromContext(ctx), expression);
  }

  @Override
  public AstNode visitDeclarationConstant(KSrcParser.DeclarationConstantContext ctx) {
    var ident = visit(ctx.ident(), AstExprIdent.class);
    var typeIdentifier = visit(ctx.type_annotation(), AstTypeIdentifier.class);
    var expr = visit(ctx.initializer().expression(), AstExpr.class);
    return new AstDeclarationLet(SourceLocation.fromContext(ctx), ident, typeIdentifier, expr);
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
