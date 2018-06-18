package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

public class AstStatementIf extends AstStatement {

  public final AstExpr condition;
  public final AstStatement statement;

  public AstStatementIf(SourceLocation sourceLocation, AstExpr condition, AstStatement statement) {
    super(sourceLocation);
    this.condition = condition;
    this.statement = statement;
  }
}
