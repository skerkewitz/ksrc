package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStmtDeclFunc extends AstStmt {

  public final AstExprIdent name;
  public final AstExprIdent[] paramIdents;
  public final AstStmtList body;

  public AstStmtDeclFunc(SourceLocation srcLoc, AstExprIdent name, AstExprIdent[] paramIdents, AstStmtList body) {
    super(srcLoc);
    this.name = name;
    this.paramIdents = paramIdents;
    this.body = body;
  }
}
