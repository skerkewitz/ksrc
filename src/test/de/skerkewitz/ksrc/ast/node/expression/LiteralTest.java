package de.skerkewitz.ksrc.ast.node.expression;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprValue;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiteralTest {

  @Test
  void integerLiteral() throws IOException {

    var input = "55\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstExprValue) new Builder().visit(tree);

    assertEquals("55", sut.value);
    assertEquals(Type.INT, sut.descriptor.type);
  }

  @Test
  void floatLiteral() throws IOException {

    var input = "40.0\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstExprValue) new Builder().visit(tree);

    assertEquals("40.0", sut.value);
    assertEquals(Type.DOUBLE, sut.descriptor.type);
  }

}
