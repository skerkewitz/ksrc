package de.skerkewitz.ksrc.parse.ast.nodes.statement;

import de.skerkewitz.ksrc.common.SourceLocation;

/** Breaks the most inner loop. */
public class AstStatementBreak extends AstStatement {

  public AstStatementBreak(SourceLocation srcLocation) {
    super(srcLocation);
  }
}
