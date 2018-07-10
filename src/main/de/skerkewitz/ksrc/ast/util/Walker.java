package de.skerkewitz.ksrc.ast.util;

import de.skerkewitz.ksrc.ast.AstDeclarationClass;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationLet;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationVar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;

public class Walker {

  private final PrintContext ps;

  public Walker(PrintContext printContext) {
    ps = printContext;
  }

  public static class PrintContext {
    private final PrintStream ps;

    private boolean needIdent = true;
    private int depth = 0;

    public PrintContext(PrintStream ps) {
      this.ps = ps;
    }

    final void print(String text) {
      if (needIdent) {
        for (int i = 0; i < depth; i++) {
          ps.print("\t");
        }
      }

      needIdent = false;
      ps.print(text);

    }

    final void println(String text) {
      if (needIdent) {
        for (int i = 0; i < depth; i++) {
          ps.print("\t");
        }
      }
      ps.println(text);
      needIdent = true;
    }

    final void pushIdent() {
      depth++;
    }

    final void popIdent() {
      depth--;
    }

  }

  static private String exprToString(AstExpr expression) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    new Walker(new PrintContext(new PrintStream(out))).walk(expression);
    return new String(out.toByteArray());
  }

  public void walk(AstNode node) {

    if (node instanceof AstStatements) {
      AstStatements statements = (AstStatements) node;
      //ps.println("// Statements begin [" + statements.statements.size() + "] " + node.srcLocation.toString());
      for (var statement : statements.statements) {
        walk(statement);
        //ps.println("// Statements begin [" + statements.statements.size() + "] " + node.srcLocation.toString());
        ps.println("");
      }

      //ps.println("// Statements end"  + node.srcLocation.toString());
      return;
    }
    else if (node instanceof AstDeclarationFunction) {
      AstDeclarationFunction declarationFunction = (AstDeclarationFunction) node;
      String name = declarationFunction.name.ident;
      String parameters = declarationFunction.signature.params.stream()
              .map(parameter -> parameter.name.ident + ": " + parameter.type.name)
              .collect(Collectors.joining(", "));
      String returnType = declarationFunction.signature.returnType.name;
      ps.println("(func " + name + " " + returnType + " (" + parameters + ") (");
      ps.pushIdent();
      walk(declarationFunction.body);
      ps.popIdent();
      ps.println(")");
      return;
    }
    else if (node instanceof AstStatementReturn) {
      AstStatementReturn statementReturn = (AstStatementReturn) node;
      ps.print("(return ");
      walk(statementReturn.expr);
      ps.print(")");
      return;
    }
    else if (node instanceof AstExprInfixOp) {
      AstExprInfixOp exprInfixOp = (AstExprInfixOp) node;
      ps.print("(" + exprInfixOp.op.name().toLowerCase() + " ");
      walk(exprInfixOp.lhs);
      ps.print(" ");
      walk(exprInfixOp.rhs);
      ps.print(")");
      return;
    }
    else if (node instanceof AstExprIdent) {
      AstExprIdent exprIdent = (AstExprIdent) node;
      ps.print(exprIdent.ident);
      return;
    }
    else if (node instanceof AstExprLiteral) {
      AstExprLiteral exprValue = (AstExprLiteral) node;
      if (exprValue.descriptor.type == Type.STRING) {
        ps.print("\"" + exprValue.value + "\"");
      } else {
        ps.print(exprValue.value);
      }

      return;
    }
    else if (node instanceof AstExprExplicitMemberAccess) {
      AstExprExplicitMemberAccess exprValue = (AstExprExplicitMemberAccess) node;
      ps.print("(member-access ");
      walk(exprValue.lhs);
      ps.print(" ");
      walk(exprValue.rhs);
      ps.print(")");
      return;
    }
    else if (node instanceof AstDeclarationVar) {
      AstDeclarationVar declarationVar = (AstDeclarationVar) node;
      String typeIdentifier = declarationVar.descriptor == null ? "?inferred?" : declarationVar.descriptor.toString();
      ps.print("(var " + declarationVar.name.ident + " " + typeIdentifier);
      if (declarationVar.initializer != null) {
        ps.print(" ");
        walk(declarationVar.initializer);
      }
      ps.print(")");
      return;
    }
    else if (node instanceof AstDeclarationLet) {
      AstDeclarationLet declarationLet = (AstDeclarationLet) node;
      ps.print("(let " + declarationLet.name.ident + ")");
      return;
    }
    else if (node instanceof AstExprFunctionCall) {
      AstExprFunctionCall exprFunctionCall = (AstExprFunctionCall) node;
      ps.print("(call ");
      walk(exprFunctionCall.fnName);
      ps.print(" (");
      ps.print(exprFunctionCall.arguments.list.stream().map(astExpr -> exprToString(astExpr)).collect(Collectors.joining(", ")));
      ps.print("))");
      return;
    }
    else if (node instanceof AstStatementWhile) {
      AstStatementWhile statementWhile = (AstStatementWhile) node;
      ps.print("(while ");
      walk(statementWhile.condition);
      ps.print(" (");
      ps.println("");
      ps.pushIdent();
      walk(statementWhile.body);
      ps.popIdent();
      ps.print(")");
      return;
    }
    else if (node instanceof AstStatementIf) {
      AstStatementIf statementWhile = (AstStatementIf) node;
      ps.print("(if ");
      walk(statementWhile.condition);
      ps.println(" (");
      ps.pushIdent();
      walk(statementWhile.thenStatement);
      ps.popIdent();
      ps.print(")");
      return;
    }
    else if (node instanceof AstStatementAssign) {
      AstStatementAssign assignStatement = (AstStatementAssign) node;
      ps.print("(= " + assignStatement.ident.ident + " ");
      walk(assignStatement.expression);
      ps.print(")");
      return;
    }
    else if (node instanceof AstDeclarationClass) {
      AstDeclarationClass declarationClass = (AstDeclarationClass) node;
      ps.print("(class " + declarationClass.name.ident + " (");
      ps.pushIdent();
      ps.println("");
      for (var statement : declarationClass.functions) {
        walk(statement);
      }
      ps.popIdent();
      ps.print(")");
      return;
    }

    throw new UnknownAstNode(node);
  }

  private class UnknownAstNode extends RuntimeException {
    private final AstNode node;

    public UnknownAstNode(AstNode node) {
      this.node = node;
    }

    @Override
    public String toString() {
      return "UnknownAstNode{" +
              "node=" + node +
              '}';
    }
  }
}
