package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstNode;

import java.util.Collections;
import java.util.List;

public class AstExprFunctionCall extends AstExpr {

  public final AstExpr fnName;
  public final Arguments arguments;

  public AstExprFunctionCall(SourceLocation sourceLocation, AstExpr fnName, Arguments arguments) {
    super(sourceLocation, null);
    this.fnName = fnName;
    this.arguments = arguments;
  }

  public static class Arguments extends AstNode {

    public final List<AstExpr> list;

    public Arguments(SourceLocation srcLocation, List<AstExpr> list) {
      super(srcLocation);
      this.list = Collections.unmodifiableList(list);
    }
  }
}
