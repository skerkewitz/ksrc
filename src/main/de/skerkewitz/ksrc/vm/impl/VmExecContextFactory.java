package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Interpreter;

public final class VmExecContextFactory {

	private VmExecContextFactory() {
	}

	private final static Interpreter.VmFuncBuildIn print_f = (vm, args, execContext) -> {
		String eval = vm.eval(args[0], execContext);
		System.out.println(eval);
		return eval;
	};


	public static Interpreter.VmExecContext initialContext() {

		var context = new Interpreter.VmExecContext(null);
		context.declareFunc("print", print_f);
		return context;
	}
}
