package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprPrefixOp extends AstExpr {

  public enum Token {
    MINUS,
    NOT;


    public static Token fromAstToken(int t) {
      switch (t) {
        case KSrcLexer.MINUS:
          return MINUS;
        case KSrcLexer.NOT:
          return NOT;
      }

      throw new IllegalArgumentException("Unknown token '" + t + "'");
    }
  }


  public final AstExpr lhs;
  public final Token op;

  public AstExprPrefixOp(SourceLocation srcLocation, AstExpr lhs, Token op) {
    super(srcLocation, null);
    this.lhs = lhs;
    this.op = op;
  }

  public static class Minus extends AstExprPrefixOp {
    public Minus(SourceLocation srcLocation, AstExpr lhs) {
      super(srcLocation, lhs, Token.MINUS);
    }
  }

  public static class Not extends AstExprPrefixOp {
    public Not(SourceLocation sourceLocation, AstExpr lhs) {
      super(sourceLocation, lhs, Token.NOT);
    }
  }
}
