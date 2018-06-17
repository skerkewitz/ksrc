package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;

public interface VmExecContext {

  Vm.Value getSymbolByName(String name);
  void declareSymbol(String name, Vm.Value value);

  Vm.Function getFuncByName(String name);
  void declareFunc(String name, Vm.Function func);

  boolean shouldLeaveFrame();

  void markLeaveFrame();

  class VmUnknownSymbol extends RuntimeException {
    private final String name;

    public VmUnknownSymbol(String name) {
      this.name = name;
    }
  }

  class VmSymbolAlreadyDeclared extends RuntimeException {
    private final String name;

    public VmSymbolAlreadyDeclared(String name) {
      this.name = name;
    }
  }
}
