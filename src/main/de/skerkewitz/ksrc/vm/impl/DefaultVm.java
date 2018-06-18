package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.*;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprValue;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprAdd;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprEqual;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprMul;
import de.skerkewitz.ksrc.ast.nodes.expr.binop.AstExprSub;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementIf;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatementReturn;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationLet;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.exceptions.VmInvalidFuncRedeclaration;

import java.util.Arrays;
import java.util.List;

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
    else if (expression instanceof AstExprFunctionCall) {
      final AstExprFunctionCall exprFuncCall = (AstExprFunctionCall) expression;

      var types = Arrays.stream(exprFuncCall.args)
              .map((AstExpr astExpr) -> Sema.getResultType(astExpr, vmExecContext))
              .toArray(Type[]::new);

      FunctionSignature functionSignature = new FunctionSignature(Type.VOID, types);
      var stmts = vmExecContext.getFuncByName(exprFuncCall.fnName,functionSignature);
      if (stmts != null) {
        if (stmts instanceof FunctionRef) {
          var vmFuncRef = (FunctionRef) stmts;

          /* Create a new VmExeContext for the function call. And resolve parameter. */
          var localVmExecContext = new VmDefaultExecContext(vmExecContext);
          int i = 0;
          for (var pIdent : vmFuncRef.funcRef.parameter) {
            localVmExecContext.declareSymbol(pIdent.name.ident, eval(exprFuncCall.args[i], vmExecContext));
            i += 1;
          }

          return exec(vmFuncRef.funcRef.body, localVmExecContext);
        }

        var vmFuncBuildIn = (FunctionBuildInRef) stmts;
        return vmFuncBuildIn.funcRef.exec(this, exprFuncCall.args, vmExecContext);
      }

      throw new UnknownFunctionReference(exprFuncCall);
    }

    throw new UnknownExpression(expression);
  }

  @Override
  public Value exec(AstStatement statement, VmExecContext vmExecContext) {

    if (statement == null) {
      throw new IllegalArgumentException("statement can not be null");
    }

    if (statement instanceof AstExpr) {
      AstExpr expr = (AstExpr) statement;
      return eval(expr, vmExecContext);
    }
    else if (statement instanceof AstStatements) {
      AstStatements stmtList = (AstStatements) statement;
      Vm.Value result = VmValueVoid.shared;
      for (AstStatement stmt : stmtList.statements) {
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
    else if (statement instanceof AstStatementReturn) {
      AstStatementReturn stmtReturn = (AstStatementReturn) statement;
      Value value = eval(stmtReturn.expr, vmExecContext);
      vmExecContext.markLeaveFrame();
      return value;
    }
    else if (statement instanceof AstDeclarationLet) {
      final var astStmtDeclLet = (AstDeclarationLet) statement;
      var value = eval(astStmtDeclLet.value, vmExecContext);
      vmExecContext.declareSymbol(astStmtDeclLet.name.ident, value);
      return value;
    }
    else if (statement instanceof AstDeclarationFunction) {
      final var stmtDeclFunc = (AstDeclarationFunction) statement;
      final var funcIdent = stmtDeclFunc.name.ident;
      try {
        var params = stmtDeclFunc.parameter.stream().map(o -> o.typename.type()).toArray(Type[]::new);
        FunctionSignature functionSignature = new FunctionSignature(Type.VOID, params);
        vmExecContext.declareFunc(new FunctionRef(funcIdent, stmtDeclFunc, functionSignature));
      } catch (VmDefaultExecContext.VmSymbolAlreadyDeclared e) {
        throw new VmInvalidFuncRedeclaration(funcIdent, stmtDeclFunc.srcLocation);
      }
      return VmValueVoid.shared;
    }
    else if (statement instanceof AstStatementIf) {
      final var stmtDeclIf = (AstStatementIf) statement;
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
    private final AstExprFunctionCall expressionFuncCall;

    public UnknownFunctionReference(AstExprFunctionCall expressionFuncCall) {
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
