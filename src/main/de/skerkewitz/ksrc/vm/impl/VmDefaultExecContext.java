package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
  public Vm.Function getFunctionByName(String name, VmMethodDescriptor descriptor) {
    String fqn = name;
    var symbol = this.funcTable.get(fqn);
    if (symbol != null) {
      /* Make sure the descriptor matches. */
      if (symbol.methodInfo.descriptor.equals(descriptor)) {
        return symbol;
      }

      throw new VmRuntimeException("Require function of type '" + descriptor + "' but found '" + symbol.methodInfo.descriptor + "'", null);
    }

    if (parent != null) {
      return parent.getFunctionByName(name, descriptor);
    }

    throw new VmUnknownFunction(name, descriptor);
  }

  @Override
  public List<Vm.Function> findFunctionsByNameAndParameters(String functionName, List<VmDescriptor> parameterDescriptors) {

    Stream<Vm.Function> functionStream = this.funcTable.values().stream()
            .filter(function -> function.methodInfo.name.equals(functionName))
            .filter(function -> function.methodInfo.descriptor.parameterDescriptor.equals(parameterDescriptors));


    List<Vm.Function> parents = Collections.EMPTY_LIST;
    if (parent != null) {
      parents = parent.findFunctionsByNameAndParameters(functionName, parameterDescriptors);
    }

    return Stream.concat(functionStream, parents.stream()).distinct().collect(Collectors.toList());
  }

  @Override
  public void declareFunc(Vm.Function function) {
    String fqn = function.methodInfo.name;
    if (this.funcTable.containsKey(fqn)) {
      throw new VmSymbolAlreadyDeclared(fqn);
    }

    this.funcTable.put(fqn, function);
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
