package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

/** Breaks the most inner loop. */
public class AstStatementBreak extends AstStatement {

  public AstStatementBreak(SourceLocation srcLocation) {
    super(srcLocation);
  }
}
