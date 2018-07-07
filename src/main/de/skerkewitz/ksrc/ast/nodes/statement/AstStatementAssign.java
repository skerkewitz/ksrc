package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;

/** Assign the expression to the name. */
public class AstStatementAssign extends AstStatement {

  public final AstExprIdent ident;
  public final AstExpr expression;

  public AstStatementAssign(SourceLocation srcLocation, AstExprIdent ident, AstExpr expression) {
    super(srcLocation);
    this.ident = ident;
    this.expression = expression;
  }
}
