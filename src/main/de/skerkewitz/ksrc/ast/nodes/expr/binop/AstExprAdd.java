package de.skerkewitz.ksrc.ast.nodes.expr.binop;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

public class AstExprAdd extends AstExprOp {

  public AstExprAdd(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, lhs, rhs);
  }
}
