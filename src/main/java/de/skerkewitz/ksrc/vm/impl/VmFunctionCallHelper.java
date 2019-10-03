package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.parse.ast.Type;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprExplicitMemberAccess;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.parse.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.sema.SemaUtils;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VmFunctionCallHelper {

  public static Vm.Value exec(AstExprFunctionCall exprFuncCall, Vm vm, VmExecContext vmExecContext) {

    if (exprFuncCall.fnName instanceof AstExprIdent) {
      return execFunctionCall(exprFuncCall, vm, vmExecContext);
    }
    else if (exprFuncCall.fnName instanceof AstExprExplicitMemberAccess) {
      return execMethodCall(exprFuncCall, vm, vmExecContext);
    }

    /* I don't know how to call this function. */
    throw new UnknownFunctionCallType(exprFuncCall);
  }

  private static Vm.Value execFunctionCall(AstExprFunctionCall exprFunctionCall, Vm vm, VmExecContext vmExecContext) {

    final String functionName = ((AstExprIdent) exprFunctionCall.fnName).ident;
    final List<VmDescriptor> parameterDescriptors = exprFunctionCall.arguments.list.stream()
            .peek(expr -> { if (expr.descriptor == null) throw new VmRuntimeException("Parameter descriptor is null", expr.srcLocation); })
            .map(expr -> expr.descriptor)
            .collect(Collectors.toList());

    /* Check for constructor call first. */
    final VmClassInfo classInfo = vm.getSema().findClassInfoWithName(functionName);
    if (classInfo != null) {

      /* Do we have a suitable constructor in this class? */
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(VmDescriptor.Void, parameterDescriptors);
      Optional<VmMethodInfo> matches = classInfo.findMatchesByFunctionNameAndMethodDescriptor("init", methodDescriptor);
      if (matches.isPresent()) {
        /* This is a constructor call. */
        AstDeclarationFunction astDeclarationFunction = matches.get().functionDeclaration;

        /* Create instance 'self' */
        VmValueRef vmValueRef_Self = new VmValueRef(new VmClassInstance(classInfo), classInfo.fqThisClassName);
        callResolvedFunction(exprFunctionCall, astDeclarationFunction, vm, vmExecContext);

        /* Constructor always returns void, but this is basically a new call so return self. */
        return vmValueRef_Self;
      }
    }

    /* If we have a valid return descriptor then we can lookup the function directly, else we need to check for
     * possible matches. */
    List<Vm.Function> matches;
    if (exprFunctionCall.descriptor == null) {
      matches = vm.getSema().findFunctionsByNameAndParameters(functionName, parameterDescriptors);
    }
    else {
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(exprFunctionCall.descriptor, parameterDescriptors);
      matches = vm.getSema().getFunctionByName(functionName, methodDescriptor);

    }

    final Vm.Function function = SemaUtils.expectExactlyOneFunctionMatch(matches, functionName, parameterDescriptors);

    if (function.buildIn == null) {
      AstDeclarationFunction astDeclarationFunction = function.methodInfo.functionDeclaration;
      return callResolvedFunction(exprFunctionCall, astDeclarationFunction, vm, vmExecContext);
    }

    /* Call native function and make sure the return value is correct. */
    Vm.Value value = function.buildIn.exec(vm, exprFunctionCall.arguments.list, vmExecContext);
    VmDescriptor actualDescriptor = value.descriptor();
    if (exprFunctionCall.descriptor == null || actualDescriptor.equals(exprFunctionCall.descriptor)) {
      return value;
    }

    throw new VmRuntimeException("Require return type of native function '" + functionName + "' of type '" + exprFunctionCall.descriptor + "' but found '" + actualDescriptor + "'", null);
  }

  /**
   * Calls a fully resolved function.
   *
   * @param exprFunctionCall the AST function call.
   * @param astDeclarationFunction the AST of the declared function.
   * @param vm the virtual machine to call this method in.
   * @param vmExecContext the execution context.
   * @return the returned value of the function.
   */
  private static Vm.Value callResolvedFunction(AstExprFunctionCall exprFunctionCall, AstDeclarationFunction astDeclarationFunction, Vm vm, VmExecContext vmExecContext) {
    /* Create a new VmExeContext for the function call. And resolve parameter. */
    int i = 0;

    var vmStackFrame = new VmStackFrame(astDeclarationFunction.name.ident + " at " + astDeclarationFunction.srcLocation);
    for (var parameter : astDeclarationFunction.signature.params) {
      vmStackFrame.locals.declareSymbol(parameter.name.ident, vm.eval(exprFunctionCall.arguments.list.get(i), vmExecContext), parameter);
      i += 1;
    }

    vmExecContext.pushFrame(vmStackFrame);
    Vm.Value exec = vm.exec(astDeclarationFunction.body, vmExecContext);
    vmExecContext.popFrame();
    return exec;
  }

  private static Vm.Value execMethodCall(AstExprFunctionCall exprFunctionCall, Vm vm, VmExecContext vmExecContext) {

    /* Check for Constructor call first. */
    AstExprExplicitMemberAccess member = (AstExprExplicitMemberAccess) exprFunctionCall.fnName;

    // Lookup the type of the expresssion.
    String functionName = ((AstExprIdent) member.rhs).ident;
    Vm.Value baseType = vm.eval(member.lhs, vmExecContext);

    if (baseType == null) {
      throw new Sema.SemaException(member.lhs, "Could not resolve type for '" + member.lhs + "'");
    }

    if (baseType.descriptor().type != Type.ANY_REF) {
      throw new Sema.SemaException(member.lhs, "lhs of member acccess is not a reference type '" + member.lhs + "'");
    }

    VmClassInfo classInfo = vm.getSema().findClassInfoWithName(baseType.descriptor().fqClassName);
    if (classInfo == null) {
      throw new Sema.SemaException(exprFunctionCall, "Could not find a class definition for class '" + baseType.descriptor().fqClassName);
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

    /* Call the function. */
    VmMethodInfo vmMethodInfo = methodInfos.get(0);
    return callResolvedFunction(exprFunctionCall, vmMethodInfo.functionDeclaration, vm, vmExecContext);
  }

  private static class UnknownFunctionCallType extends Vm.VmException {
    public UnknownFunctionCallType(AstExprFunctionCall exprFuncCall) {
      super(exprFuncCall, "I do not know how to call this function.");
    }
  }
}
