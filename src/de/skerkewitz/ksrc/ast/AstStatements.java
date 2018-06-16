package de.skerkewitz.ksrc.ast;

public class AstStatements extends AstStatement {

	public final AstStatement[] statements;

	public AstStatements(AstStatement[] statements) {
		this.statements = statements;
	}
}
