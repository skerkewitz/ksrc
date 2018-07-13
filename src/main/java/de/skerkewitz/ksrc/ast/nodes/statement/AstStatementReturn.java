package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

public class AstStatementReturn extends AstStatement {

  public final AstExpr expr;

  public AstStatementReturn(SourceLocation srcLocation, AstExpr expr) {
    super(srcLocation);
    this.expr = expr;
  }
}
