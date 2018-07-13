package de.skerkewitz.ksrc.ast.node.statement;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementIf;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementWhile;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IfStatementTest {

  @Test
  void ifStatement() throws IOException {

    var input = "if 5 == 5:\n"
              + " print(\"Hello world\")\n"
              + " print(\"Hello world\")\n"
              + "else:\n"
              + " print(somevalue * 2)\n"
              + "end\n";


    ParseTree tree = parserFromString(input).if_statement();
    var sut = (AstStatementIf) new Builder().visit(tree);

    //assertEquals("myPrint", sut.condition.descriptor == Type.BOOL);
    assertNotNull(sut.thenStatement);
    assertNotNull(sut.elseStatement);
  }

}
