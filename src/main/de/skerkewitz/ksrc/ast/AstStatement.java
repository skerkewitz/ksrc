package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public abstract class AstStatement {

  public final SourceLocation srcLocation;

  public AstStatement(SourceLocation srcLocation) {
    this.srcLocation = srcLocation;
  }
}
