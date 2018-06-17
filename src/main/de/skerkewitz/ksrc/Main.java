package de.skerkewitz.ksrc;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.ast.AstStatement;
import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.interpreter.Interpreter;
import de.skerkewitz.ksrc.interpreter.impl.DefaultVm;
import de.skerkewitz.ksrc.interpreter.impl.VmExecContextFactory;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {


	public static void main(String[] args) throws IOException {

		String inputFilename = args[0];
		System.out.println("Input file is: " + inputFilename);

		KSrcLexer lexer = new KSrcLexer(CharStreams.fromFileName(inputFilename));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		KSrcParser parser = new KSrcParser(tokens);
		ParseTree tree = parser.file_input();

		/* Build AST tree. */
		AstStatement rootStatement = new Builder().visit(tree);

		var vmExecContext = VmExecContextFactory.initialContext();
		vmExecContext.declareFunc("factorial", (Interpreter.VmFuncBuildIn) (vm, args1, execContext) -> "1");

		DefaultVm vm = new DefaultVm();
		String ret = vm.exec(rootStatement, vmExecContext);

		System.out.println("Done: " + ret);
	}

}
