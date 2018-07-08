package de.skerkewitz.ksrc;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.ast.util.Walker;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.sema.SemaClassScanner;
import de.skerkewitz.ksrc.sema.SemaInferExpressionTypes;
import de.skerkewitz.ksrc.sema.SymbolTable;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.impl.DefaultVm;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Main {

  public static class W implements ParseTreeVisitor {
    @Override
    public Object visit(ParseTree tree) {
      return null;
    }

    @Override
    public Object visitChildren(RuleNode node) {
      return null;
    }

    @Override
    public Object visitTerminal(TerminalNode node) {
      return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode node) {
      return null;
    }
  }


  public static void main(String[] args) throws IOException {

    String inputFilename = args[0];
    System.out.println("Input file is: " + inputFilename);

    KSrcLexer lexer = new KSrcLexer(CharStreams.fromFileName(inputFilename));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    KSrcParser parser = new KSrcParser(tokens);

    // TODO: rename to translationunit
    ParseTree tree = parser.file_input();

//
////  ParseTreeWalker.DEFAULT.walk(null, tree);
//    String s = ((KSrcParser.File_inputContext) tree).toStringTree(parser);
//    System.out.println(s);

    /* Build AST tree. */
    AstStatement rootStatement = (AstStatement) new Builder().visit(tree);

    /* Print source. */
    Walker.PrintContext printContext = new Walker.PrintContext(new PrintStream(System.out));
    new Walker(printContext).walk(rootStatement);

    List<VmClassInfo> classInfos = SemaClassScanner.scan(rootStatement);
    for (var classInfo: classInfos) {
      System.out.println("Found class " + classInfo);
    }

    Sema sema = new Sema();
    sema.addClassDeclarations(classInfos);

    SemaInferExpressionTypes.walk(rootStatement, sema, new SymbolTable());

    new Walker(printContext).walk(rootStatement);


    /* Execute. */
    var vmExecContext = VmExecContextFactory.initialContext();
    //vmExecContext.declareFunc("factorial", (Vm.FunctionBuildIn) (vm, args1, execContext) -> new VmValueDouble(1.0));

    Vm vm = new DefaultVm();
    Vm.Value ret = vm.exec(rootStatement, vmExecContext);

    System.out.println("Done: " + ret.string_value());

  }

}
