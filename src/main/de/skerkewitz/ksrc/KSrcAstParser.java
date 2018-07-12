package de.skerkewitz.ksrc;

import de.skerkewitz.ksrc.antlr.KSrcLexer;
import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
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
