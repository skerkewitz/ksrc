package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationStatement;

import java.util.List;

public class AstDeclarationClass extends AstDeclarationStatement {
  public final AstExprIdent name;
  public final List<AstDeclarationFunction> functions;

  public AstDeclarationClass(SourceLocation sourceLocation, AstExprIdent name, List<AstDeclarationFunction> functions) {
    super(sourceLocation);
    this.name = name;
    this.functions = functions;
  }
}
