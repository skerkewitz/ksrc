package de.skerkewitz.ksrc.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/** Used to reference the source location of a thenStatement. */
public class SourceLocation {

  private final Token start;
  private final Token end;

  public SourceLocation(Token start, Token end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    var tokenSource = start.getTokenSource();
    var srcName = tokenSource.getSourceName();
    var srcLine = start.getLine();
    var srcPos = start.getCharPositionInLine();
    var src = start.getText();

    return "[" + srcName + ":" + srcLine + ":" + srcPos + "] at token '" + src + "'";
  }

  public static SourceLocation fromContext(ParserRuleContext context) {
    return new SourceLocation(context.start, context.stop);
  }
}
