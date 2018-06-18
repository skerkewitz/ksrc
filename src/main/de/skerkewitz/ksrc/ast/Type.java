package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcParser;
import org.antlr.v4.runtime.Token;

public enum Type {

  VOID, NUMBER, STRING, FUNCTION;

  public static Type fromToken(Token token) {
    /* Determine type. */
    switch (token.getType()) {
      case KSrcParser.STRING: return STRING;
      case KSrcParser.NUMBER: return NUMBER;
      default: return VOID;
    }
  }

  public static Type valueOfIgnoreCare(String name) {
    return Type.valueOf(name.toUpperCase());
  }

}
