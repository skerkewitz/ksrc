package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationLet;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationVar;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.exceptions.VmInvalidFuncRedeclaration;

import java.util.Arrays;

/**
 * Quick and dirty default implementation of the ksrc {@link Vm}
 */
public class DefaultVm implements Vm {

  private static int stackdepth = 1;

  @Override
  public final Value eval(AstExpr expression, VmExecContext vmExecContext) {

    if (expression == null) {
      throw new IllegalArgumentException("expression can not be null");
    }

    if (expression instanceof AstExprValue) {
      final AstExprValue exprValue = (AstExprValue) expression;
      switch (exprValue.type) {
        case STRING: return new VmValueString(exprValue.value);
        case INT: return new VmValueInt(VmUtils.integerFromString(exprValue.value));
        case DOUBLE: return new VmValueDouble(VmUtils.doubleFromString(exprValue.value));
        default: return VmValueVoid.shared;
      }
    }
    else if (expression instanceof AstExprInfixOp) {
      final AstExprInfixOp infixOp = (AstExprInfixOp) expression;
      Value lhs = eval(infixOp.lhs, vmExecContext);
      Value rhs = eval(infixOp.rhs, vmExecContext);
      switch (infixOp.op) {
        case POW: throw new RuntimeException("Infix operator " + infixOp.op + " no implemented yet");
        case MINUS: {
          switch (lhs.type()) {
            case INT: return new VmValueInt(lhs.int_value() - rhs.int_value());
            case DOUBLE: return new VmValueDouble(lhs.double_value() - rhs.double_value());
            default: throw new RuntimeException("Infix operator " + infixOp.op + " no implemented for type " + lhs.type());
          }
        }
        case MULT: return new VmValueDouble(lhs.double_value() * rhs.double_value());
        case DIV: return new VmValueDouble(lhs.double_value() / rhs.double_value());
        case MOD: {
          switch (lhs.type()) {
            case INT: return new VmValueInt(lhs.int_value() % rhs.int_value());
            default: throw new RuntimeException("Infix operator " + infixOp.op + " no implemented for type " + lhs.type());
          }
        }
        case PLUS: return lhs.add(rhs);
        case LTEQ: return new VmValueDouble(lhs.double_value() <= rhs.double_value() ? 1.0 : 0.0);
        case GTEQ: return new VmValueDouble(lhs.double_value() >= rhs.double_value() ? 1.0 : 0.0);
        case LT: return new VmValueDouble(lhs.double_value() < rhs.double_value() ? 1.0 : 0.0);
        case GT: return new VmValueDouble(lhs.double_value() > rhs.double_value() ? 1.0 : 0.0);
        case EQ: return new VmValueBool(lhs.eq(rhs));
        case IDEQ: throw new RuntimeException("Infix operator " + infixOp + " no implemented yet");
        case NEQ: return new VmValueBool(!lhs.eq(rhs));
        case AND: throw new RuntimeException("Infix operator " + infixOp + " no implemented yet");
        case OR: throw new RuntimeException("Infix operator " + infixOp + " no implemented yet");
      }
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
          DefaultVm.stackdepth += 1;
//          System.out.print("" + DefaultVm.stackdepth + ", ");
          var localVmExecContext = new VmDefaultExecContext(vmExecContext);
          int i = 0;
          for (var pIdent : vmFuncRef.funcRef.signature.params) {
            localVmExecContext.declareSymbol(pIdent.name.ident, eval(exprFuncCall.args[i], vmExecContext));
            i += 1;
          }

          Value exec = exec(vmFuncRef.funcRef.body, localVmExecContext);
          DefaultVm.stackdepth -= 1;
          return exec;
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
      throw new IllegalArgumentException("thenStatement can not be null");
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
      var value = eval(astStmtDeclLet.initializer, vmExecContext);
      vmExecContext.declareSymbol(astStmtDeclLet.name.ident, value);
      return value;
    }
    else if (statement instanceof AstDeclarationVar) {
      final var astDeclarationVar = (AstDeclarationVar) statement;
      Value value;
      if (astDeclarationVar.initializer == null) {
        value = astDeclarationVar.typeIdentifier.type().default_init_value;
      } else {
        value = eval(astDeclarationVar.initializer, vmExecContext);
      }
      vmExecContext.declareSymbol(astDeclarationVar.name.ident, value);
      return value;
    }
    else if (statement instanceof AstDeclarationFunction) {
      final var stmtDeclFunc = (AstDeclarationFunction) statement;
      final var funcIdent = stmtDeclFunc.name.ident;
      try {
        var params = stmtDeclFunc.signature.params.stream().map(o -> o.typename.type()).toArray(Type[]::new);
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
      if (value.bool_value()) {
        return exec(stmtDeclIf.thenStatement, vmExecContext);
      } else if (stmtDeclIf.elseStatement != null) {
        return exec(stmtDeclIf.elseStatement, vmExecContext);
      }

      return VmValueVoid.shared;
    }
    else if (statement instanceof AstStatementWhile) {
      final var statementWhile = (AstStatementWhile) statement;
      var value = eval(statementWhile.condition, vmExecContext);
      while (value.bool_value()) {
        exec(statementWhile.body, vmExecContext);
        value = eval(statementWhile.condition, vmExecContext);
      }

      return VmValueVoid.shared;
    }
    else if (statement instanceof AstStatementAssign) {
      final var assignStatement = (AstStatementAssign) statement;
      var value = eval(assignStatement.expression, vmExecContext);
      vmExecContext.setSymbolToValue(assignStatement.ident.ident, value);
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
              "thenStatement=" + statement +
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
