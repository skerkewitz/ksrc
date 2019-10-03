package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.parse.ast.Type;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprExplicitMemberAccess;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SemaFunctionCallResolverHelper {

  public static VmMethodInfo resolve(AstExprFunctionCall exprFuncCall, Sema sema, SymbolTable<VmDescriptor> descriptorSymbolTable) {

    if (exprFuncCall.fnName instanceof AstExprIdent) {
      return resolveFunctionCall(exprFuncCall, sema, descriptorSymbolTable);
    }
    else if (exprFuncCall.fnName instanceof AstExprExplicitMemberAccess) {
      return resolveMemberFunctionCall(exprFuncCall, sema, descriptorSymbolTable);
    }

    /* I don't know how to call this function. */
    throw new UnknownFunctionCallType(exprFuncCall);
  }

  private static VmMethodInfo resolveFunctionCall(AstExprFunctionCall exprFunctionCall, Sema sema, SymbolTable<VmDescriptor> descriptorSymbolTable) {

    final String functionName = exprFunctionCall.getFunctionNameIdent().ident;
    final List<VmDescriptor> parameterDescriptors = exprFunctionCall.arguments.list.stream()
            .peek(expr -> { if (expr.descriptor == null) throw new VmRuntimeException("Parameter descriptor is null", expr.srcLocation); })
            .map(expr -> expr.descriptor)
            .collect(Collectors.toList());

    /* Check for constructor call first. */
    final VmClassInfo classInfo = sema.findClassInfoWithName(functionName);
    if (classInfo != null) {

      /* Do we have a suitable constructor in this class? */
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(VmDescriptor.Void, parameterDescriptors);
      Optional<VmMethodInfo> matches = classInfo.findMatchesByFunctionNameAndMethodDescriptor("init", methodDescriptor);
      if (matches.isPresent()) {
        return matches.get();
      }
    }

    /* If we have a valid return descriptor then we can lookup the function directly, else we need to check for
     * possible matches. */
    List<Vm.Function> matches;
    if (exprFunctionCall.descriptor == null) {
      matches = sema.findFunctionsByNameAndParameters(functionName, parameterDescriptors);
    }
    else {
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(exprFunctionCall.descriptor, parameterDescriptors);
      matches = sema.getFunctionByName(functionName, methodDescriptor);

    }

    final Vm.Function function = SemaUtils.expectExactlyOneFunctionMatch(matches, functionName, parameterDescriptors);
    return function.methodInfo;
  }

  private static VmMethodInfo resolveMemberFunctionCall(AstExprFunctionCall exprFunctionCall, Sema sema, SymbolTable<VmDescriptor> descriptorSymbolTable) {

    /* Check for Constructor call first. */
    AstExprExplicitMemberAccess member = (AstExprExplicitMemberAccess) exprFunctionCall.fnName;

    // Lookup the type of the expresssion.
    String functionName = ((AstExprIdent) member.rhs).ident;
    VmDescriptor baseType = sema.resolveType(member.lhs, descriptorSymbolTable);

    if (baseType == null) {
      throw new Sema.SemaException(member.lhs, "Could not resolve type for '" + member.lhs + "'");
    }

    if (baseType.type != Type.ANY_REF) {
      throw new Sema.SemaException(member.lhs, "lhs of member acccess is not a reference type '" + member.lhs + "'");
    }

    VmClassInfo classInfo = sema.findClassInfoWithName(baseType.fqClassName);
    if (classInfo == null) {
      throw new Sema.SemaException(exprFunctionCall, "Could not find a class definition for class '" + baseType.fqClassName);
    }

    /* Do we have a suitable constructor in this class? */
    List<VmDescriptor> argumentsDescriptor = exprFunctionCall.arguments.list.stream()
            .map(expr -> expr.descriptor)
            .collect(Collectors.toList());
    List<VmMethodInfo> methodInfos = classInfo.findMatchesByFunctionNameWithArgs(functionName, argumentsDescriptor);
    if (methodInfos.isEmpty()) {
      throw new Sema.SemaException(exprFunctionCall, "Could not find suitable function");
    }

    if (methodInfos.size() > 1) {
      throw new Sema.SemaException(exprFunctionCall, "Ambiguous function call");
    }

    /* The method to call. */
    return methodInfos.get(0);
  }


  private static class UnknownFunctionCallType extends Sema.SemaException {
    public UnknownFunctionCallType(AstExprFunctionCall exprFuncCall) {
      super(exprFuncCall, "I do not know how to call this function.");
    }
  }
}
