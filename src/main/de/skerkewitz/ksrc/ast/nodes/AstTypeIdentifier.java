package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;

/**
 * A type identifier refers to a named type.
 *
 * Most of the time, a type identifier directly refers to a named type with the same name as the identifier. For
 * example, <code>int</code> is a type identifier that directly refers to the named type Int, and the type
 * identifier <code>dictionary<string, int></code> directly refers to the named type Dictionary<String, Int>.
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
