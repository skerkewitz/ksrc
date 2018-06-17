package de.skerkewitz.ksrc.ast;

public class AstExpressionOp extends AstExpression {

	public final AstExpression lhs;
	public final AstExpression rhs;

	public AstExpressionOp(AstExpression lhs, AstExpression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
