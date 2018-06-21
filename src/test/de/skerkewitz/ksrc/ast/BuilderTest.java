package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprValue;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

  @Test
  void visitExprCall() throws IOException {

    var input = "myPrint(2, 6)\n";

    ParseTree tree = parserFromString(input).expression();
    var sut = (AstExprFunctionCall) new Builder().visit(tree);

    assertEquals("myPrint", sut.fnName);
    assertEquals(2, sut.args.length);
    assertEquals("2", ((AstExprValue)sut.args[0]).value);
    assertEquals("6", ((AstExprValue)sut.args[1]).value);
  }
}