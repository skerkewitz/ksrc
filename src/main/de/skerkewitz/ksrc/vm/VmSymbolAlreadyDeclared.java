package de.skerkewitz.ksrc.vm;

public class VmSymbolAlreadyDeclared extends RuntimeException {
  private final String name;

  public VmSymbolAlreadyDeclared(String name) {
    this.name = name;
  }
}
