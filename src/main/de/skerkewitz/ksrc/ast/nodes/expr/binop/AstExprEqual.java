package de.skerkewitz.ksrc.ast.nodes.expr.binop;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

public class AstExprEqual extends AstExprOp {

  public AstExprEqual(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, lhs, rhs);
  }
}
