package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstParameter;
import de.skerkewitz.ksrc.ast.nodes.AstTypeIdentifier;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

import java.util.Collections;
import java.util.List;

public class AstDeclarationFunction extends AstStatement {

  public final AstExprIdent name;
  public final List<AstParameter> parameter;
  public final AstStatements body;
  public final AstTypeIdentifier returnType;

  public AstDeclarationFunction(SourceLocation srcLoc, AstExprIdent name, List<AstParameter> parameter, AstTypeIdentifier returnType, AstStatements body) {
    super(srcLoc);
    this.name = name;
    this.parameter = Collections.unmodifiableList(parameter);
    this.returnType = returnType;
    this.body = body;
  }
}
