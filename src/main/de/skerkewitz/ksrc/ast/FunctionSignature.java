package de.skerkewitz.ksrc.ast;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FunctionSignature {

  public final Type returnType;
  public final Type[] arguments;

  public FunctionSignature(Type returnType, Type[] arguments) {
    this.returnType = returnType;
    this.arguments = arguments;
  }

  @Override
  public String toString() {
    String args = Arrays.stream(arguments == null ? new Type[0] : arguments)
            .map(Enum::toString)
            .collect(Collectors.joining(","));
    return "(" + args + "):(" + returnType + ")";
  }
}
