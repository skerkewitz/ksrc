package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

/** Defines a single parameter in a function declaration. */
public class AstParameter extends AstNode {

  public final AstExprIdent name;
  public final AstTypeIdentifier typename;

  public AstParameter(SourceLocation srcLoc, AstExprIdent name, AstTypeIdentifier typename) {
    super(srcLoc);
    this.name = name;
    this.typename = typename;
  }
}
