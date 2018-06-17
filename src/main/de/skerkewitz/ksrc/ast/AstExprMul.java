package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class AstExprMul extends AstExprOp {

	public AstExprMul(SourceLocation sourceLocation, AstExpr lhs, AstExpr rhs) {
		super(sourceLocation, lhs, rhs);
	}
}
