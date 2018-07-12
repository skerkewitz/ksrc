package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;

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
