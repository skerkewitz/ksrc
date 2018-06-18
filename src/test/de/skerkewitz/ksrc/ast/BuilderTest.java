package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprValue;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

  public static final KSrcParser parserForString(String s) throws IOException {
    InputStream in = new ByteArrayInputStream(s.getBytes());
    KSrcLexer lexer = new KSrcLexer(CharStreams.fromStream(in));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    return new KSrcParser(tokens);
  }


  @Test
  void visitDeclFunc() throws IOException {

	var input = "fn myPrint(somevalue:number, othervalue:number) {\n"
			+ " print(somevalue * othervalue)\n"
			+ " print(somevalue * 2)\n"
			+ "}\n";

    ParseTree tree = parserForString(input).func_decl();
    var sut = (AstDeclarationFunction) new Builder().visit(tree);

    assertEquals("myPrint", sut.name.ident);
	assertEquals(2, sut.parameter.length);
    assertEquals("somevalue", sut.parameter[0].name.ident);
    assertEquals("number", sut.parameter[0].typename.name);
	assertEquals("othervalue", sut.parameter[1].name.ident);
	assertEquals("number", sut.parameter[1].typename.name);

  }

  @Test
  void visitExprCall() throws IOException {

    var input = "myPrint(2, 6)\n";

    ParseTree tree = parserForString(input).expression();
    var sut = (AstExprFunctionCall) new Builder().visit(tree);

    assertEquals("myPrint", sut.fnName);
    assertEquals(2, sut.args.length);
    assertEquals("2", ((AstExprValue)sut.args[0]).value);
    assertEquals("6", ((AstExprValue)sut.args[1]).value);
  }
}