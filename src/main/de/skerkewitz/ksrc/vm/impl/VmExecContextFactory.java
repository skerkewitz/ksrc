package de.skerkewitz.ksrc.vm.impl;

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
    context.declareFunc("print", print_f);
    return context;
  }
}
