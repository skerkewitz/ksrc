package de.skerkewitz.ksrc.interpreter;

import de.skerkewitz.ksrc.ast.*;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {

	interface BuildInFunc {
		String exec(Interpreter vm, AstExpression[] args);
	}

	private final static BuildInFunc print_f = (vm, args) -> {
		String eval = vm.eval(args[0]);
		System.out.println(eval);
		return eval;
	};

	public final Map<String, String> vars = new HashMap<>();
	public final Map<String, String> funcs = new HashMap<>();
	public final Map<String, BuildInFunc> build_in_funcs = new HashMap<>();

	public Interpreter() {
		build_in_funcs.put("print", print_f);
	}

	public final String eval(AstExpression expression) {

		if (expression == null) {
			throw new IllegalArgumentException("expression can not be null");
		}

		if (expression instanceof AstExpressionValue) {
			return ((AstExpressionValue)expression).value;
		} else if (expression instanceof AstExpressionMul) {
			final AstExpressionMul expr = (AstExpressionMul)expression;
			int l = Integer.parseInt(eval(expr.lhs));
			int r = Integer.parseInt(eval(expr.rhs));
			return "" + (l * r);
		} else if (expression instanceof AstExpressionSub) {
			final AstExpressionSub expr = (AstExpressionSub)expression;
			return "" + (Integer.parseInt(eval(expr.lhs)) - Integer.parseInt(eval(expr.rhs)));
		} else if (expression instanceof AstExpressionIdent) {
			final AstExpressionIdent expr = (AstExpressionIdent)expression;
			String value = vars.get(expr.ident);
			return value != null ? "" + value : "0";
		} else if (expression instanceof AstExpressionFuncCall) {
			final AstExpressionFuncCall expr = (AstExpressionFuncCall)expression;
			String value = funcs.get(expr.fnName);
			if (value != null) {
				return "" + value;
			}

			BuildInFunc buildInFunc = build_in_funcs.get(expr.fnName);
			if (buildInFunc != null) {
				return "" + buildInFunc.exec(this, expr.args);
			}

			throw new UnknownFunctionReference(expr);
		}

		throw new UnknownExpression(expression);
	}

	public String exec(AstStatement statement) {

		if (statement == null) {
			throw new IllegalArgumentException("statement can not be null");
		}

		if (statement instanceof AstExpression) {
			return eval((AstExpression) statement);
		} else if (statement instanceof AstStatements) {
			AstStatements statements = (AstStatements) statement;
			String result = "";
			for (AstStatement s : statements.statements) {
				if (s == null) {
					continue;
				}

				result = exec(s);
			}

			return result;
		} else if (statement instanceof AstStatementDeclLet) {
			final AstStatementDeclLet stmt = (AstStatementDeclLet)statement;
			String value = eval(stmt.value);
			vars.put(stmt.name.ident, value);
			return value;
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
