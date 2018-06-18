package de.skerkewitz.ksrc.antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class KsrcParserUtil {

  private KsrcParserUtil() {
  }

  public static final KSrcParser parserForString(String s) throws IOException {
    InputStream in = new ByteArrayInputStream(s.getBytes());
    KSrcLexer lexer = new KSrcLexer(CharStreams.fromStream(in));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    return new KSrcParser(tokens);
  }
}
