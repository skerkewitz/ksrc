package de.skerkewitz.ksrc.ast.node.statement.declaration;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionDeclarationTest {

  @Test
  void implicitVoidReturnTypeNoParams() throws IOException {

    var input = "fn myPrint: \n"
            + " print(\"Hello world\")\n"
            + " print(somevalue * 2)\n"
            + "end\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(0, sut.signature.params.size());
    assertEquals(2, sut.body.statements.size());
  }

  @Test
  void implicitVoidReturnTypeWithParams() throws IOException {

    var input = "fn myPrint(somevalue:number, othervalue:number):\n"
            + " print(somevalue * othervalue)\n"
            + " print(somevalue * 2)\n"
            + "end\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(2, sut.signature.params.size());
    assertEquals("somevalue", sut.signature.params.get(0).name.ident);
    assertEquals("number", sut.signature.params.get(0).typename.name);
    assertEquals("othervalue", sut.signature.params.get(1).name.ident);
    assertEquals("number", sut.signature.params.get(1).typename.name);
    assertEquals(2, sut.body.statements.size());
  }

  @Test
  void explicitReturnTypeNoParams() throws IOException {

    var input = "fn myPrint -> int:\n"
            + " print(\"Hello world\")\n"
            + "end\n";

    ParseTree tree = parserFromString(input).statement();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(0, sut.signature.params.size());
    Assertions.assertEquals(Type.INT, sut.signature.returnType.descriptor.type);
    assertEquals(1, sut.body.statements.size());
  }

  @Test
  void explicitReturnTypeWithParams() throws IOException {

    var input = "fn myPrint(somevalue:int, othervalue:int) -> int: \n"
            + " return somevalue * othervalue\n"
            + "end\n";


    ParseTree tree = parserFromString(input).statement();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(2, sut.signature.params.size());
    assertEquals("somevalue", sut.signature.params.get(0).name.ident);
    assertEquals("int", sut.signature.params.get(0).typename.name);
    assertEquals("othervalue", sut.signature.params.get(1).name.ident);
    assertEquals("int", sut.signature.params.get(1).typename.name);
    assertEquals(Type.INT, sut.signature.returnType.descriptor.type);
    assertEquals(1, sut.body.statements.size());
  }
}
