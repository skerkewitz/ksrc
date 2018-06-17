package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.nodes.*;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.exceptions.VmInvalidFuncRedeclaration;

/**
 * Quick and dirty default implementation of the ksrc {@link Vm}
 */
public class DefaultVm implements Vm {

  @Override
  public final Value eval(AstExpr expression, VmExecContext vmExecContext) {

    if (expression == null) {
      throw new IllegalArgumentException("expression can not be null");
    }

    if (expression instanceof AstExprValue) {
      final AstExprValue exprValue = (AstExprValue) expression;
      switch (exprValue.type) {
        case STRING: return new VmValueString(exprValue.value);
        case NUMBER: return new VmValueNumber(VmUtils.convertStringToNumber(exprValue.value));
        default: return VmValueVoid.shared;
      }
    }
    else if (expression instanceof AstExprMul) {
      final AstExprMul exprMul = (AstExprMul) expression;
      Double lhs = eval(exprMul.lhs, vmExecContext).num();
      Double rhs = eval(exprMul.rhs, vmExecContext).num();
      return new VmValueNumber(lhs * rhs);
    }
    else if (expression instanceof AstExprSub) {
      final AstExprSub exprSub = (AstExprSub) expression;
      Double lhs = eval(exprSub.lhs, vmExecContext).num();
      Double rhs = eval(exprSub.rhs, vmExecContext).num();
      return new VmValueNumber(lhs - rhs);
    }
    else if (expression instanceof AstExprAdd) {
      final AstExprAdd exprSub = (AstExprAdd) expression;
      Double lhs = eval(exprSub.lhs, vmExecContext).num();
      Double rhs = eval(exprSub.rhs, vmExecContext).num();
      return new VmValueNumber(lhs + rhs);
    }
    else if (expression instanceof AstExprEqual) {
      final AstExprEqual exprSub = (AstExprEqual) expression;
      Value lhs = eval(exprSub.lhs, vmExecContext);
      Value rhs = eval(exprSub.rhs, vmExecContext);
      return lhs.eq(rhs) ? new VmValueNumber(1.0) : new VmValueNumber(0.0);
    }
    else if (expression instanceof AstExprIdent) {
      final AstExprIdent exprIdent = (AstExprIdent) expression;
      return vmExecContext.getSymbolByName(exprIdent.ident);
    }
    else if (expression instanceof AstExprFuncCall) {
      final AstExprFuncCall exprFuncCall = (AstExprFuncCall) expression;
      var stmts = vmExecContext.getFuncByName(exprFuncCall.fnName);
      if (stmts != null) {
        if (stmts instanceof FunctionRef) {
          var vmFuncRef = (FunctionRef) stmts;

          /* Create a new VmExeContext for the function call. And resolve parameter. */
          var localVmExecContext = new VmDefaultExecContext(vmExecContext);
          int i = 0;
          for (var pIdent : vmFuncRef.funcRef.paramIdents) {
            localVmExecContext.declareSymbol(pIdent.ident, eval(exprFuncCall.args[i], vmExecContext));
            i += 1;
          }

          return exec(vmFuncRef.funcRef.body, localVmExecContext);
        }

        var vmFuncBuildIn = (FunctionBuildIn) stmts;
        return vmFuncBuildIn.exec(this, exprFuncCall.args, vmExecContext);
      }

      throw new UnknownFunctionReference(exprFuncCall);
    }

    throw new UnknownExpression(expression);
  }

  @Override
  public Value exec(AstStmt statement, VmExecContext vmExecContext) {

    if (statement == null) {
      throw new IllegalArgumentException("statement can not be null");
    }

    if (statement instanceof AstExpr) {
      AstExpr expr = (AstExpr) statement;
      return eval(expr, vmExecContext);
    }
    else if (statement instanceof AstStmtList) {
      AstStmtList stmtList = (AstStmtList) statement;
      Vm.Value result = VmValueVoid.shared;
      for (AstStmt stmt : stmtList.statements) {
        if (stmt == null) {
          continue;
        }

        result = exec(stmt, vmExecContext);
        if (vmExecContext.shouldLeaveFrame()) {
          return result;
        }
      }
      return result;
    }
    else if (statement instanceof AstStmtReturn) {
      AstStmtReturn stmtReturn = (AstStmtReturn) statement;
      Value value = eval(stmtReturn.expr, vmExecContext);
      vmExecContext.markLeaveFrame();
      return value;
    }
    else if (statement instanceof AstStmtDeclLet) {
      final var astStmtDeclLet = (AstStmtDeclLet) statement;
      var value = eval(astStmtDeclLet.value, vmExecContext);
      vmExecContext.declareSymbol(astStmtDeclLet.name.ident, value);
      return value;
    }
    else if (statement instanceof AstStmtDeclFunc) {
      final var stmtDeclFunc = (AstStmtDeclFunc) statement;
      final var funcIdent = stmtDeclFunc.name.ident;
      try {
        vmExecContext.declareFunc(funcIdent, new FunctionRef(stmtDeclFunc));
      } catch (VmDefaultExecContext.VmSymbolAlreadyDeclared e) {
        throw new VmInvalidFuncRedeclaration(funcIdent, stmtDeclFunc.srcLocation);
      }
      return VmValueVoid.shared;
    }
    else if (statement instanceof AstStmtDeclIf) {
      final var stmtDeclIf = (AstStmtDeclIf) statement;
      var value = eval(stmtDeclIf.condition, vmExecContext);
      if (value.num() != 0) {
        return exec(stmtDeclIf.statement, vmExecContext);
      }

      return VmValueVoid.shared;
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
    private final AstStmt statement;

    public UnknownStatement(AstStmt statement) {
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
