package de.skerkewitz.ksrc;

import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.util.Walker;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.sema.SemaFactory;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.impl.DefaultVm;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.io.PrintStream;

public class Main {


  public static void main(String[] args) throws IOException {

    String inputFilename = args[0];
    System.out.println("Input file is: " + inputFilename);

    /* Build AST tree. */
    final CharStream charStream = CharStreams.fromFileName(inputFilename);
    AstStatement rootStatement = (AstStatement) KSrcAstParser.parse(charStream);

//    /* Print source. */
//    new Walker(new Walker.PrintContext(new PrintStream(System.out))).walk(rootStatement);

    final Sema sema = SemaFactory.buildSemaFromRootStatement(rootStatement);

    new Walker(new Walker.PrintContext(new PrintStream(System.out))).walk(rootStatement);

    /* Execute. */
    Vm vm = new DefaultVm(sema);
    var vmExecContext = VmExecContextFactory.initialContext();
    Vm.Value ret = vm.exec(rootStatement, vmExecContext);

    System.out.println("\n\n---");
    System.out.println("EvalValue : " + ret.string_value());
    System.out.println("EvalType  : " + ret.descriptor());

  }

}
