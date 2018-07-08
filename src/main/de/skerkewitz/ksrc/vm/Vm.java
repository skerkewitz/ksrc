package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.AstDeclarationClass;
import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.impl.VmExecContext;

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

  abstract class Function {

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

  class ClassRef {
    public final String className;
    public final AstDeclarationClass stmtDeclClass;

    public ClassRef(String className, AstDeclarationClass stmtDeclClass) {
      this.className = className;
      this.stmtDeclClass = stmtDeclClass;
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
