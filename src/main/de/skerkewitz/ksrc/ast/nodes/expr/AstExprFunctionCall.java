package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprFunctionCall extends AstExpr {

  public final String fnName;
  public final AstExpr[] args;

  public AstExprFunctionCall(SourceLocation sourceLocation, String fnName, AstExpr[] args) {
    super(sourceLocation, null);
    this.fnName = fnName;
    this.args = args;
  }
}
