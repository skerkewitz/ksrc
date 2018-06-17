package de.skerkewitz.ksrc;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.ast.AstStmt;
import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.impl.DefaultVm;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;
import de.skerkewitz.ksrc.vm.impl.VmValueNumber;
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
    AstStmt rootStatement = new Builder().visit(tree);

    var vmExecContext = VmExecContextFactory.initialContext();
    vmExecContext.declareFunc("factorial", (Vm.FunctionBuildIn) (vm, args1, execContext) -> new VmValueNumber(1.0));

    Vm vm = new DefaultVm();
    Vm.Value ret = vm.exec(rootStatement, vmExecContext);

    System.out.println("Done: " + ret.str());
  }

}
