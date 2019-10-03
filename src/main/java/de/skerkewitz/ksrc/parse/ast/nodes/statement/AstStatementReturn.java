package de.skerkewitz.ksrc.parse.ast.nodes.statement;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExpr;

public class AstStatementReturn extends AstStatement {

  public final AstExpr expr;

  public AstStatementReturn(SourceLocation srcLocation, AstExpr expr) {
    super(srcLocation);
    this.expr = expr;
  }
}
