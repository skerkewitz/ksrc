package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstNode;

import java.util.List;

public class AstFunctionParameters extends AstNode {

  public final List<AstDeclarationFunction.Parameter> params;

  public AstFunctionParameters(SourceLocation srcLocation, List<AstDeclarationFunction.Parameter> params) {
    super(srcLocation);
    this.params = params;
  }
}
