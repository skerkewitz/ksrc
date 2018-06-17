package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.*;
import de.skerkewitz.ksrc.vm.Interpreter;
import de.skerkewitz.ksrc.vm.exceptions.VmInvalidFuncRedeclaration;
import de.skerkewitz.ksrc.vm.VmSymbolAlreadyDeclared;

/**
 * Quick and dirty default implementation of the ksrc {@link de.skerkewitz.ksrc.vm.Interpreter}
 */
public class DefaultVm implements Interpreter {


  @Override
  public final String eval(AstExpr expression, VmExecContext vmExecContext) {

    if (expression == null) {
      throw new IllegalArgumentException("expression can not be null");
    }

    if (expression instanceof AstExprValue) {
      return ((AstExprValue) expression).value;
    } else if (expression instanceof AstExprMul) {
      final AstExprMul expr = (AstExprMul) expression;
      int l = Integer.parseInt(eval(expr.lhs, vmExecContext));
      int r = Integer.parseInt(eval(expr.rhs, vmExecContext));
      return "" + (l * r);
    } else if (expression instanceof AstExprSub) {
      final AstExprSub expr = (AstExprSub) expression;
      return "" + (Integer.parseInt(eval(expr.lhs, vmExecContext)) - Integer.parseInt(eval(expr.rhs, vmExecContext)));
    } else if (expression instanceof AstExprIdent) {
      final AstExprIdent expr = (AstExprIdent) expression;
      String value = vmExecContext.getSymbolByName(expr.ident);
      return value != null ? "" + value : "0";
    } else if (expression instanceof AstExprFuncCall) {
      final AstExprFuncCall expr = (AstExprFuncCall) expression;
      var stmts = vmExecContext.getFuncByName(expr.fnName);
      if (stmts != null) {
        if (stmts instanceof VmFuncRef) {
          var vmFuncRef = (VmFuncRef) stmts;

          /* Create a new VmExeContext for the function call. And resolve parameter. */
          var localVmExecContext = new VmExecContext(vmExecContext);
          int i = 0;
          for (var pIdent : vmFuncRef.funcRef.paramIdents) {
            localVmExecContext.declareSymbol(pIdent.ident, eval(expr.args[i], vmExecContext));
            i += 1;
          }

          return exec(vmFuncRef.funcRef.body, localVmExecContext);
        }

        var vmFuncBuildIn = (VmFuncBuildIn) stmts;
        return "" + vmFuncBuildIn.exec(this, expr.args, vmExecContext);
      }

      throw new UnknownFunctionReference(expr);
    }

    throw new UnknownExpression(expression);
  }

  @Override
  public String exec(AstStatement statement, VmExecContext vmExecContext) {

    if (statement == null) {
      throw new IllegalArgumentException("statement can not be null");
    }

    if (statement instanceof AstExpr) {
      return eval((AstExpr) statement, vmExecContext);
    } else if (statement instanceof AstStatements) {
      AstStatements statements = (AstStatements) statement;
      String result = "";
      for (AstStatement s : statements.statements) {
        if (s == null) {
          continue;
        }

        result = exec(s, vmExecContext);
      }

      return result;
    } else if (statement instanceof AstStatementDeclLet) {
      final var stmt = (AstStatementDeclLet) statement;
      String value = eval(stmt.value, vmExecContext);
      vmExecContext.declareSymbol(stmt.name.ident, value);
      return value;
    } else if (statement instanceof AstStatementDeclFunc) {
      final var stmt = (AstStatementDeclFunc) statement;
      final var functionName = stmt.name.ident;
      try {
        vmExecContext.declareFunc(functionName, new VmFuncRef(stmt));
      } catch (VmSymbolAlreadyDeclared e) {
        throw new VmInvalidFuncRedeclaration(functionName, stmt.srcLocation);
      }
      return "";
    }

    throw new UnknownStatement(statement);
  }

  private class UnknownExpression extends RuntimeException {
    public final AstExpr expression;

    public UnknownExpression(AstExpr expression) {
      this.expression = expression;
    }

    @Override
    public String toString() {
      return "UnknownExpression{" +
              "expression=" + expression +
              '}';
    }
  }

  private class UnknownStatement extends RuntimeException {
    private final AstStatement statement;

    public UnknownStatement(AstStatement statement) {
      this.statement = statement;
    }

    @Override
    public String toString() {
      return "UnknownStatement{" +
              "statement=" + statement +
              '}';
    }
  }

  private class UnknownFunctionReference extends RuntimeException {
    private final AstExprFuncCall expressionFuncCall;

    public UnknownFunctionReference(AstExprFuncCall expressionFuncCall) {
      this.expressionFuncCall = expressionFuncCall;
    }

    @Override
    public String toString() {
      return "Unknown function reference '" + expressionFuncCall.fnName + "' {" +
              "expressionFuncCall=" + expressionFuncCall +
              '}';
    }
  }

}
