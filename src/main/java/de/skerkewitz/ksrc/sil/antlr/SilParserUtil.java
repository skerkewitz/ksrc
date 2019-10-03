package de.skerkewitz.ksrc.sil.antlr;

import de.skerkewitz.ksrc.parse.antlr.KSrcLexer;
import de.skerkewitz.ksrc.parse.antlr.KSrcParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SilParserUtil {

  private SilParserUtil() {
  }

  public static final SilParser parserFromString(String s) throws IOException {
    return parserFromInputStream(new ByteArrayInputStream(s.getBytes()));
  }

  public static final SilParser parserFromInputStream(InputStream in) throws IOException {
    SilLexer lexer = new SilLexer(CharStreams.fromStream(in));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    return new SilParser(tokens);
  }
}
