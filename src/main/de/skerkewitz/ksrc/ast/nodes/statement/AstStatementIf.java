package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

public class AstStatementIf extends AstStatement {

  public final AstExpr condition;
  public final AstStatement thenStatement;
  public final AstStatement elseStatement;

  public AstStatementIf(SourceLocation sourceLocation, AstExpr condition, AstStatement thenStatement, AstStatement elseStatement) {
    super(sourceLocation);

    if (condition == null) {
      throw new IllegalArgumentException("condition can not be null");
    }

    if (thenStatement == null) {
      throw new IllegalArgumentException("thenStatement can not be null");
    }

    this.condition = condition;
    this.thenStatement = thenStatement;
    this.elseStatement = elseStatement;
  }
}
