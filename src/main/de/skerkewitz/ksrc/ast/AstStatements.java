package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStatements extends AstStatement {

  public final AstStatement[] statements;

  public AstStatements(SourceLocation srcLocation, AstStatement[] statements) {
    super(srcLocation);
    this.statements = statements;
  }
}
