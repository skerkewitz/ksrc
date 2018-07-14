package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class SemaAssert {

  /** Throw a SemaException if the descriptor of the expression does not match the given descriptor. */
  public static void expectExpressionDescriptor(AstExpr expression, VmDescriptor descriptor) {
    if (expression.descriptor != descriptor) {
      throw new Sema.SemaException(expression, "Expected descriptor of expression " + expression + " to be " + descriptor + " but found " + expression.descriptor);
    }
  }
}
