package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprFunctionCall extends AstExpr {

  public final AstExpr fnName;
  public final AstExpr[] args;

  public AstExprFunctionCall(SourceLocation sourceLocation, AstExpr fnName, AstExpr[] args) {
    super(sourceLocation, null);
    this.fnName = fnName;
    this.args = args;
  }
}
