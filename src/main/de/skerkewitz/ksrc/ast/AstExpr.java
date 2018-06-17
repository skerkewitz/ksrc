package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public abstract class AstExpr extends AstStatement {

  public AstExpr(SourceLocation srcLocation) {
    super(srcLocation);
  }
}
