package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStmtDeclIf extends AstStmt {

  public final AstExpr condition;
  public final AstStmt statement;

  public AstStmtDeclIf(SourceLocation sourceLocation, AstExpr condition, AstStmt statement) {
    super(sourceLocation);
    this.condition = condition;
    this.statement = statement;
  }
}
