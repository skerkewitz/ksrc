package de.skerkewitz.ksrc.parse.ast.nodes.expr;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public abstract class AstExpr extends AstStatement {

  /** The descriptor descriptor of the result of this astNode. */
  public VmDescriptor descriptor;

  public AstExpr(SourceLocation srcLocation, VmDescriptor descriptor) {
    super(srcLocation);
    this.descriptor = descriptor;
  }
}
