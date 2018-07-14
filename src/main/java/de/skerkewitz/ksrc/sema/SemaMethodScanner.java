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

  public static VmMethodInfo scanSingleMethod(AstDeclarationFunction functionDeclaration) {
    final var className = functionDeclaration.name.ident;

    List<VmDescriptor> paramList = functionDeclaration.signature.params.stream().map(parameter -> parameter.type.descriptor).collect(Collectors.toList());
    VmDescriptor returnDescriptor = functionDeclaration.signature.returnType.descriptor;

    VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(returnDescriptor, paramList);
    return new VmMethodInfo(className, methodDescriptor, functionDeclaration);
  }

  public static List<VmMethodInfo> scan(AstNode statement) {
    SemaMethodScanner semaMethodScanner = new SemaMethodScanner();
    semaMethodScanner.scanInternal(statement);
    return semaMethodScanner.methodInfos;
  }
}
