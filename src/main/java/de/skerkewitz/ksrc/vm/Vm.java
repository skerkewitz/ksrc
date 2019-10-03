package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.impl.VmExecContext;

import java.util.List;

/**
 * A vm for the Ast nodes.
 */
public interface Vm {

  Sema getSema();

  /** A initializer in the virtual machine. */
  interface Value {

    /** The descriptor of the initializer. */
    VmDescriptor descriptor();

    /** The string representation of the initializer. */
    String string_value();

    /** The number representation of the initializer. */
    Double double_value();

    /** The number representation of the initializer. */
    Integer int_value();

    /** The number representation of the initializer. */
    Boolean bool_value();

    /** Returns true if this initializer equals the other initializer. */
    boolean eq(Value rhs);

    /** Create a new value "this + other" */
    Value add (Value other);

    Object ref_value();
  }

  class Function {

    /** Allows to implement build in functions. */
    public interface BuildIn {
      Value exec(Vm vm, List<AstExpr> args, VmExecContext execContext);
    }

    /** Plain name of the funtion. */
    public final VmMethodInfo methodInfo;
    public final BuildIn buildIn;

    public Function(VmMethodInfo methodInfo, BuildIn buildIn) {
      this.methodInfo = methodInfo;
      this.buildIn = buildIn;
    }
  }

  /**
   * Evaluates the given astNode and returns the initializer.
   *
   * @param expression the {@link AstExpr} to evaluate
   * @return the String initializer of the evaluated astNode.
   */
  Value eval(AstExpr expression, VmExecContext execContext);

  /**
   * Execute the given thenStatement.
   *
   * @param statement the {@link AstStatement} to execute.
   * @return
   */
  Value exec(AstStatement statement, VmExecContext execContext);


  class VmException extends RuntimeException {
    public final AstNode astNode;

    public VmException(AstNode astNode, String message) {
      super(message);
      this.astNode = astNode;
    }
  }

  class UnknownExpression extends VmException {
    public UnknownExpression(AstExpr expression) {
      super(expression, "Unknown expression instruction" + expression);
    }
  }

  class UnknownStatement extends VmException {
    public UnknownStatement(AstStatement statement) {
      super(statement, "Unknown statement instruction " + statement);
    }
  }

  class UnknownFunctionReference extends VmException {
    public UnknownFunctionReference(AstExprFunctionCall expressionFuncCall) {
      super(expressionFuncCall, "Unknown function reference " + expressionFuncCall);
    }
  }
}
