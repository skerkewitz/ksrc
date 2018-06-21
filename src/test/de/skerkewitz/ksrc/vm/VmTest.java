package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.statement.AstAssignStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.vm.impl.DefaultVm;
import de.skerkewitz.ksrc.vm.impl.VmExecContext;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromInputStream;
import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    Vm vm = new DefaultVm();
    Vm.Value ret = vm.exec(rootStatementLib, vmExecContext);

    assertEquals(0.0, eval("fib(0)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(1.0, eval("fib(1)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(1.0, eval("fib(2)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(2.0, eval("fib(3)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(3.0, eval("fib(4)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(5.0, eval("fib(5)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(8.0, eval("fib(6)\n", vm, vmExecContext).num().doubleValue());
    assertEquals(13.0, eval("fib(7)\n", vm, vmExecContext).num().doubleValue());


  }



}
