package de.skerkewitz.ksrc.parse.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.common.SourceLocation;
import de.skerkewitz.ksrc.parse.ast.nodes.AstTypeIdentifier;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

/** Names value is either a var or a let declaration. */
public class AstDeclarationNamedValue extends AstDeclarationStatement {

  public final boolean constantValue;
  public final AstExprIdent name;
  public final AstTypeIdentifier typeIdentifier;
  public final AstExpr initializer;
  public VmDescriptor descriptor;

  public AstDeclarationNamedValue(SourceLocation srcLoc, boolean constantValue, AstExprIdent name, AstTypeIdentifier typeIdentifier, AstExpr initializer) {
    super(srcLoc);
    this.constantValue = constantValue;
    this.name = name;
    this.typeIdentifier = typeIdentifier;
    this.initializer = initializer;
  }


}
