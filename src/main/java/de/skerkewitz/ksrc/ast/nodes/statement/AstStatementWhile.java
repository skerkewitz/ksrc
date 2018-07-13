package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

/**
 * A while thenStatement allows a block of code to be executed repeatedly, as long as a condition remains true.
 */
public class AstStatementWhile extends AstStatement {

  public final AstStatements body;
  public final AstExpr condition;

  public AstStatementWhile(SourceLocation srcLocation, AstExpr condition, AstStatements body) {
    super(srcLocation);
    this.body = body;
    this.condition = condition;
  }
}
