package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

/**
 * Only used to group all declaration statements.
 */
public abstract class AstDeclarationStatement extends AstStatement {

  public AstDeclarationStatement(SourceLocation srcLocation) {
    super(srcLocation);
  }
}
