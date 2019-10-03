package de.skerkewitz.ksrc.sil;

import de.skerkewitz.ksrc.sil.antlr.SilLexer;
import de.skerkewitz.ksrc.sil.antlr.SilParser;
import de.skerkewitz.ksrc.sil.ast.Builder;
import de.skerkewitz.ksrc.sil.ast.SilAstNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SilAstParser {

  private static Builder builder = new Builder();

  private SilAstParser() {
    // singleton
  }

  public static SilAstNode parse(CharStream charStream) {

    final SilLexer lexer = new SilLexer(charStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final SilParser parser = new SilParser(tokens);
    final ParseTree tree = parser.translation_unit();

    /* Build AST tree. */
    return builder.visit(tree);
  }
}
