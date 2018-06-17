package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStmtReturn extends AstStmt {

  public final AstExpr expr;

  public AstStmtReturn(SourceLocation srcLocation, AstExpr expr) {
    super(srcLocation);
    this.expr = expr;
  }
}
