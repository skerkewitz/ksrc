package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcParser;
import org.antlr.v4.runtime.Token;

public enum Type {

  VOID, INT, DOUBLE, STRING, ANY_REF, FUNCTION;

  public static Type fromToken(Token token) {
    /* Determine type. */
    switch (token.getType()) {
      case KSrcParser.STRING: return STRING;
      case KSrcParser.DECIMAL_INTEGER: return INT;
      case KSrcParser.FLOAT_LITERAL: return DOUBLE;
      default: return VOID;
    }
  }

  public static Type valueOfIgnoreCare(String name) {
    return Type.valueOf(name.toUpperCase());
  }

}
