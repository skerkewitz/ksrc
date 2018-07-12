package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprExplicitMemberAccess extends AstExpr {

  public final AstExpr lhs;
  public final AstExpr rhs;

  public boolean isFieldAccess = true;

  public AstExprExplicitMemberAccess(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
    super(srcLocation, null);
    this.lhs = lhs;
    this.rhs = rhs;
  }
}
