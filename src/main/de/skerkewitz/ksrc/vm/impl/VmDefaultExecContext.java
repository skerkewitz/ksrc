package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.vm.Vm;

import java.util.HashMap;
import java.util.Map;

public final class VmDefaultExecContext implements VmExecContext {

    /** The parent is always readonly. If null then this is the global layer. */
    private final VmExecContext parent;

    private final Map<String, Vm.Value> symbolTable = new HashMap<>();
    private final Map<String, Vm.Function> funcTable = new HashMap<>();

    private boolean _leaveFrame = false;

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
  public Vm.Function getFuncByName(String name, FunctionSignature signature) {
    String fqn = name;
    var symbol = this.funcTable.get(fqn);
    if (symbol != null) {
      return symbol;
    }

    if (parent != null) {
      return parent.getFuncByName(name, signature);
    }

    throw new VmUnknownSymbol(fqn);
  }

  @Override
  public void declareFunc(Vm.Function func) {
    String fqn = func.name;
    if (this.funcTable.containsKey(fqn)) {
      throw new VmSymbolAlreadyDeclared(fqn);
    }

    this.funcTable.put(fqn, func);
  }

  @Override
  public boolean shouldLeaveFrame() {
    return _leaveFrame;
  }

  @Override
  public void markLeaveFrame() {
      _leaveFrame = true;
  }
}
