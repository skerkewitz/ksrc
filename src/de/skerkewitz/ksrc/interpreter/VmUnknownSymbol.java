package de.skerkewitz.ksrc.interpreter;

public class VmUnknownSymbol extends RuntimeException {
  private final String name;

  public VmUnknownSymbol(String name) {
    this.name = name;
  }


}
