package de.skerkewitz.ksrc.interpreter;

import de.skerkewitz.ksrc.ast.AstExpression;
import de.skerkewitz.ksrc.ast.AstStatement;

/** A interpreter for the Ast nodes. */
public interface Interpreter {

	/** Allows to implement build in functions. */
	interface BuildInFunc {
		String exec(Interpreter vm, AstExpression[] args);
	}

	/**
	 * Evaluates the given expression and returns the value.
	 * @param expression the {@link AstExpression} to evaluate
	 *
	 * @return the String value of the evaluated expression.
	 */
	String eval(AstExpression expression);


	/**
	 * Execute the given statement.
	 *
	 * @param statement the {@link AstStatement} to execute.
	 * @return
	 */
	String exec(AstStatement statement);

}
