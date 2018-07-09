package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

public final class VmExecContextFactory {

  private VmExecContextFactory() {
  }

  private final static Vm.Function.BuildIn print_f = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    System.out.print(eval.string_value());
    return VmValueVoid.shared;
  };

  private final static Vm.Function.BuildIn println_f = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    System.out.println(eval.string_value());
    return VmValueVoid.shared;
  };

  public static VmExecContext initialContext() {
    var context = new VmDefaultExecContext(null);
    context.declareFunc(new Vm.Function(new VmMethodInfo("print", VmMethodDescriptor.fromString("(S)Z"), null), print_f));
    context.declareFunc(new Vm.Function(new VmMethodInfo("println", VmMethodDescriptor.fromString("(S)Z"), null), println_f));
    return context;
  }
}
