package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStmtDeclLet extends AstStmt {

  public final AstExprIdent name;
  public final AstExpr value;

  public AstStmtDeclLet(SourceLocation srcLoc, AstExprIdent name, AstExpr value) {
    super(srcLoc);
    this.name = name;
    this.value = value;
  }
}
