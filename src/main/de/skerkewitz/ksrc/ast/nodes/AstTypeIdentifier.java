package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;

/**
 * A descriptor identifier refers to a named descriptor.
 *
 * Most of the time, a descriptor identifier directly refers to a named descriptor with the same name as the identifier. For
 * example, <code>int</code> is a descriptor identifier that directly refers to the named descriptor Int, and the descriptor
 * identifier <code>dictionary<string, int></code> directly refers to the named descriptor Dictionary<String, Int>.
 **/
public class AstTypeIdentifier extends AstNode {

  public final String name;

  public AstTypeIdentifier(SourceLocation sourceLocation, String name) {
    super(sourceLocation);
    this.name = name;
  }

  public Type type() {
    return Type.valueOfIgnoreCare(name);
  }
}
