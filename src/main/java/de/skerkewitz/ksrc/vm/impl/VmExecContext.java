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
  List<Vm.Function> findFunctionsByNameAndParameters(String functionName, List<VmDescriptor> parameterDescriptors);
  void declareFunc(Vm.Function function);

  boolean shouldLeaveFrame();
  void resetLeaveFrame();

  Vm.Value getReturnValue();

  /**
   * Specifies the value the frame should return null. Null indicate a break instead of a return.
   * Use(or {@link de.skerkewitz.ksrc.vm.impl.VmValueVoid#shared} to return void.
   */
  void markLeaveFrame(Vm.Value returnValue);


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
