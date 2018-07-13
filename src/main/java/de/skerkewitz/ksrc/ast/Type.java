package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.impl.VmValueDouble;
import de.skerkewitz.ksrc.vm.impl.VmValueInt;
import de.skerkewitz.ksrc.vm.impl.VmValueString;
import org.antlr.v4.runtime.Token;

public enum Type {

  VOID,
  BOOL,
  INT,
  DOUBLE,
  STRING,
  ANY_REF,
  FUNCTION;

  public static Type fromToken(Token token) {
    /* Determine descriptor. */
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

  public Vm.Value getDefault_init_value() {
    switch (this) {
      case VOID:
        return null;
      case BOOL:
        return new VmValueInt(0);
      case INT:
        return new VmValueInt(0);
      case DOUBLE:
        return new VmValueDouble(0.0);
      case STRING:
        return new VmValueString("");
      case ANY_REF:
        return null;
      case FUNCTION:
        return null;
    }

    throw new RuntimeException("Unknown type " + this);
  }
}
