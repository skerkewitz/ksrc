package de.skerkewitz.ksrc.ast;

public class AstStatementDeclFunc extends AstStatement {

	public final AstExpressionIdent name;
	public final AstStatements body;

	public AstStatementDeclFunc(AstExpressionIdent name, AstStatements body) {
		this.name = name;
		this.body = body;
	}
}
