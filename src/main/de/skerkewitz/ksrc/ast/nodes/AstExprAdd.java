package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprAdd extends AstExprOp {

  public AstExprAdd(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, lhs, rhs);
  }
}
