package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

import java.util.Collections;
import java.util.List;

public class AstStatements extends AstStatement {

  public final List<AstStatement> statements;

  public AstStatements(SourceLocation srcLocation, List<AstStatement> statements) {
    super(srcLocation);
    this.statements = Collections.unmodifiableList(statements);
  }
}
