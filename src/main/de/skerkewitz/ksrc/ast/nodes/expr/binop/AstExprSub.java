package de.skerkewitz.ksrc.ast.nodes.expr.binop;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

public class AstExprSub extends AstExprOp {

  public AstExprSub(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, lhs, rhs);
  }
}
