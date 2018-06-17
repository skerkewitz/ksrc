package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStatementDeclLet extends AstStatement {

  public final AstExprIdent name;
  public final AstExpr value;

  public AstStatementDeclLet(SourceLocation srcLoc, AstExprIdent name, AstExpr value) {
    super(srcLoc);
    this.name = name;
    this.value = value;
  }
}
