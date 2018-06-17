package de.skerkewitz.ksrc.interpreter;

public class VmSymbolAlreadyDeclared extends RuntimeException {
  private final String name;

  public VmSymbolAlreadyDeclared(String name) {
    this.name = name;
  }
}
