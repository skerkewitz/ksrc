package de.skerkewitz.ksrc.ast.node.statement.declaration;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementWhile;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserForString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeclarationVariableTest {

  @Test
  void noTypeNoInitializer() throws IOException {

    var input = "var a \n";

    ParseTree tree = parserForString(input).declaration();
    var sut = (AstDeclarationVariable) new Builder().visit(tree);

    //assertEquals("myPrint", sut.condition.type == Type.BOOL);
    assertEquals("a", sut.name.ident);
    assertNull(sut.typeIdentifier);
    assertNull(sut.initialValue);
  }

  @Test
  void noTypeWithInitializer() throws IOException {

    var input = "var a = 5\n";

    ParseTree tree = parserForString(input).declaration();
    var sut = (AstDeclarationVariable) new Builder().visit(tree);

    assertEquals("a", sut.name.ident);
    assertNull(sut.typeIdentifier);
    assertNotNull(sut.initialValue);
  }

  @Test
  void withTypeWithInitializer() throws IOException {

    var input = "var a: number = 5\n";

    ParseTree tree = parserForString(input).declaration();
    var sut = (AstDeclarationVariable) new Builder().visit(tree);

    assertEquals("a", sut.name.ident);
    assertEquals(Type.NUMBER, sut.typeIdentifier.type());
    assertNotNull(sut.initialValue);
  }

}
