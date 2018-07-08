package de.skerkewitz.ksrc.ast.nodes.expr;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class AstExprValue extends AstExpr {

  public final String value;

  public AstExprValue(SourceLocation srcLocation, String value, VmDescriptor type) {
    super(srcLocation, type);
    this.value = value;
  }

}
