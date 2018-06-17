package de.skerkewitz.ksrc.ast;

public class AstStatementDeclFunc extends AstStatement {

	public final AstExpressionIdent name;
	public final AstExpressionIdent[] paramIdents;
	public final AstStatements body;

	public AstStatementDeclFunc(AstExpressionIdent name, AstExpressionIdent[] paramIdents, AstStatements body) {
		this.name = name;
		this.paramIdents = paramIdents;
		this.body = body;
	}
}
