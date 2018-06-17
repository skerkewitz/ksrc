package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstStatementDeclFunc extends AstStatement {

  public final AstExprIdent name;
  public final AstExprIdent[] paramIdents;
  public final AstStatements body;

  public AstStatementDeclFunc(SourceLocation srcLoc, AstExprIdent name, AstExprIdent[] paramIdents, AstStatements body) {
    super(srcLoc);
    this.name = name;
    this.paramIdents = paramIdents;
    this.body = body;
  }
}
