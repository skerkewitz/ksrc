package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SemaMethodScanner {

  public final List<VmMethodInfo> methodInfos = new ArrayList<VmMethodInfo>();


  private void scanInternal(AstNode statement) {
    if (statement instanceof AstDeclarationFunction) {
      VmMethodInfo e = scanSingleMethod((AstDeclarationFunction) statement);
      methodInfos.add(e);
    }

    for (var child : statement.getChildren()) {
      this.scanInternal(child);
    }

  }

  public static VmMethodInfo scanSingleMethod(AstDeclarationFunction statement) {
    final var stmtDeclClass = statement;
    final var className = stmtDeclClass.name.ident;

    List<VmDescriptor> paramList = stmtDeclClass.signature.params.stream().map(parameter -> new VmDescriptor(parameter.typename.type(), null)).collect(Collectors.toList());
    VmDescriptor returnDescriptor = new VmDescriptor(stmtDeclClass.signature.returnType.type(), null);

    VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(returnDescriptor, paramList);
    return new VmMethodInfo(className, methodDescriptor);
  }

  public static List<VmMethodInfo> scan(AstNode statement) {
    SemaMethodScanner classScanner = new SemaMethodScanner();
    classScanner.scanInternal(statement);
    return classScanner.methodInfos;
  }
}
