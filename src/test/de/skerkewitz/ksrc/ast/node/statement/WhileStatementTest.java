package de.skerkewitz.ksrc.ast.node.statement;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementWhile;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhileStatementTest {

  @Test
  void whileStatement() throws IOException {

    var input = "while 5 == 5 {\n"
            + " print(\"Hello world\")\n"
            + " print(somevalue * 2)\n"
            + "}\n";

    ParseTree tree = parserFromString(input).while_statement();
    var sut = (AstStatementWhile) new Builder().visit(tree);

    //assertEquals("myPrint", sut.condition.type == Type.BOOL);
    assertEquals(2, sut.body.statements.size());
  }

}
