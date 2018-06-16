package de.skerkewitz.ksrc.interpreter.impl;

import de.skerkewitz.ksrc.ast.*;
import de.skerkewitz.ksrc.interpreter.Interpreter;

import java.util.HashMap;
import java.util.Map;

/** Quick and dirty default implementation of the ksrc {@link de.skerkewitz.ksrc.interpreter.Interpreter} */
public class DefaultVm implements Interpreter {


	@Override
	public final String eval(AstExpression expression, VmExecContext vmExecContext) {

		if (expression == null) {
			throw new IllegalArgumentException("expression can not be null");
		}

		if (expression instanceof AstExpressionValue) {
			return ((AstExpressionValue)expression).value;
		} else if (expression instanceof AstExpressionMul) {
			final AstExpressionMul expr = (AstExpressionMul)expression;
			int l = Integer.parseInt(eval(expr.lhs, vmExecContext));
			int r = Integer.parseInt(eval(expr.rhs, vmExecContext));
			return "" + (l * r);
		} else if (expression instanceof AstExpressionSub) {
			final AstExpressionSub expr = (AstExpressionSub)expression;
			return "" + (Integer.parseInt(eval(expr.lhs, vmExecContext)) - Integer.parseInt(eval(expr.rhs, vmExecContext)));
		} else if (expression instanceof AstExpressionIdent) {
			final AstExpressionIdent expr = (AstExpressionIdent)expression;
			String value = vmExecContext.getSymbolByName(expr.ident);
			return value != null ? "" + value : "0";
		} else if (expression instanceof AstExpressionFuncCall) {
			final AstExpressionFuncCall expr = (AstExpressionFuncCall)expression;
			var stmts = vmExecContext.getFuncByName(expr.fnName);
			if (stmts != null) {
			  	if (stmts instanceof VmFuncRef) {
			  	  var vmFuncRef = (VmFuncRef)stmts;

			  	  /* Create a new VmExeContext for the function call. And resolve parameter. */
				  var localVmExecContext = new VmExecContext(vmExecContext);
				  int i = 0;
				  for (var pIdent : vmFuncRef.funcRef.paramIdents ) {
				    localVmExecContext.declareSymbol(pIdent.ident, eval(expr.args[i], vmExecContext));
				  }

				  return exec(vmFuncRef.funcRef.body, localVmExecContext);
				}

				var vmFuncBuildIn = (VmFuncBuildIn)stmts;
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

		if (statement instanceof AstExpression) {
			return eval((AstExpression) statement, vmExecContext);
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
			final var stmt = (AstStatementDeclFunc)statement;
		  	vmExecContext.declareFunc(stmt.name.ident, new VmFuncRef(stmt));
			return "";
	}

		throw new UnknownStatement(statement);
	}

	private class UnknownExpression extends RuntimeException {
		public final AstExpression expression;

		public UnknownExpression(AstExpression expression) {
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
		private final AstExpressionFuncCall expressionFuncCall;

		public UnknownFunctionReference(AstExpressionFuncCall expressionFuncCall) {
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
