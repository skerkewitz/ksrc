package de.skerkewitz.ksrc.vm;

public class VmUnknownSymbol extends RuntimeException {
  private final String name;

  public VmUnknownSymbol(String name) {
    this.name = name;
  }


}
