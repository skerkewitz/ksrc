package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.AstDeclarationClass;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationLet;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationVar;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

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
//      String parameters = declarationFunction.signature.params.stream()
//              .map(parameter -> parameter.name.ident + ": " + parameter.type.name)
//              .collect(Collectors.joining(", "));
//      String returnType = declarationFunction.signature.returnType.name;

      /* Declare the return descriptor for the funtion in the current scope. */
      localSymbols.declareSymbol(name, declarationFunction.signature.returnType.descriptor, declarationFunction.signature.returnType);

      /* Create a new local function table. */
      final SymbolTable localFunctionSymbolTable = localSymbols.createNewScope();
      for (var p : declarationFunction.signature.params) {
        localFunctionSymbolTable.declareSymbol(p.name.ident, p.type.descriptor, p.name);
      }

      walk(declarationFunction.body, sema, localFunctionSymbolTable);
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
        throw new Sema.SemaException(node, "Infix operation " + exprInfixOp.op.name() + " requires lsh (" + exprInfixOp.lhs.descriptor+ ") to be same as rhs (" + exprInfixOp.rhs.descriptor + ").");
      }
      exprInfixOp.descriptor = exprInfixOp.lhs.descriptor;
      return;
    }
    else if (node instanceof AstExprIdent) {
      AstExprIdent exprIdent = (AstExprIdent) node;
      exprIdent.descriptor = sema.resolveType(exprIdent, localSymbols);
      return;
    }
    else if (node instanceof AstExprLiteral) {
      AstExprLiteral exprValue = (AstExprLiteral) node;
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
        declarationVar.descriptor = declarationVar.initializer.descriptor;
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

      /* Resolve all arguments parameter first. */
      for (var p : exprFunctionCall.arguments.list) {
        walk(p, sema, localSymbols);
      }

      walk(exprFunctionCall.fnName, sema, localSymbols);
      exprFunctionCall.descriptor = exprFunctionCall.fnName.descriptor;
      return;
    }

    if (node instanceof AstStatementWhile) {
      AstStatementWhile statementWhile = (AstStatementWhile) node;
      walk(statementWhile.condition, sema, localSymbols);
      /* TODO assert the condition is boolean. */
//      if (statementWhile.condition.descriptor != VmDescriptor.Boolean) {
//        throw new Sema.SemaException(declarationVar, "Variable declarations need either explicit type declaration or type must be inferable from initializer.");
//      }
      walk(statementWhile.body, sema, localSymbols.createNewScope());
      return;
    }
    else if (node instanceof AstStatementIf) {
      AstStatementIf statementWhile = (AstStatementIf) node;
      walk(statementWhile.condition, sema, localSymbols);
      /* TODO assert the condition is boolean. */
//      if (statementWhile.condition.descriptor != VmDescriptor.Boolean) {
//        throw new Sema.SemaException(declarationVar, "Variable declarations need either explicit type declaration or type must be inferable from initializer.");
//      }
      walk(statementWhile.thenStatement, sema, localSymbols.createNewScope());
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
