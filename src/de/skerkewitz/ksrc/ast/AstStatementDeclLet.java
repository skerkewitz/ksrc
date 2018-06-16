package de.skerkewitz.ksrc.ast;

public class AstStatementDeclLet extends AstStatement {

	public final AstExpressionIdent name;
	public final AstExpression value;

	public AstStatementDeclLet(AstExpressionIdent name, AstExpression value) {
		this.name = name;
		this.value = value;
	}
}
