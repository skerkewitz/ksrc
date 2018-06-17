package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprFuncCall extends AstExpr {

  public final String fnName;
  public final AstExpr[] args;

  public AstExprFuncCall(SourceLocation sourceLocation, String fnName, AstExpr[] args) {
    super(sourceLocation);
    this.fnName = fnName;
    this.args = args;
  }
}
