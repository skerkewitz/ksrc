package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatements;


public class AstWalker {

  public interface AstWalkerVisitor {
    AstNode visit(AstStatements statements);
  }

  private final AstWalkerVisitor visitor;

  public AstWalker(AstWalkerVisitor visitor) {
    this.visitor = visitor;
  }


  public AstNode walk(AstNode node) {

    if (node instanceof AstStatements) {
      final AstStatements statements = (AstStatements) node;
      return this.visitor.visit(statements);
    }

//    if (node instanceof AstDeclarationFunction) {
//      AstDeclarationFunction declarationFunction = (AstDeclarationFunction) node;
//      String name = declarationFunction.name.ident;
////      String parameters = declarationFunction.signature.params.stream()
////              .map(parameter -> parameter.name.ident + ": " + parameter.type.name)
////              .collect(Collectors.joining(", "));
////      String returnType = declarationFunction.signature.returnType.name;
//
//      /* Declare the return descriptor for the funtion in the current scope. */
//      localSymbols.declareSymbol(name, declarationFunction.signature.returnType.descriptor, declarationFunction.signature.returnType);
//
//      /* Create a new local function table. */
//      final SymbolTable localFunctionSymbolTable = localSymbols.createNewScope();
//      for (var p : declarationFunction.signature.params) {
//        localFunctionSymbolTable.declareSymbol(p.name.ident, p.type.descriptor, p.name);
//      }
//
//      walk(declarationFunction.body, sema, localFunctionSymbolTable);
//      return;
//    }
//
//    if (node instanceof AstStatementReturn) {
//      AstStatementReturn statementReturn = (AstStatementReturn) node;
//      walk(statementReturn.expr, sema, localSymbols);
//      statementReturn.expr.descriptor = sema.resolveType(statementReturn.expr, localSymbols);
//      return;
//    }
//
//    if (node instanceof AstExprInfixOp) {
//      AstExprInfixOp exprInfixOp = (AstExprInfixOp) node;
//      walk(exprInfixOp.lhs, sema, localSymbols);
//      walk(exprInfixOp.rhs, sema, localSymbols);
//
//      /* Make sure lhs and rhs side type are the same. */
//      if (!exprInfixOp.lhs.descriptor.equals(exprInfixOp.rhs.descriptor)) {
//        throw new Sema.SemaException(node, "Infix operation " + exprInfixOp.op.name() + " requires lsh (" + exprInfixOp.lhs.descriptor+ ") to be same as rhs (" + exprInfixOp.rhs.descriptor + ").");
//      }
//      exprInfixOp.descriptor = exprInfixOp.lhs.descriptor;
//      return;
//    }
//    else if (node instanceof AstExprIdent) {
//      AstExprIdent exprIdent = (AstExprIdent) node;
//      exprIdent.descriptor = sema.resolveType(exprIdent, localSymbols);
//      return;
//    }
//    else if (node instanceof AstExprLiteral) {
//      AstExprLiteral exprValue = (AstExprLiteral) node;
//      return;
//    }
//    else if (node instanceof AstExprExplicitMemberAccess) {
//      AstExprExplicitMemberAccess exprExplicitMemberAccess = (AstExprExplicitMemberAccess) node;
//      VmDescriptor baseType = sema.resolveType(exprExplicitMemberAccess.lhs, localSymbols);
//      if (baseType.type != Type.ANY_REF) {
//        throw new Sema.SemaException(exprExplicitMemberAccess.lhs, "lhs of member access is not a reference type '" + exprExplicitMemberAccess.lhs + "'");
//      }
//
//      final VmClassInfo classInfo = sema.findClassInfoWithName(baseType.fqClassName);
//      if (classInfo == null) {
//        throw new Sema.SemaException(exprExplicitMemberAccess.lhs, "lhs references unknown class '" + baseType.fqClassName + "'");
//      }
//
//      AstExprIdent exprIdent = (AstExprIdent) exprExplicitMemberAccess.rhs;
//      String membername = exprIdent.ident;
//
//      if (exprExplicitMemberAccess.isFieldAccess) {
//        Optional<VmFieldInfo> fieldInfo = classInfo.getFieldByName(membername);
//        if (!fieldInfo.isPresent()) {
//          throw new Sema.SemaException(exprExplicitMemberAccess.lhs, "rhs references unknown field " + membername + " of class '" + baseType.fqClassName + "'");
//        }
//
//        // TODO: field has no descriptor yet.
//        exprExplicitMemberAccess.descriptor = VmDescriptor.Int;
//      } else {
//        // TODO: fix methods.
//        exprExplicitMemberAccess.descriptor = VmDescriptor.Int;
//      }
//      return;
//    }
//
//    if (node instanceof AstDeclarationNamedValue) {
//      AstDeclarationNamedValue declarationVar = (AstDeclarationNamedValue) node;
//
//      if (declarationVar.typeIdentifier != null) {
//        declarationVar.descriptor = declarationVar.typeIdentifier.descriptor;
//        localSymbols.declareSymbol(declarationVar.name.ident, declarationVar.descriptor, declarationVar);
//      }
//
//      if (declarationVar.initializer != null) {
//        walk(declarationVar.initializer, sema, localSymbols);
//        declarationVar.descriptor = declarationVar.initializer.descriptor;
//        localSymbols.declareSymbol(declarationVar.name.ident, declarationVar.descriptor, declarationVar);
//      }
//
//      if (declarationVar.descriptor == null) {
//        throw new Sema.SemaException(declarationVar, "Variable declarations need either explicit type declaration or type must be inferable from initializer.");
//      }
//
//      return;
//    }
//
//    if (node instanceof AstExprFunctionCall) {
//      AstExprFunctionCall exprFunctionCall = (AstExprFunctionCall) node;
//
//      /* Resolve all arguments parameter first. */
//      for (var p : exprFunctionCall.arguments.list) {
//        walk(p, sema, localSymbols);
//      }
//
//      /* Only walk if this is not an ident. */
//      if (exprFunctionCall.isMemberFunctionCall()) {
//        walk(exprFunctionCall.fnName, sema, localSymbols);
//      }
//
//      /* Check for special Constructor call case. */
//      VmMethodInfo resolve = SemaFunctionCallResolverHelper.resolve(exprFunctionCall, sema, localSymbols);
//      VmDescriptor returnDescriptor = resolve.descriptor.returnDescriptor;
//      if (exprFunctionCall.isDirectFunctionCall() && resolve.name.equals("init") && !resolve.equals(exprFunctionCall.getFunctionNameIdent().ident)) {
//        final VmClassInfo classInfo = sema.findClassInfoWithName(exprFunctionCall.getFunctionNameIdent().ident);
//        exprFunctionCall.descriptor = new VmDescriptor(Type.ANY_REF, classInfo.fqThisClassName);
//      } else {
//        exprFunctionCall.descriptor = returnDescriptor;
//      }
//      return;
//    }
//
//    if (node instanceof AstStatementWhile) {
//      AstStatementWhile statementWhile = (AstStatementWhile) node;
//      walk(statementWhile.condition, sema, localSymbols);
//      /* TODO assert the condition is boolean. */
////      if (statementWhile.condition.descriptor != VmDescriptor.Boolean) {
////        throw new Sema.SemaException(declarationVar, "Variable declarations need either explicit type declaration or type must be inferable from initializer.");
////      }
//      walk(statementWhile.body, sema, localSymbols.createNewScope());
//      return;
//    }
//    else if (node instanceof AstStatementIf) {
//      AstStatementIf statementWhile = (AstStatementIf) node;
//      walk(statementWhile.condition, sema, localSymbols);
//      /* TODO assert the condition is boolean. */
////      if (statementWhile.condition.descriptor != VmDescriptor.Boolean) {
////        throw new Sema.SemaException(declarationVar, "Variable declarations need either explicit type declaration or type must be inferable from initializer.");
////      }
//      walk(statementWhile.thenStatement, sema, localSymbols.createNewScope());
//      return;
//    }
//    else if (node instanceof AstStatementAssign) {
//      AstStatementAssign assignStatement = (AstStatementAssign) node;
//      walk(assignStatement.expression, sema, localSymbols);
//      return;
//    }
//    else if (node instanceof AstDeclarationClass) {
//      AstDeclarationClass declarationClass = (AstDeclarationClass) node;
//      for (var field : declarationClass.fields) {
//        walk(field, sema, localSymbols);
//      }
//
//      //      for (var statement : declarationClass.functions) {
////        walk(statement);
////      }
////      ps.popIdent();
////      ps.print(")");
//      return;
//    }

    throw new Sema.SemaException(node, "UnknownAstNode " + node.getClass());
  }
}


abstract class BaseListener implements AstWalker.AstWalkerVisitor {

  public AstNode walk(AstStatements astStatements) {

    for (var statement : astStatements.statements) {
//      walker.walk(statement, ctx);
    }
    return astStatements;
  }
}