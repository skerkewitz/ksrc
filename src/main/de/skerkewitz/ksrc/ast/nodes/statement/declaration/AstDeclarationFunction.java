package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstParameter;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

public class AstDeclarationFunction extends AstStatement {

  public final AstExprIdent name;
  public final AstParameter[] parameter;
  public final AstStatements body;

  public AstDeclarationFunction(SourceLocation srcLoc, AstExprIdent name, AstParameter[] parameter, AstStatements body) {
    super(srcLoc);
    this.name = name;
    this.parameter = parameter;
    this.body = body;
  }
}
