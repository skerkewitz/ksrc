package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
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

  class Function {

    /** Plain name of the funtion. */
    public final String name;
    public final FunctionSignature signature;

    public Function(String name, FunctionSignature signature) {
      this.name = name;
      this.signature = signature;
    }

    public String getMangledName() {
      return null; //
    }
  }

  /**
   * Allows to implement build in functions.
   */
  interface FunctionBuildIn {
    Value exec(Vm vm, AstExpr[] args, VmExecContext execContext);
  }

  /**
   * Allows to implement build in functions.
   */
  class FunctionBuildInRef extends Function {
    public final FunctionBuildIn funcRef;

    public FunctionBuildInRef(String name, FunctionBuildIn funcRef, FunctionSignature signature) {
      super(name, signature);
      this.funcRef = funcRef;
    }
  }

  /**
   * Allows to implement build in functions.
   */
  class FunctionRef extends Function {
    public final AstDeclarationFunction funcRef;

    public FunctionRef(String name, AstDeclarationFunction funcRef, FunctionSignature signature) {
      super(name, signature);
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
   * @param statement the {@link AstStatement} to execute.
   * @return
   */
  Value exec(AstStatement statement, VmExecContext execContext);

}
