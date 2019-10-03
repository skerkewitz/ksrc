package de.skerkewitz.ksrc.parse.ast.nodes.statement;

import de.skerkewitz.ksrc.common.SourceLocation;

import java.util.Collections;
import java.util.List;

public class AstStatements extends AstStatement {

  public final List<AstStatement> statements;

  public AstStatements(SourceLocation srcLocation, List<AstStatement> statements) {
    super(srcLocation);
    this.statements = Collections.unmodifiableList(statements);

    for (var statement : statements) {
      if (statement == null) {
        throw new IllegalArgumentException("sub statement can not be null");
      }
      this.addChild(statement);
    }
  }
}
