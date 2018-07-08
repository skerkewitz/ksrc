package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprIdent extends AstExpr {

  public final String ident;

  public AstExprIdent(SourceLocation sourceLocation, String ident) {
    super(sourceLocation, null);
    this.ident = ident;
  }

  @Override
  public String toString() {
    return "AstExprIdent{" +
            "ident='" + ident + '\'' +
            ", descriptor=" + descriptor +
            ", srcLocation=" + srcLocation +
            '}';
  }
}
