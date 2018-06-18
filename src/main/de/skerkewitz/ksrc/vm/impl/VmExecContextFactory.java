package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public final class VmExecContextFactory {

  private VmExecContextFactory() {
  }

  private final static Vm.FunctionBuildIn print_f = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args[0], execContext);
    System.out.println(eval.str());
    return VmValueVoid.shared;
  };

  public static VmExecContext initialContext() {
    var context = new VmDefaultExecContext(null);
    context.declareFunc(new Vm.FunctionBuildInRef("print", print_f, new FunctionSignature(Type.VOID, new Type[]{Type.STRING})));
    return context;
  }
}
