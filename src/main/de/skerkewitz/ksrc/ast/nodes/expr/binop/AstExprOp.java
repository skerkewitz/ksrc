package de.skerkewitz.ksrc.ast.nodes.expr.binop;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

public class AstExprOp extends AstExpr {

  public final AstExpr lhs;
  public final AstExpr rhs;

  public AstExprOp(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, null);
    this.lhs = lhs;
    this.rhs = rhs;
  }
}
