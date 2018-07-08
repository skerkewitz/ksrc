package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

import java.util.HashMap;
import java.util.Map;

public final class VmDefaultExecContext implements VmExecContext {

    /** The parent is always readonly. If null then this is the global layer. */
    private final VmExecContext parent;

    private final Map<String, Vm.Value> symbolTable = new HashMap<>();
    private final Map<String, Vm.Function> funcTable = new HashMap<>();
    private final Map<String, Vm.ClassRef> classTable = new HashMap<>();

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
        if (value == null) {
          // use Vm.NullValue instead
          throw new IllegalArgumentException("value can not be null");
        }

        if (this.symbolTable.containsKey(name)) {
          throw new VmSymbolAlreadyDeclared(name);
        }

        this.symbolTable.put(name, value);
    }

  @Override
  public void setSymbolToValue(String ident, Vm.Value value) {
    if (value == null) {
      // use Vm.NullValue instead
      throw new IllegalArgumentException("value can not be null");
    }

    if (this.symbolTable.containsKey(ident)) {
      this.symbolTable.put(ident, value);
      return;
    }

    if (parent != null) {
      parent.setSymbolToValue(ident, value);
      return;
    }

    throw new VmUnknownSymbol(ident);
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

  @Override
  public void declareClass(Vm.ClassRef classRef) {
    String fqn = classRef.className;
    if (this.classTable.containsKey(fqn)) {
      throw new VmSymbolAlreadyDeclared(fqn);
    }

    this.classTable.put(fqn, classRef);

    var fref = ((Vm.FunctionRef) getFuncByName("init", new FunctionSignature(Type.VOID, null))).funcRef;

    // Hack for default constructor
    declareFunc(new Vm.FunctionRef(fqn, fref, new FunctionSignature(Type.ANY_REF, null)));
  }
}
