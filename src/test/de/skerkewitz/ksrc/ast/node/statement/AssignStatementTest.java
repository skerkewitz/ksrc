package de.skerkewitz.ksrc.ast.node.statement;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementAssign;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssignStatementTest {

  @Test
  void assignStatement() throws IOException {

    var input = "i = i + 1\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstStatementAssign) new Builder().visit(tree);

    //assertEquals("myPrint", sut.condition.descriptor == Type.BOOL);
    assertEquals("i", ((AstExprIdent)sut.ident).ident);
    assertNotNull(sut.expression);
  }

}
