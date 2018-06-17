package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprValue extends AstExpr {

  public final String value;

  public AstExprValue(SourceLocation srcLocation, String value) {
    super(srcLocation);
    this.value = value;
  }

}
