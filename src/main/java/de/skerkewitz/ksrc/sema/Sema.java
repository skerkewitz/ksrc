package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.parse.ast.Type;
import de.skerkewitz.ksrc.parse.ast.nodes.AstNode;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.*;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sema {

  private final List<VmClassInfo> classDeclarations = new ArrayList<>();
  private final List<Vm.Function> functionDeclarations = new ArrayList<>();

  public VmDescriptor resolveType(AstExpr expr, SymbolTable<VmDescriptor> localSymbols) {

    if (expr instanceof AstExprFunctionCall) {
      return resolveTypeForCall((AstExprFunctionCall) expr, localSymbols);
    }

    if (expr instanceof AstExprIdent) {
      return resolveTypeForIdent((AstExprIdent) expr, localSymbols);
    }

    if (expr instanceof AstExprLiteral) {
      if (expr.descriptor == null) {
        throw new SemaException(expr, "Invalid ast tree, literal has no descriptor '" + expr + "'.");
      }
      return expr.descriptor;
    }

    return null;
  }

  // TODO rename method to proper name
  private VmDescriptor resolveTypeForIdent(AstExprIdent expr, SymbolTable<VmDescriptor> localSymbols) {
    // check for local types.
    return localSymbols.getSymbolByName(expr.ident);
  }

  private VmDescriptor resolveTypeForCall(AstExprFunctionCall exprFunctionCall, SymbolTable<VmDescriptor> localSymbols) {

    if (exprFunctionCall.fnName instanceof AstExprIdent) {
      return resolveTypeForFunctionCall(exprFunctionCall);
    }
    else if (exprFunctionCall.fnName instanceof AstExprExplicitMemberAccess) {
      return resolveTypeForMethodCall(exprFunctionCall, localSymbols);
    }

    throw new SemaException(exprFunctionCall, "Invalid function calll syntax");
  }

  private VmDescriptor resolveTypeForMethodCall(AstExprFunctionCall exprFunctionCall, SymbolTable<VmDescriptor> localSymbols) {

    /* Check for Constructor call first. */
    AstExprExplicitMemberAccess member = (AstExprExplicitMemberAccess) exprFunctionCall.fnName;

    // Lookup the type of the expresssion.
    String functionName = ((AstExprIdent) member.rhs).ident;
    VmDescriptor baseType = resolveType(member.lhs, localSymbols);
    if (baseType == null) {
      throw new SemaException(member.lhs, "Could not resolve type for '" + member.lhs + "'");
    }


    VmClassInfo classInfo = findClassInfoWithName(baseType.fqClassName);
    if (classInfo != null) {

      /* Do we have a suitable constructor in this class? */
      List<VmDescriptor> argumentsDescriptor = exprFunctionCall.arguments.list.stream()
              .map(expr -> expr.descriptor)
              .collect(Collectors.toList());
      List<VmMethodInfo> methodInfos = classInfo.findMatchesByFunctionNameWithArgs(functionName, argumentsDescriptor);
      if (methodInfos.isEmpty()) {
        throw new SemaException(exprFunctionCall, "Could not find suitable function");
      }

      if (methodInfos.size() > 1) {
        throw new SemaException(exprFunctionCall, "Ambiguous function call");
      }

      return methodInfos.get(0).descriptor.returnDescriptor;
    }

    throw new SemaException(exprFunctionCall, "Could not find a class definition for class '" + baseType);
  }

  private VmDescriptor resolveTypeForFunctionCall(AstExprFunctionCall exprFunctionCall) {

    /* Check for Constructor call first. */
    AstExprIdent ident = (AstExprIdent) exprFunctionCall.fnName;
    VmClassInfo classInfo = findClassInfoWithName(ident.ident);
    if (classInfo != null) {

      /* Do we have a suitable constructor in this class? */
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(
              new VmDescriptor(Type.VOID),
              exprFunctionCall.arguments.list.stream()
                      .map(expr -> expr.descriptor)
                      .collect(Collectors.toList()));

      Optional<VmMethodInfo> matches = classInfo.findMatchesByFunctionNameAndMethodDescriptor("init", methodDescriptor);
      if (matches.isPresent()) {
        return new VmDescriptor(Type.ANY_REF, ident.ident);
      }
    }

    return null;
  }

  public VmClassInfo findClassInfoWithName(String ident) {
    for (var ci: classDeclarations) {
      if (ci.fqThisClassName.equals(ident)) {
        return ci;
      }
    }

    return null;
  }

  public void addClassDeclaration(VmClassInfo classInfo) {
    this.classDeclarations.add(classInfo);
  }

  public void addClassDeclarations(List<VmClassInfo> classInfos) {
    this.classDeclarations.addAll(classInfos);
  }

  public void addFunctionDeclarations(List<Vm.Function> methodInfos) {
    this.functionDeclarations.addAll(methodInfos);
  }

  public List<Vm.Function> findFunctionsByNameAndParameters(String functionName, List<VmDescriptor> parameterDescriptors) {

    List<Vm.Function> functions = this.functionDeclarations.stream()
            .filter(function -> function.methodInfo.name.equals(functionName))
            .filter(function -> function.methodInfo.descriptor.parameterDescriptor.equals(parameterDescriptors))
            .collect(Collectors.toList());

    return functions;
  }

  public List<Vm.Function> getFunctionByName(String functionName, VmMethodDescriptor methodDescriptor) {

    List<Vm.Function> functions = this.functionDeclarations.stream()
            .filter(function -> function.methodInfo.name.equals(functionName))
            .filter(function -> function.methodInfo.descriptor.equals(methodDescriptor))
            .collect(Collectors.toList());

    return functions;
  }

  public static class SemaException extends RuntimeException {
    private final AstNode astNode;

    public SemaException(AstNode astNode, String message) {
      super(message + " (" + (astNode != null ? astNode.srcLocation : "unknown ast") + ")");
      this.astNode = astNode;
    }
  }

  public List<Vm.Function> getFunctionsDeclarations() {
    return Collections.unmodifiableList(this.functionDeclarations);
  }
}
