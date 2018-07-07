package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.vm.Vm;

public interface VmExecContext {

  Vm.Value getSymbolByName(String name);
  void declareSymbol(String name, Vm.Value value);
  void setSymbolToValue(String ident, Vm.Value value);

  Vm.Function getFuncByName(String name, FunctionSignature signature);
  void declareFunc(Vm.Function func);

  boolean shouldLeaveFrame();

  void markLeaveFrame();

  void declareClass(Vm.ClassRef classRef);


  class VmUnknownSymbol extends RuntimeException {
    private final String name;

    public VmUnknownSymbol(String name) {
      super("Unknown VM symbol '" + name + "'");
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
