package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationNamedValue;
import de.skerkewitz.ksrc.vm.VmFieldInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SemaFieldScanner {

  public final List<VmFieldInfo> fieldInfos = new ArrayList<VmFieldInfo>();


  private void scanInternal(AstNode statement) {
    if (statement instanceof AstDeclarationFunction) {
      VmFieldInfo e = scanSingleField((AstDeclarationNamedValue) statement);
      fieldInfos.add(e);
    }

    for (var child : statement.getChildren()) {
      this.scanInternal(child);
    }

  }

  public static VmFieldInfo scanSingleField(AstDeclarationNamedValue functionDeclaration) {
    final var className = functionDeclaration.name;

//    List<VmDescriptor> paramList = functionDeclaration.n
//            signature.params.stream().map(parameter -> parameter.type.descriptor).collect(Collectors.toList());
//    VmDescriptor returnDescriptor = functionDeclaration.signature.returnType.descriptor;
//
//    VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(returnDescriptor, paramList);
    return new VmFieldInfo(className.ident, null);
  }

  public static List<VmFieldInfo> scan(AstNode statement) {
    SemaFieldScanner classScanner = new SemaFieldScanner();
    classScanner.scanInternal(statement);
    return classScanner.fieldInfos;
  }
}
