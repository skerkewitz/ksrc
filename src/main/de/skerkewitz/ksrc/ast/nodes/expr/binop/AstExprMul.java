package de.skerkewitz.ksrc.ast.nodes.expr.binop;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;

public class AstExprMul extends AstExprOp {

	public AstExprMul(SourceLocation sourceLocation, AstExpr lhs, AstExpr rhs) {
		super(sourceLocation, lhs, rhs);
	}
}
