package de.skerkewitz.ksrc.ast;

public class AstExpressionFuncCall extends AstExpression {

	public final String fnName;
	public final AstExpression[] args;

	public AstExpressionFuncCall(String fnName, AstExpression[] args) {
		this.fnName = fnName;
		this.args = args;
	}
}
