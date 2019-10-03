package de.skerkewitz.ksrc.parse.ast.nodes.expr;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;

import java.util.Collections;
import java.util.List;

public class AstExprFunctionCall extends AstExpr {

  public final AstExpr fnName;
  public final Arguments arguments;

  public AstExprFunctionCall(SourceLocation sourceLocation, AstExpr fnName, Arguments arguments) {
    super(sourceLocation, null);
    this.fnName = fnName;
    this.arguments = arguments;

    if (fnName instanceof AstExprExplicitMemberAccess) {
      /* Must be a call! */
      ((AstExprExplicitMemberAccess) fnName).isFieldAccess = false;
    }
  }

  public static class Arguments extends AstNode {

    public final List<AstExpr> list;

    public Arguments(SourceLocation srcLocation, List<AstExpr> list) {
      super(srcLocation);
      this.list = Collections.unmodifiableList(list);
    }
  }

  public boolean isDirectFunctionCall() {
    return fnName instanceof AstExprIdent;
  }

  public boolean isMemberFunctionCall() {
    return fnName instanceof AstExprExplicitMemberAccess;
  }

  public AstExprIdent getFunctionNameIdent() {
    return (AstExprIdent) fnName;
  }
}
