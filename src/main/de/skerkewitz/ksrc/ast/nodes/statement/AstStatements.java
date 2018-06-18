package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

public class AstStatements extends AstStatement {

  public final AstStatement[] statements;

  public AstStatements(SourceLocation srcLocation, AstStatement[] statements) {
    super(srcLocation);
    this.statements = statements;
  }
}
