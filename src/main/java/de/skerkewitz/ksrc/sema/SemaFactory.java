package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SemaFactory {
  public static Sema buildSemaFromRootStatement(AstStatement rootStatement) {

    /* Scan all top level classes. Inner classes are not supported yet. */
    final List<VmClassInfo> classInfos = SemaClassScanner.scan(rootStatement);
    for (var classInfo: classInfos) {
      System.out.println("Found class " + classInfo);
    }

    /* Scan all top level functions. Inner functions are not supported yet. */
    final List<VmMethodInfo> methodInfos = SemaMethodScanner.scan(rootStatement);
    for (var methodInfo: methodInfos) {
      System.out.println("Found function " + methodInfo);
    }

    final Sema sema = new Sema();
    sema.addClassDeclarations(classInfos);
    sema.addFunctionDeclarations(VmExecContextFactory.buildInFunctionList());
    sema.addFunctionDeclarations(methodInfos.stream().map(methodInfo -> new Vm.Function(methodInfo, null)).collect(Collectors.toList()));

    SemaInferExpressionTypes.walk(rootStatement, sema, new SymbolTable());

    return sema;
  }
}
