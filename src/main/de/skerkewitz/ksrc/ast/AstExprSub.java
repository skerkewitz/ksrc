package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprSub extends AstExprOp {

  public AstExprSub(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, lhs, rhs);
  }
}
