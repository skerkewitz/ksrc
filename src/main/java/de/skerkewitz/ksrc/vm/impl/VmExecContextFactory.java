package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.io.PrintStream;
import java.util.List;

public final class VmExecContextFactory {

  private VmExecContextFactory() {
  }

  private final static Vm.Function.BuildIn print_f = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    PrintStream p = new PrintStream(VmDefaultExecContext.stdout);
    p.print(eval.string_value());
    return VmValueVoid.shared;
  };

  private final static Vm.Function.BuildIn println_f = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    PrintStream p = new PrintStream(VmDefaultExecContext.stdout);
    p.println(eval.string_value());
    return VmValueVoid.shared;
  };

  private final static Vm.Function.BuildIn println_f_i = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    PrintStream p = new PrintStream(VmDefaultExecContext.stdout);
    p.println(eval.int_value());
    return VmValueVoid.shared;
  };

  private final static Vm.Function.BuildIn println_f_z = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    PrintStream p = new PrintStream(VmDefaultExecContext.stdout);
    p.println(eval.bool_value());
    return VmValueVoid.shared;
  };

  private final static Vm.Function.BuildIn str_f = (vm, args, execContext) -> {
    Vm.Value eval = vm.eval(args.get(0), execContext);
    return new VmValueString(eval.string_value());
  };

  public static VmExecContext initialContext() {
    var context = new VmDefaultExecContext(null);

    for (var f : buildInFunctionList()) {
      context.declareFunc(f);
    }

    return context;
  }

  public static List<Vm.Function> buildInFunctionList() {
    return List.of(
            new Vm.Function(new VmMethodInfo("print", VmMethodDescriptor.fromString("(S)V"), null), print_f),
            new Vm.Function(new VmMethodInfo("println", VmMethodDescriptor.fromString("(S)V"), null), println_f),
            new Vm.Function(new VmMethodInfo("println", VmMethodDescriptor.fromString("(I)V"), null), println_f_i),
            new Vm.Function(new VmMethodInfo("println", VmMethodDescriptor.fromString("(Z)V"), null), println_f_z),
            new Vm.Function(new VmMethodInfo("str", VmMethodDescriptor.fromString("(I)S"), null), str_f)
    );
  }
}
