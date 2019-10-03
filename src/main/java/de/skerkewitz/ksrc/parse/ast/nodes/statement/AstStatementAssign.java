package de.skerkewitz.ksrc.parse.ast.nodes.statement;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExpr;

/** Assign the astNode to the name. */
public class AstStatementAssign extends AstStatement {

  public final AstExpr ident;
  public final AstExpr expression;

  public AstStatementAssign(SourceLocation srcLocation, AstExpr ident, AstExpr expression) {
    super(srcLocation);
    this.ident = ident;
    this.expression = expression;
  }
}
