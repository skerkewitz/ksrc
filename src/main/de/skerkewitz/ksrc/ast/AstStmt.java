package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public abstract class AstStmt {

  public final SourceLocation srcLocation;

  public AstStmt(SourceLocation srcLocation) {
    this.srcLocation = srcLocation;
  }
}
