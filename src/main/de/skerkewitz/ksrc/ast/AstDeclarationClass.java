package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationNamedValue;

import java.util.List;

public class AstDeclarationClass extends AstDeclarationStatement {
  public final AstExprIdent name;
  public final List<AstDeclarationFunction> functions;
  public final List<AstDeclarationNamedValue> fields;

  public AstDeclarationClass(SourceLocation sourceLocation, AstExprIdent name, List<AstDeclarationFunction> functions, List<AstDeclarationNamedValue> fields) {
    super(sourceLocation);
    this.name = name;
    this.functions = functions;
    this.fields = fields;
  }
}
