package de.skerkewitz.ksrc.ast.nodes.statement.declaration;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.AstTypeIdentifier;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class AstDeclarationVar extends AstDeclarationStatement {

  public final AstExprIdent name;
  public final AstTypeIdentifier typeIdentifier;
  public final AstExpr initializer;
  public VmDescriptor descriptor;

  public AstDeclarationVar(SourceLocation srcLoc, AstExprIdent name, AstTypeIdentifier typeIdentifier, AstExpr initializer) {
    super(srcLoc);
    this.name = name;
    this.typeIdentifier = typeIdentifier;
    this.initializer = initializer;
  }


}
