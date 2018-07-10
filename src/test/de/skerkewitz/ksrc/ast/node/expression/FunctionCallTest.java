package de.skerkewitz.ksrc.ast.node.expression;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprLiteral;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FunctionCallTest {

  @Test
  void integerLiteral() throws IOException {

    var input = "print(\"Hello World\")\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstExprFunctionCall) new Builder().visit(tree);

    assertNull(sut.descriptor);
    assertEquals("print", ((AstExprIdent)sut.fnName).ident);
    assertEquals(1, sut.arguments.list.size());
    assertEquals(VmDescriptor.String, sut.arguments.list.get(0).descriptor);
  }

  @Test
  void visitExprCall() throws IOException {
    var input = "myPrint(2, 6)\n";

    ParseTree tree = parserFromString(input).expression();
    var sut = (AstExprFunctionCall) new Builder().visit(tree);

    assertEquals("myPrint", ((AstExprIdent)sut.fnName).ident);
    assertEquals(2, sut.arguments.list.size());
    assertEquals("2", ((AstExprLiteral)sut.arguments.list.get(0)).value);
    assertEquals("6", ((AstExprLiteral)sut.arguments.list.get(1)).value);
  }
}
