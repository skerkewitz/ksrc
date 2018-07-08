package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.FunctionSignature;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprExplicitMemberAccess;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

import java.util.Arrays;
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

    /* Check for Constructor call first. */
    AstExprIdent ident = (AstExprIdent) exprFunctionCall.fnName;
    VmClassInfo classInfo = vm.getSema().findClassInfoWithName(ident.ident);
    if (classInfo != null) {

      /* Do we have a suitable constructor in this class? */
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(new VmDescriptor(Type.VOID),
              Arrays.stream(exprFunctionCall.args).map(expr -> expr.descriptor).collect(Collectors.toList()));

      Optional<VmMethodInfo> matches = classInfo.findMatchesByFunctionNameAndMethodDescriptor("init", methodDescriptor);
      if (matches.isPresent()) {
        /* This is a constructore call. */
        return new VmValueRef(null, classInfo.fqThisClassName);
      }
    }

    // TODO Fix simple methods
    // TODO Fix build in methods

    /* I don't know how to call this function. */
    throw new UnknownFunctionCallType(exprFunctionCall);
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
    List<VmDescriptor> argumentsDescriptor = Arrays.stream(exprFunctionCall.args).map(expr -> expr.descriptor).collect(Collectors.toList());
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
      localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFunctionCall.args[i], vmExecContext));
      i += 1;
    }

    /* Call the function. */
    return vm.exec(vmMethodInfo.functionDeclaration.body, localVmExecContext);
  }

    //
//      var types = Arrays.stream(exprFuncCall.args)
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
//      var stmts = vmExecContext.getFuncByName(fnName, functionSignature);
//      if (stmts != null) {
//        if (stmts instanceof Vm.FunctionRef) {
//          var vmFuncRef = (Vm.FunctionRef) stmts;
//
//          /* Create a new VmExeContext for the function call. And resolve parameter. */
//          var localVmExecContext = new VmDefaultExecContext(vmExecContext);
//          int i = 0;
//          for (var pIdent : vmFuncRef.funcRef.signature.params) {
//            localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFuncCall.args[i], vmExecContext));
//            i += 1;
//          }
//
//          Vm.Value exec = vm.exec(vmFuncRef.funcRef.body, localVmExecContext);
//          return exec;
//        }
//
//        var vmFuncBuildIn = (Vm.FunctionBuildInRef) stmts;
//        return vmFuncBuildIn.funcRef.exec(vm, exprFuncCall.args, vmExecContext);
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
//    var types = Arrays.stream(exprFuncCall.args)
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
//    var stmts = vmExecContext.getFuncByName(fnName,functionSignature);
//    if (stmts != null) {
//      if (stmts instanceof Vm.FunctionRef) {
//        var vmFuncRef = (Vm.FunctionRef) stmts;
//
//        /* Create a new VmExeContext for the function call. And resolve parameter. */
//        var localVmExecContext = new VmDefaultExecContext(vmExecContext);
//        int i = 0;
//        for (var pIdent : vmFuncRef.funcRef.signature.params) {
//          localVmExecContext.declareSymbol(pIdent.name.ident, vm.eval(exprFuncCall.args[i], vmExecContext));
//          i += 1;
//        }
//
//        Vm.Value exec = vm.exec(vmFuncRef.funcRef.body, localVmExecContext);
//        return exec;
//      }
//
//      var vmFuncBuildIn = (Vm.FunctionBuildInRef) stmts;
//      return vmFuncBuildIn.funcRef.exec(vm, exprFuncCall.args, vmExecContext);
//    }
//    return null;
//  }

  private static class UnknownFunctionCallType extends Vm.VmException {
    public UnknownFunctionCallType(AstExprFunctionCall exprFuncCall) {
      super(exprFuncCall, "I do not know how to call this function.");
    }
  }
}
