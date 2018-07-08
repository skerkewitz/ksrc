package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.AstTypeIdentifier;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

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
    public final AstTypeIdentifier typename;

    public Parameter(SourceLocation srcLoc, AstExprIdent name, AstTypeIdentifier typename) {
      super(srcLoc);
      this.name = name;
      this.typename = typename;
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
