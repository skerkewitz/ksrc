package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;

import java.util.HashMap;
import java.util.Map;

public final class VmDefaultExecContext implements VmExecContext {

    /** The parent is always readonly. If null then this is the global layer. */
    private final VmExecContext parent;

    private final Map<String, Vm.Value> symbolTable = new HashMap<>();
    private final Map<String, Vm.Function> funcTable = new HashMap<>();

    public VmDefaultExecContext(VmExecContext parent) {
        this.parent = parent;
    }

    @Override
    public Vm.Value getSymbolByName(String name) {
        var symbol = this.symbolTable.get(name);
        if (symbol != null) {
          return symbol;
        }

        if (parent != null) {
          return parent.getSymbolByName(name);
        }

        throw new VmUnknownSymbol(name);
    }

    @Override
    public void declareSymbol(String name, Vm.Value value) {
        if (this.symbolTable.containsKey(name)) {
          throw new VmSymbolAlreadyDeclared(name);
        }

        this.symbolTable.put(name, value);
    }

  @Override
  public Vm.Function getFuncByName(String name) {
    var symbol = this.funcTable.get(name);
    if (symbol != null) {
      return symbol;
    }

    if (parent != null) {
      return parent.getFuncByName(name);
    }

    throw new VmUnknownSymbol(name);
  }

  @Override
  public void declareFunc(String name, Vm.Function func) {
    if (this.funcTable.containsKey(name)) {
      throw new VmSymbolAlreadyDeclared(name);
    }

    this.funcTable.put(name, func);
  }

}
