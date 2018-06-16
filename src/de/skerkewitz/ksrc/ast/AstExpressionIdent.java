package de.skerkewitz.ksrc.ast;

public class AstExpressionIdent extends AstExpression {

	public final String ident;

	public AstExpressionIdent(String ident) {
		this.ident = ident;
	}
}
