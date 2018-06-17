package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;

public class AstExprValue extends AstExpr {

  public final String value;
  public final Type type;

  public AstExprValue(SourceLocation srcLocation, String value, Type type) {
    super(srcLocation);
    this.value = value;
    this.type = type;
  }

}
