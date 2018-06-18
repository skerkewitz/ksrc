package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

public class AstDeclarationLet extends AstStatement {

  public final AstExprIdent name;
  public final AstExpr value;

  public AstDeclarationLet(SourceLocation srcLoc, AstExprIdent name, AstExpr value) {
    super(srcLoc);
    this.name = name;
    this.value = value;
  }
}
