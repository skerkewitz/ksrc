package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprIdent extends AstExpr {

  public final String ident;

  public AstExprIdent(SourceLocation sourceLocation, String ident) {
    super(sourceLocation);
    this.ident = ident;
  }
}
