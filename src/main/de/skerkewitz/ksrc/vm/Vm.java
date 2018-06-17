package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.nodes.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.AstStmt;
import de.skerkewitz.ksrc.ast.nodes.AstStmtDeclFunc;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.impl.VmExecContext;

/**
 * A vm for the Ast nodes.
 */
public interface Vm {

  /** A value in the virtual machine. */
  interface Value {

    /** The type of the value. */
    Type type();

    /** The string representation of the value. */
    String str();

    /** The number representation of the value. */
    Double num();

    /** Returns true if this value equals the other value. */
    boolean eq(Value rhs);
  }

  interface Function {
  }

  /**
   * Allows to implement build in functions.
   */
  interface FunctionBuildIn extends Function {
    Value exec(Vm vm, AstExpr[] args, VmExecContext execContext);
  }

  /**
   * Allows to implement build in functions.
   */
  class FunctionRef implements Function {
    public final AstStmtDeclFunc funcRef;

    public FunctionRef(AstStmtDeclFunc funcRef) {
      this.funcRef = funcRef;
    }
  }

  /**
   * Evaluates the given expression and returns the value.
   *
   * @param expression the {@link AstExpr} to evaluate
   * @return the String value of the evaluated expression.
   */
  Value eval(AstExpr expression, VmExecContext execContext);


  /**
   * Execute the given statement.
   *
   * @param statement the {@link AstStmt} to execute.
   * @return
   */
  Value exec(AstStmt statement, VmExecContext execContext);

}
