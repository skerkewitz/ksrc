package de.skerkewitz.ksrc.parse.ast.nodes.statement;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;

public abstract class AstStatement extends AstNode {

  public AstStatement(SourceLocation srcLocation) {
    super(srcLocation);
  }
}
