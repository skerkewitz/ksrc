package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstTypeIdentifier;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;

/**
 * A constant declaration introduces a constant named initializer.
 *
 * A constant declaration defines an immutable binding between the constant name and the initializer of the initializer
 * expression; after the initializer of a constant is set, it cannot be changed.
 *
 * A constance need either a explicit type annotation or a explicit initializer.
 */
public class AstDeclarationLet extends AstStatement {

  public final AstExprIdent name;
  public final AstTypeIdentifier typeIdentifier;
  public final AstExpr initializer;

  public AstDeclarationLet(SourceLocation srcLoc, AstExprIdent name, AstTypeIdentifier typeIdentifier, AstExpr initializer) {
    super(srcLoc);
    this.name = name;
    this.typeIdentifier = typeIdentifier;
    this.initializer = initializer;
  }
}
