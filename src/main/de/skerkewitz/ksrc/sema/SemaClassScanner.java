package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.AstDeclarationClass;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SemaClassScanner {

  public final List<VmClassInfo> classInfos = new ArrayList<VmClassInfo>();


  private void scanInternal(AstNode statement) {
    if (statement instanceof AstDeclarationClass) {
      final var stmtDeclClass = (AstDeclarationClass) statement;
      final var className = stmtDeclClass.name.ident;

      VmClassInfo classInfo = new VmClassInfo(className);

      List<VmMethodInfo> methodInfos = stmtDeclClass.functions.stream().map(astDeclarationFunction -> SemaMethodScanner.scanSingleMethod(astDeclarationFunction)).collect(Collectors.toList());

      classInfo.methods = methodInfos;

      classInfos.add(classInfo);

//      /* Declare all functions. */
//      for (var f: stmtDeclClass.functions) {
//        exec(f, vmExecContext);
//      }
//
//      try {
//        vmExecContext.declareClass(new Vm.ClassRef(className, stmtDeclClass));
//      } catch (VmDefaultExecContext.VmSymbolAlreadyDeclared e) {
//        throw new VmInvalidFuncRedeclaration(className, stmtDeclClass.srcLocation);
//      }
//      return VmValueVoid.shared;
    }

    for (var child : statement.getChildren()) {
      this.scanInternal(child);
    }

  }

  public static List<VmClassInfo> scan(AstNode statement) {
    SemaClassScanner classScanner = new SemaClassScanner();
    classScanner.scanInternal(statement);
    return classScanner.classInfos;
  }
}
