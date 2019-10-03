package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.parse.ast.Builder;
import de.skerkewitz.ksrc.parse.ast.Type;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.parse.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.skerkewitz.ksrc.parse.antlr.KsrcParserUtil.parserFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SemaTest {

  @Test
  void resolveType_ConstructorCall() throws IOException {

    var input = "Circle()\n";

    ParseTree tree = parserFromString(input).statement();
    var astExpr = (AstExpr) new Builder().visit(tree);

    VmClassInfo classInfo = new VmClassInfo("Circle");
    classInfo.methods.add(new VmMethodInfo("init", VmMethodDescriptor.fromString("()V"), mock(AstDeclarationFunction.class)));

    Sema sema = new Sema();
    sema.addClassDeclaration(classInfo);
    VmDescriptor vmDescriptor = sema.resolveType(astExpr, new SymbolTable(null));

    assertNotNull(vmDescriptor);
    assertEquals("Circle", vmDescriptor.fqClassName);
    assertEquals(Type.ANY_REF, vmDescriptor.type);
  }
}