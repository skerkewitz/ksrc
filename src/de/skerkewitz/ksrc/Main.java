package de.skerkewitz.ksrc;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.ast.AstStatement;
import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.interpreter.impl.DefaultInterpreter;
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


		AstStatement s = new Builder().visit(tree);

		DefaultInterpreter interpreter = new DefaultInterpreter();
		interpreter.build_in_funcs.put("factorial", (vm, args1) -> { return "1"; });

		String ret = interpreter.exec( s);

		System.out.println("Done: " + ret);
	}

}
