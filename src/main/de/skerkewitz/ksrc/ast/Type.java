package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.impl.VmValueDouble;
import de.skerkewitz.ksrc.vm.impl.VmValueInt;
import de.skerkewitz.ksrc.vm.impl.VmValueString;
import org.antlr.v4.runtime.Token;

public enum Type {

  VOID(null),
  BOOL(new VmValueInt(0)),
  INT(new VmValueInt(0)),
  DOUBLE(new VmValueDouble(0.0)),
  STRING(new VmValueString("")),
  ANY_REF(null),                      // Any class reference
  FUNCTION(null);

  public final Vm.Value default_init_value;

  Type(Vm.Value default_init_value) {
    this.default_init_value = default_init_value;
  }

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
