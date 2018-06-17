package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprOp extends AstExpr {

	public final AstExpr lhs;
	public final AstExpr rhs;

	public AstExprOp(SourceLocation srcLocation, AstExpr lhs, AstExpr rhs) {
		super(srcLocation);
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
