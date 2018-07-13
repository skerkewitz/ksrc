package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public abstract class AstExpr extends AstStatement {

  /** The descriptor descriptor of the result of this astNode. */
  public VmDescriptor descriptor;

  public AstExpr(SourceLocation srcLocation, VmDescriptor descriptor) {
    super(srcLocation);
    this.descriptor = descriptor;
  }
}
