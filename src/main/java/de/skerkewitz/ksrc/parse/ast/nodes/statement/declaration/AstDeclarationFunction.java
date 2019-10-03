package de.skerkewitz.ksrc.parse.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;
import de.skerkewitz.ksrc.parse.ast.nodes.AstTypeIdentifier;
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprIdent;

import java.util.Collections;
import java.util.List;

public class AstDeclarationFunction extends AstDeclarationStatement {

  /** Defines a single parameter in a function declaration. */
  public static class Signature extends AstNode {

    public final List<Parameter> params;
    public final AstTypeIdentifier returnType;

    public Signature(SourceLocation srcLoc, AstFunctionParameters params, AstTypeIdentifier returnType) {
      super(srcLoc);
      this.params = params == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(params.params);
      this.returnType = returnType == null ? new AstTypeIdentifier(srcLoc, "Void") : returnType;
    }
  }

  /** Defines a single parameter in a function declaration. */
  public static class Parameter extends AstNode {

    public final AstExprIdent name;
    public final AstTypeIdentifier type;

    public Parameter(SourceLocation srcLoc, AstExprIdent name, AstTypeIdentifier type) {
      super(srcLoc);
      this.name = name;
      this.type = type;
    }
  }

  public final AstExprIdent name;
  public final Signature signature;
  public final AstStatements body;

  public AstDeclarationFunction(SourceLocation srcLoc, AstExprIdent name, Signature signature, AstStatements body) {
    super(srcLoc);
    this.name = name;
    this.signature = signature;
    this.body = body;
  }



}
