package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcBaseVisitor;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.*;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.*;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import org.antlr.v4.runtime.RuleContext;

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
            .peek(s -> {if (s == null) throw new IllegalArgumentException("Error at token: " + SourceLocation.fromContext(ctx).toString());})
            .collect(Collectors.toList());

    return new AstStatements(SourceLocation.fromContext(ctx), statements);
  }

  @Override
  public AstNode visitTranslation_unit(KSrcParser.Translation_unitContext ctx) {
    return visit(ctx.statements_list(), AstStatements.class);
  }

  @Override
  public AstNode visitClass_declaration(KSrcParser.Class_declarationContext ctx) {
    var ident = visit(ctx.identifier(), AstExprIdent.class);

    var functions = ctx.function_declaration()
            .stream()
            .map(c -> visit(c, AstDeclarationFunction.class))
            .collect(Collectors.toList());
    var fields = ctx.field_declaration()
            .stream()
            .map(c -> visit(c, AstDeclarationNamedValue.class))
            .collect(Collectors.toList());

    return new AstDeclarationClass(SourceLocation.fromContext(ctx), ident, functions, fields);
  }

  @Override
  public AstNode visitFunction_declaration(KSrcParser.Function_declarationContext ctx) {
    var srcLoc = new SourceLocation(ctx.start, ctx.stop);

    var ident = visit(ctx.identifier(), AstExprIdent.class);
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
    var expr = visit(ctx.identifier(), AstExprIdent.class);
    var stmt = visit(ctx.type_literal(), AstTypeIdentifier.class);
    return new AstDeclarationFunction.Parameter(SourceLocation.fromContext(ctx), expr, stmt);
  }

  @Override
  public AstNode visitVariable_declaration(KSrcParser.Variable_declarationContext ctx) {
    var ident = visit(ctx.identifier(), AstExprIdent.class);
    var typeIdentifier = visit(ctx.type_annotation(), AstTypeIdentifier.class);
    var expr = ctx.initializer() == null ? null : visit(ctx.initializer().expression(), AstExpr.class);
    return new AstDeclarationNamedValue(SourceLocation.fromContext(ctx), false, ident, typeIdentifier, expr);
  }

  @Override
  public AstNode visitConstant_declaration(KSrcParser.Constant_declarationContext ctx) {
    var ident = visit(ctx.identifier(), AstExprIdent.class);
    var typeIdentifier = visit(ctx.type_annotation(), AstTypeIdentifier.class);
    var expr = visit(ctx.initializer().expression(), AstExpr.class);
    return new AstDeclarationNamedValue(SourceLocation.fromContext(ctx), true, ident, typeIdentifier, expr);
  }

  @Override
  public AstNode visitType_literal(KSrcParser.Type_literalContext ctx) {
    return new AstTypeIdentifier(SourceLocation.fromContext(ctx), ctx.NAME().getText());
  }

  @Override
  public AstStatement visitCodeBlock(KSrcParser.CodeBlockContext ctx) {
    return visit(ctx.statements_list(), AstStatements.class);
  }

  @Override
  public AstNode visitStatements_list(KSrcParser.Statements_listContext ctx) {
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
    var thenStatements = visit(ctx.thenBlock, AstStatements.class);
    var elseStatements = visit(ctx.elseBlock, AstStatements.class);
    return new AstStatementIf(SourceLocation.fromContext(ctx), condition, thenStatements, elseStatements);
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
  public AstNode visitBreakStatement(KSrcParser.BreakStatementContext ctx) {
    return new AstStatementBreak(SourceLocation.fromContext(ctx));
  }

  @Override
  public AstExprInfixOp visitExprMultiplication(KSrcParser.ExprMultiplicationContext ctx) {
    var lhs = (AstExpr) visit(ctx.expression(0));
    var rhs = (AstExpr) visit(ctx.expression(1));
    var op = AstExprInfixOp.Token.fromAstToken(ctx.op.getType());
    return new AstExprInfixOp(SourceLocation.fromContext(ctx), lhs, rhs, op);
  }

  @Override
  public AstNode visitExprAdditive(KSrcParser.ExprAdditiveContext ctx) {
    var lhs = (AstExpr) visit(ctx.expression(0));
    var rhs = (AstExpr) visit(ctx.expression(1));
    var op = AstExprInfixOp.Token.fromAstToken(ctx.op.getType());
    return new AstExprInfixOp(SourceLocation.fromContext(ctx), lhs, rhs, op);
  }

  @Override
  public AstNode visitExprParens(KSrcParser.ExprParensContext ctx) {
    return visit(ctx.expression(), AstExpr.class);
  }

  @Override
  public AstNode visitExprEquality(KSrcParser.ExprEqualityContext ctx) {
    var lhs = (AstExpr) visit(ctx.expression(0));
    var rhs = (AstExpr) visit(ctx.expression(1));
    var op = AstExprInfixOp.Token.fromAstToken(ctx.op.getType());
    return new AstExprInfixOp(SourceLocation.fromContext(ctx), lhs, rhs, op);
  }

  @Override
  public AstNode visitExprExplicitMemberAccess(KSrcParser.ExprExplicitMemberAccessContext ctx) {
    var lhs = visit(ctx.lhs, AstExpr.class);
    var rhs = visit(ctx.rhs, AstExpr.class);
    return new AstExprExplicitMemberAccess(SourceLocation.fromContext(ctx), lhs, rhs);
  }

  @Override
  public AstNode visitExprLogicalOr(KSrcParser.ExprLogicalOrContext ctx) {
    var lhs = (AstExpr) visit(ctx.expression(0));
    var rhs = (AstExpr) visit(ctx.expression(1));
    var op = AstExprInfixOp.Token.OR;
    return new AstExprInfixOp(SourceLocation.fromContext(ctx), lhs, rhs, op);
  }

  @Override
  public AstNode visitExprRelational(KSrcParser.ExprRelationalContext ctx) {
    var lhs = (AstExpr) visit(ctx.expression(0));
    var rhs = (AstExpr) visit(ctx.expression(1));
    var op = AstExprInfixOp.Token.fromAstToken(ctx.op.getType());
    return new AstExprInfixOp(SourceLocation.fromContext(ctx), lhs, rhs, op);
  }

  @Override
  public AstNode visitStatementAssign(KSrcParser.StatementAssignContext ctx) {
    var ident = visit(ctx.postfix_expression(), AstExpr.class);
    var expression = visit(ctx.expression(), AstExpr.class);
    return new AstStatementAssign(SourceLocation.fromContext(ctx), ident, expression);
  }

  @Override
  public AstStatement visitIdentifier(KSrcParser.IdentifierContext ctx) {
    return new AstExprIdent(SourceLocation.fromContext(ctx), ctx.NAME().getText());
  }

  @Override
  public AstStatement visitExprCall(KSrcParser.ExprCallContext ctx) {
    AstExpr fnName = visit(ctx.postfix_expression(), AstExpr.class);
    AstExprFunctionCall.Arguments arguments = visit(ctx.function_call_argument_clause(), AstExprFunctionCall.Arguments.class);
    return new AstExprFunctionCall(SourceLocation.fromContext(ctx), fnName, arguments);
  }

  @Override
  public AstExprFunctionCall.Arguments visitFunctionCallArgumentClause(KSrcParser.FunctionCallArgumentClauseContext ctx) {
    return visit(ctx.function_call_argument_list(), AstExprFunctionCall.Arguments.class);
  }

  @Override
  public AstExprFunctionCall.Arguments visitFunctionCallArgumentList(KSrcParser.FunctionCallArgumentListContext ctx) {
    List<AstExpr> argumentList = ctx.expression().stream().map(c -> visit(c, AstExpr.class)).collect(Collectors.toList());
    return new AstExprFunctionCall.Arguments(SourceLocation.fromContext(ctx), argumentList);
  }

  @Override
  public AstNode visitLiteralInteger(KSrcParser.LiteralIntegerContext ctx) {
    return new AstExprLiteral(SourceLocation.fromContext(ctx), ctx.getText(), VmDescriptor.Int);
  }

  @Override
  public AstNode visitLiteralFloat(KSrcParser.LiteralFloatContext ctx) {
    return new AstExprLiteral(SourceLocation.fromContext(ctx), ctx.getText(), VmDescriptor.Double);
  }

  @Override
  public AstNode visitString_literal(KSrcParser.String_literalContext ctx) {
    String text = ctx.getText();
    String value = text.substring(1, text.length() - 1);
    return new AstExprLiteral(SourceLocation.fromContext(ctx), value, VmDescriptor.String);
  }

  @Override
  public AstNode visitDeclarationFieldVariable(KSrcParser.DeclarationFieldVariableContext ctx) {
    return visit(ctx.constant_declaration(), AstDeclarationNamedValue.class);
  }

  @Override
  public AstNode visitDeclarationFieldConstant(KSrcParser.DeclarationFieldConstantContext ctx) {
    return visit(ctx.variable_declaration(), AstDeclarationNamedValue.class);
  }
}
