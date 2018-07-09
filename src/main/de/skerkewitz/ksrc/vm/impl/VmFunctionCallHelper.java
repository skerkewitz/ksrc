package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprExplicitMemberAccess;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.sema.Sema;
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
        VmValueRef vmValueRef_Self = new VmValueRef(null, classInfo.fqThisClassName);
        callResolvedFunction(exprFunctionCall, astDeclarationFunction, vm, vmExecContext);

        /* Constructor always returns void, but this is basically a new call so return self. */
        return vmValueRef_Self;
      }
    }

    /* Build descriptor for function */
    VmDescriptor expectedReturnDescriptor = exprFunctionCall.descriptor;

    /* If we have a valid return descriptor then we can lookup the function directly, else we need to check for
     * possible matches. */
    final Vm.Function function;
    if (expectedReturnDescriptor == null) {
      List<Vm.Function> matches = vmExecContext.findFunctionsByNameAndParameters(functionName, parameterDescriptors);
      if (matches.isEmpty()) {
        throw new VmRuntimeException("Can not find suitable function '" + functionName + "' with parameter '" + parameterDescriptors + "'", null);
      }

      if (matches.size() > 1) {
        throw new VmRuntimeException("Ambiguous function call of function '" + functionName + "' with parameter '" + parameterDescriptors + "'. Found possible matches: " + matches, null);
      }

      function = matches.get(0);
    }
    else {
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(expectedReturnDescriptor, parameterDescriptors);
      function = vmExecContext.getFunctionByName(functionName, methodDescriptor);
    }

    if (function.buildIn == null) {
      AstDeclarationFunction astDeclarationFunction = function.methodInfo.functionDeclaration;
      return callResolvedFunction(exprFunctionCall, astDeclarationFunction, vm, vmExecContext);
    }

    /* Call native function and make sure the return value is correct. */
    Vm.Value value = function.buildIn.exec(vm, exprFunctionCall.arguments.list, vmExecContext);
    VmDescriptor actualDescriptor = value.descriptor();
    if (expectedReturnDescriptor == null || actualDescriptor.equals(expectedReturnDescriptor)) {
      return value;
    }

    throw new VmRuntimeException("Require return type of native function '" + functionName + "' of type '" + expectedReturnDescriptor + "' but found '" + actualDescriptor + "'", null);
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
    var localVmExecContext = new VmDefaultExecContext(vmExecContext);

    for (var pIdent : astDeclarationFunction.signature.params) {
      localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFunctionCall.arguments.list.get(i), vmExecContext));
      i += 1;
    }

    return vm.exec(astDeclarationFunction.body, localVmExecContext);
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

    /* The method to call. */
    VmMethodInfo vmMethodInfo = methodInfos.get(0);

    /* Create a new VmExeContext for the function call. And resolve parameter. */
    var localVmExecContext = new VmDefaultExecContext(vmExecContext);
    int i = 0;
    for (var pIdent : vmMethodInfo.functionDeclaration.signature.params) {
      localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFunctionCall.arguments.list.get(i), vmExecContext));
      i += 1;
    }

    /* Call the function. */
    return vm.exec(vmMethodInfo.functionDeclaration.body, localVmExecContext);
  }

    //
//      var types = Arrays.stream(exprFuncCall.arguments)
//              .map((AstExpr astExpr) -> Sema.getResultType(astExpr, vmExecContext))
//              .toArray(Type[]::new);
//
//      FunctionSignature functionSignature = new FunctionSignature(Type.VOID, types);
//
//      final String fnName;
//      if (exprFuncCall.fnName instanceof AstExprIdent) {
//        fnName = ((AstExprIdent) exprFuncCall.fnName).ident;
//      } else if (exprFuncCall.fnName instanceof AstExprExplicitMemberAccess) {
//        //fnName = ((AstExprExplicitMemberAccess) exprFuncCall).lhs;
//        fnName = ((AstExprExplicitMemberAccess) exprFuncCall.fnName).rhs.toString();
//      } else {
//        throw new VmRuntimeException("Can not resolve function call base", exprFuncCall.srcLocation);
//      }
//
//      var stmts = vmExecContext.getFunctionByName(fnName, functionSignature);
//      if (stmts != null) {
//        if (stmts instanceof Vm.FunctionRef) {
//          var vmFuncRef = (Vm.FunctionRef) stmts;
//
//          /* Create a new VmExeContext for the function call. And resolve parameter. */
//          var localVmExecContext = new VmDefaultExecContext(vmExecContext);
//          int i = 0;
//          for (var pIdent : vmFuncRef.funcRef.signature.list) {
//            localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFuncCall.arguments[i], vmExecContext));
//            i += 1;
//          }
//
//          Vm.Value exec = vm.exec(vmFuncRef.funcRef.body, localVmExecContext);
//          return exec;
//        }
//
//        var vmFuncBuildIn = (Vm.FunctionBuildInRef) stmts;
//        return vmFuncBuildIn.funcRef.exec(vm, exprFuncCall.arguments, vmExecContext);
//      }
//
//
//      return null;


//
//    }
//  }
//
//  private static Vm.Value execFunctionCall(AstExprFunctionCall exprFuncCall, Vm vm, VmExecContext vmExecContext) {
//
//
//
//    var types = Arrays.stream(exprFuncCall.arguments)
//            .map((AstExpr astExpr) -> Sema.getResultType(astExpr, vmExecContext))
//            .toArray(Type[]::new);
//
//    FunctionSignature functionSignature = new FunctionSignature(Type.VOID, types);
//
//    final String fnName;
//    if (exprFuncCall.fnName instanceof AstExprIdent) {
//      fnName = ((AstExprIdent) exprFuncCall.fnName).ident;
//    }
//    else if (exprFuncCall.fnName instanceof AstExprExplicitMemberAccess) {
//      //fnName = ((AstExprExplicitMemberAccess) exprFuncCall).lhs;
//      fnName = ((AstExprExplicitMemberAccess) exprFuncCall.fnName).rhs.toString();
//    } else {
//      throw new VmRuntimeException("Can not resolve function call base", exprFuncCall.srcLocation);
//    }
//
//    var stmts = vmExecContext.getFunctionByName(fnName,functionSignature);
//    if (stmts != null) {
//      if (stmts instanceof Vm.FunctionRef) {
//        var vmFuncRef = (Vm.FunctionRef) stmts;
//
//        /* Create a new VmExeContext for the function call. And resolve parameter. */
//        var localVmExecContext = new VmDefaultExecContext(vmExecContext);
//        int i = 0;
//        for (var pIdent : vmFuncRef.funcRef.signature.list) {
//          localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFuncCall.arguments[i], vmExecContext));
//          i += 1;
//        }
//
//        Vm.Value exec = vm.exec(vmFuncRef.funcRef.body, localVmExecContext);
//        return exec;
//      }
//
//      var vmFuncBuildIn = (Vm.FunctionBuildInRef) stmts;
//      return vmFuncBuildIn.funcRef.exec(vm, exprFuncCall.arguments, vmExecContext);
//    }
//    return null;
//  }

  private static class UnknownFunctionCallType extends Vm.VmException {
    public UnknownFunctionCallType(AstExprFunctionCall exprFuncCall) {
      super(exprFuncCall, "I do not know how to call this function.");
    }
  }
}
