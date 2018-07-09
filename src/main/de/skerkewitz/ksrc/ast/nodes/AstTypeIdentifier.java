package de.skerkewitz.ksrc.ast.nodes;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.sema.SymbolTable;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

import java.util.Map;

/**
 * A descriptor identifier refers to a named descriptor.
 *
 * Most of the time, a descriptor identifier directly refers to a named descriptor with the same name as the identifier. For
 * example, <code>int</code> is a descriptor identifier that directly refers to the named descriptor Int, and the descriptor
 * identifier <code>dictionary<string, int></code> directly refers to the named descriptor Dictionary<String, Int>.
 **/
public class AstTypeIdentifier extends AstNode {

  public final String name;
  public final VmDescriptor descriptor;

  private static SymbolTable buildInType = new SymbolTable(
          Map.of(
                  "Void", new VmDescriptor(Type.VOID),
                  "Bool", new VmDescriptor(Type.BOOL),
                  "Double", new VmDescriptor(Type.DOUBLE),
                  "Int", new VmDescriptor(Type.INT),
                  "String", new VmDescriptor(Type.STRING)
          ), null);

  public AstTypeIdentifier(SourceLocation sourceLocation, String name) {
    super(sourceLocation);
    this.name = name;

    VmDescriptor symbolByName = buildInType.getSymbolByName(name);
    this.descriptor = symbolByName == null ? new VmDescriptor(Type.ANY_REF, name) : symbolByName;
  }
}
