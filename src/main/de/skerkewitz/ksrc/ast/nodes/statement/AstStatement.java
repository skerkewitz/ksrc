package de.skerkewitz.ksrc.ast.nodes.statement;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstNode;

public abstract class AstStatement extends AstNode {

  public AstStatement(SourceLocation srcLocation) {
    super(srcLocation);
  }
}
