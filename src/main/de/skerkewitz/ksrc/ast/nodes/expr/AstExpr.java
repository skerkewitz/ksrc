package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

public abstract class AstExpr extends AstStatement {

  /** The type of the result of this expression. */
  public final Type type;

  public AstExpr(SourceLocation srcLocation, Type type) {
    super(srcLocation);
    this.type = type;
  }
}
