package de.skerkewitz.ksrc.parse;

import de.skerkewitz.ksrc.parse.antlr.KSrcLexer;
import de.skerkewitz.ksrc.parse.antlr.KSrcParser;
import de.skerkewitz.ksrc.parse.ast.Builder;
import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class KSrcAstParser {

  private static Builder builder = new Builder();

  private KSrcAstParser() {
    // singleton
  }

  public static AstNode parse(CharStream charStream) {

    final KSrcLexer lexer = new KSrcLexer(charStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KSrcParser parser = new KSrcParser(tokens);
    final ParseTree tree = parser.translation_unit();

////    ParseTreeWalker.DEFAULT.walk(new TestListener(), tree);
//    System.out.println(tree.toStringTree(parser));

    /* Build AST tree. */
    return builder.visit(tree);
  }
}
