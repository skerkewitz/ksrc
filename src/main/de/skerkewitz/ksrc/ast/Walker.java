package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

public class Walker {

  private final PrintStream ps = new PrintStream(System.out);

  public void walk(AstNode node) {

    if (node instanceof AstStatements) {
      AstStatements statements = (AstStatements) node;
      ps.println("// Statements begin [" + statements.statements.size() + "] " + node.srcLocation.toString());
      for (var statement : statements.statements) {
        walk(statement);
      }
      ps.println("// Statements end"  + node.srcLocation.toString());
    }
//    else if (node instanceof AstDeclarationFunction) {
//      AstDeclarationFunction declarationFunction = (AstDeclarationFunction) node;
//      ps.println("(func " + declarationFunction.// Statements begin [" + statements.statements.length + "] " + node.srcLocation.toString());
//
//    }

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
