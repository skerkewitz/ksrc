package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.util.List;

public interface VmExecContext {

  Vm.Value getSymbolByName(String name);
  void declareSymbol(String name, Vm.Value value);
  void setSymbolToValue(String ident, Vm.Value value);

  Vm.Function getFunctionByName(String name, VmMethodDescriptor descriptor);
  List<Vm.Function> findMatchesByFunctionNameAndParameterList(String functionName, List<VmDescriptor> parameterDescriptors);
  void declareFunc(Vm.Function function);

  boolean shouldLeaveFrame();
  void markLeaveFrame();




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
