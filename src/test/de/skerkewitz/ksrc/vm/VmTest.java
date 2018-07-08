package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.vm.impl.DefaultVm;
import de.skerkewitz.ksrc.vm.impl.VmExecContext;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromInputStream;
import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VmTest {

  private Vm.Value eval(String input, Vm vm, VmExecContext vmExecCtx) throws IOException {
    ParseTree tree = parserFromString(input).expression();
    var sut = (AstExprFunctionCall) new Builder().visit(tree);
    return vm.eval(sut, vmExecCtx);
  }

  @Test
  void visitExprCall() throws IOException {

    ClassLoader classLoader = getClass().getClassLoader();
    URL somefile = classLoader.getResource("fib.ksrc");
    ParseTree treeLib = parserFromInputStream(somefile.openStream()).file_input();
    AstStatement rootStatementLib = (AstStatement) new Builder().visit(treeLib);

    var vmExecContext = VmExecContextFactory.initialContext();

    Vm vm = new DefaultVm(new Sema());
    Vm.Value ret = vm.exec(rootStatementLib, vmExecContext);

    assertEquals(0, eval("fib(0)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(1, eval("fib(1)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(1, eval("fib(2)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(2, eval("fib(3)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(3, eval("fib(4)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(5, eval("fib(5)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(8, eval("fib(6)\n", vm, vmExecContext).int_value().intValue());
    assertEquals(13, eval("fib(7)\n", vm, vmExecContext).int_value().intValue());


  }



}
