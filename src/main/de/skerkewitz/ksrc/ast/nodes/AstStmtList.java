package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStmtList extends AstStmt {

  public final AstStmt[] statements;

  public AstStmtList(SourceLocation srcLocation, AstStmt[] statements) {
    super(srcLocation);
    this.statements = statements;
  }
}
