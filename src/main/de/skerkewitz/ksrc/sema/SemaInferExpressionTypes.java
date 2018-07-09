package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.AstDeclarationClass;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationLet;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationVar;

import java.util.stream.Collectors;

public class SemaInferExpressionTypes {

  public static void walk(AstNode node, Sema sema, SymbolTable localSymbols) {

    if (node instanceof AstStatements) {
      AstStatements statements = (AstStatements) node;
      for (var statement : statements.statements) {
        walk(statement, sema, localSymbols);
      }
      return;
    }

    if (node instanceof AstDeclarationFunction) {
      AstDeclarationFunction declarationFunction = (AstDeclarationFunction) node;
      String name = declarationFunction.name.ident;
      String parameters = declarationFunction.signature.params.stream()
              .map(parameter -> parameter.name.ident + ": " + parameter.type.name)
              .collect(Collectors.joining(", "));
      String returnType = declarationFunction.signature.returnType.name;
      walk(declarationFunction.body, sema, localSymbols);
      return;
    }

    if (node instanceof AstStatementReturn) {
      AstStatementReturn statementReturn = (AstStatementReturn) node;
      walk(statementReturn.expr, sema, localSymbols);
      statementReturn.expr.descriptor = sema.resolveType(statementReturn.expr, localSymbols);
      return;
    }

    if (node instanceof AstExprInfixOp) {
      AstExprInfixOp exprInfixOp = (AstExprInfixOp) node;
      walk(exprInfixOp.lhs, sema, localSymbols);
      walk(exprInfixOp.rhs, sema, localSymbols);

      /* Make sure lhs and rhs side type are the same. */
      if (!exprInfixOp.lhs.descriptor.equals(exprInfixOp.rhs.descriptor)) {
        throw new Sema.SemaException(node, "Infix operation requieres lsh and rhs to be same of type.");
      }
      exprInfixOp.descriptor = exprInfixOp.lhs.descriptor;
      return;
    }
    else if (node instanceof AstExprIdent) {
      AstExprIdent exprIdent = (AstExprIdent) node;
      exprIdent.descriptor = sema.resolveType(exprIdent, localSymbols);
      return;
    }
    else if (node instanceof AstExprValue) {
      AstExprValue exprValue = (AstExprValue) node;
      return;
    }
    else if (node instanceof AstExprExplicitMemberAccess) {
      return;
    }

    if (node instanceof AstDeclarationVar) {
      AstDeclarationVar declarationVar = (AstDeclarationVar) node;

      if (declarationVar.typeIdentifier != null) {
        declarationVar.descriptor = declarationVar.typeIdentifier.descriptor;
        localSymbols.declareSymbol(declarationVar.name.ident, declarationVar.descriptor, declarationVar);
      }

      if (declarationVar.initializer != null) {
        walk(declarationVar.initializer, sema, localSymbols);
        declarationVar.descriptor = sema.resolveType(declarationVar.initializer, localSymbols);
        localSymbols.declareSymbol(declarationVar.name.ident, declarationVar.descriptor, declarationVar);
      }

      if (declarationVar.descriptor == null) {
        throw new Sema.SemaException(declarationVar, "Variable declarations need either explicit type declaration or type must be inferable from initializer.");
      }

      return;
    }

    if (node instanceof AstDeclarationLet) {
      AstDeclarationLet declarationLet = (AstDeclarationLet) node;
      return;
    }

    if (node instanceof AstExprFunctionCall) {
      AstExprFunctionCall exprFunctionCall = (AstExprFunctionCall) node;
      walk(exprFunctionCall.fnName, sema, localSymbols);
      return;
    }

    if (node instanceof AstStatementWhile) {
      AstStatementWhile statementWhile = (AstStatementWhile) node;
//      ps.print("(while ");
//      walk(statementWhile.condition);
//      ps.print(" (");
//      ps.println("");
//      ps.pushIdent();
//      walk(statementWhile.body);
//      ps.popIdent();
//      ps.print(")");
      return;
    }
    else if (node instanceof AstStatementIf) {
      AstStatementIf statementWhile = (AstStatementIf) node;
//      ps.print("(if ");
//      walk(statementWhile.condition);
//      ps.println(" (");
//      ps.pushIdent();
//      walk(statementWhile.thenStatement);
//      ps.popIdent();
//      ps.print(")");
      return;
    }
    else if (node instanceof AstStatementAssign) {
      AstStatementAssign assignStatement = (AstStatementAssign) node;
      walk(assignStatement.expression, sema, localSymbols);
      return;
    }
    else if (node instanceof AstDeclarationClass) {
//      for (var statement : declarationClass.functions) {
//        walk(statement);
//      }
//      ps.popIdent();
//      ps.print(")");
      return;
    }

    throw new Sema.SemaException(node, "UnknownAstNode");
  }
}
