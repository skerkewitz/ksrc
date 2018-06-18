package de.skerkewitz.ksrc.ast.node.statement.declaration;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserForString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionDeclaration {

  @Test
  void implicitVoidReturnTypeNoParams() throws IOException {

    var input = "fn myPrint: {\n"
            + " print(\"Hello world\")\n"
            + " print(somevalue * 2)\n"
            + "}\n";

    ParseTree tree = parserForString(input).func_decl();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(0, sut.parameter.size());
    assertEquals(2, sut.body.statements.length);
  }

  @Test
  void implicitVoidReturnTypeWithParams() throws IOException {

    var input = "fn myPrint(somevalue:number, othervalue:number): {\n"
            + " print(somevalue * othervalue)\n"
            + " print(somevalue * 2)\n"
            + "}\n";

    ParseTree tree = parserForString(input).func_decl();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(2, sut.parameter.size());
    assertEquals("somevalue", sut.parameter.get(0).name.ident);
    assertEquals("number", sut.parameter.get(0).typename.name);
    assertEquals("othervalue", sut.parameter.get(1).name.ident);
    assertEquals("number", sut.parameter.get(1).typename.name);
    assertEquals(2, sut.body.statements.length);
  }

  @Test
  void explicitReturnTypeNoParams() throws IOException {

    var input = "fn myPrint: number: {\n"
            + " print(\"Hello world\")\n"
            + "}\n";

    ParseTree tree = parserForString(input).func_decl();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(0, sut.parameter.size());
    Assertions.assertEquals(Type.NUMBER, sut.returnType.type());
    assertEquals(1, sut.body.statements.length);
  }

  @Test
  void explicitReturnTypeWithParams() throws IOException {

    var input = "fn myPrint(somevalue:number, othervalue:number): number: {\n"
            + " return somevalue * othervalue\n"
            + "}\n";


    ParseTree tree = parserForString(input).func_decl();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
    assertEquals(2, sut.parameter.size());
    assertEquals("somevalue", sut.parameter.get(0).name.ident);
    assertEquals("number", sut.parameter.get(0).typename.name);
    assertEquals("othervalue", sut.parameter.get(1).name.ident);
    assertEquals("number", sut.parameter.get(1).typename.name);
    assertEquals(Type.NUMBER, sut.returnType.type());
    assertEquals(1, sut.body.statements.length);
  }
}
