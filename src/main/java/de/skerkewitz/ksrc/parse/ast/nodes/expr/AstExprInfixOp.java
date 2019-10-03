package de.skerkewitz.ksrc.parse.ast.nodes.expr;

import de.skerkewitz.ksrc.parse.antlr.KSrcLexer;
import de.skerkewitz.ksrc.common.SourceLocation;

public class AstExprInfixOp extends AstExpr {

  public enum Token {
    POW,

    MINUS,
    MULT,
    DIV,
    MOD,
    PLUS,

    LTEQ,
    GTEQ,
    LT,
    GT,
    EQ,
    IDEQ,
    NEQ,

    AND,
    OR;

    public static Token fromAstToken(int t) {
      switch (t) {
        case KSrcLexer.POW:
          return POW;

        case KSrcLexer.MINUS:
          return MINUS;
        case KSrcLexer.MULT:
          return MULT;
        case KSrcLexer.DIV:
          return DIV;
        case KSrcLexer.MOD:
          return MOD;
        case KSrcLexer.PLUS:
          return PLUS;

        case KSrcLexer.LTEQ:
          return LTEQ;
        case KSrcLexer.GTEQ:
          return GTEQ;
        case KSrcLexer.LT:
          return LT;
        case KSrcLexer.GT:
          return GT;
        case KSrcLexer.EQ:
          return EQ;
        case KSrcLexer.IDEQ:
          return IDEQ;
        case KSrcLexer.NEQ:
          return NEQ;

        case KSrcLexer.AND:
          return AND;
        case KSrcLexer.OR:
          return OR;
      }

      throw new IllegalArgumentException("Unknown token '" + t + "'");
    }
  }


  public final AstExpr lhs;
  public final AstExpr rhs;
  public final Token op;

  public AstExprInfixOp(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs, Token op) {
    super(srcLocation, null);

    if (lhs == null) {
      throw new IllegalArgumentException("lhs can not be null");
    }

    if (rhs == null) {
      throw new IllegalArgumentException("rhs can not be null");
    }


    this.lhs = lhs;
    this.rhs = rhs;
    this.op = op;
  }

  public static class Add extends AstExprInfixOp {
    public Add(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
      super(srcLocation, lhs, rhs, Token.PLUS);
    }
  }

  public static class Mul extends AstExprInfixOp {
    public Mul(SourceLocation sourceLocation, AstExpr lhs, AstExpr rhs) {
      super(sourceLocation, lhs, rhs, Token.MULT);
    }
  }

  public static class Equal extends AstExprInfixOp {

    public Equal(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
      super(srcLocation, lhs, rhs, Token.EQ);
    }
  }

  public static class Sub extends AstExprInfixOp {
      public Sub(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
      super(srcLocation, lhs, rhs, Token.MINUS);
    }
  }
}
