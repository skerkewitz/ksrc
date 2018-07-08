package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmMethodInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import de.skerkewitz.ksrc.vm.impl.VmExecContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sema {

  private final List<VmClassInfo> classDeclarations = new ArrayList<>();

  public VmDescriptor resolveType(AstExpr expr, SymbolTable localSymbols) {

    if (expr instanceof AstExprFunctionCall) {
      return resolveTypeForCall((AstExprFunctionCall) expr, localSymbols);
    }

    return null;
  }

  private VmDescriptor resolveTypeForCall(AstExprFunctionCall exprFunctionCall, SymbolTable localSymbols) {

    if (exprFunctionCall.fnName instanceof AstExprIdent) {
      return resolveTypeForFunctionCall(exprFunctionCall);
    }
    else if (exprFunctionCall.fnName instanceof AstExprExplicitMemberAccess) {
      return resolveTypeForMethodCall(exprFunctionCall, localSymbols);
    }

    throw new SemaException(exprFunctionCall, "Invalid function calll syntax");
  }

  private VmDescriptor resolveTypeForMethodCall(AstExprFunctionCall exprFunctionCall, SymbolTable localSymbols) {

    /* Check for Constructor call first. */
    AstExprExplicitMemberAccess member = (AstExprExplicitMemberAccess) exprFunctionCall.fnName;

    // Lookup the type of the expresssion.
    String baseIdent = ((AstExprIdent) member.lhs).ident;
    String functionName = ((AstExprIdent) member.rhs).ident;
    VmDescriptor baseType = localSymbols.getSymbolByName(baseIdent);
    if (baseType == null) {
      throw new SemaException(exprFunctionCall, "Could not resolve symbol '" + baseIdent + "'");
    }


    VmClassInfo classInfo = findClassInfoWithName(baseType.fqClassName);
    if (classInfo != null) {

      /* Do we have a suitable constructor in this class? */
      List<VmDescriptor> argumentsDescriptor = Arrays.stream(exprFunctionCall.args).map(expr -> expr.descriptor).collect(Collectors.toList());
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
      VmMethodDescriptor methodDescriptor = new VmMethodDescriptor(new VmDescriptor(Type.VOID),
              Arrays.stream(exprFunctionCall.args).map(expr -> expr.descriptor).collect(Collectors.toList()));

      if (classInfo.methods.contains(new VmMethodInfo("init", methodDescriptor))) {
        return new VmDescriptor(Type.ANY_REF, ident.ident);
      }
    }

    return null;
  }

  private VmClassInfo findClassInfoWithName(String ident) {
    for (var ci: classDeclarations) {
      if (ci.fqThisClassName.equals(ident)) {
        return ci;
      }
    }

    return null;
  }


  public static VmDescriptor getResultType(AstExpr astExpr, VmExecContext vmExecContext) {

    if (astExpr instanceof AstExprValue) {
      return ((AstExprValue) astExpr).descriptor;
    }
    else if (astExpr instanceof AstExprFunctionCall) {
      AstExprFunctionCall exprFuncCall = (AstExprFunctionCall) astExpr;
      AstExpr fnName = exprFuncCall.fnName;
      Vm.Function function = vmExecContext.getFuncByName(null, null);
      //return function.signature.returnType;

      return null;
    }
    else if (astExpr instanceof AstExprInfixOp) {
      AstExprInfixOp exprOp = (AstExprInfixOp) astExpr;
      return getResultType(exprOp.lhs, vmExecContext);
    }
    else if (astExpr instanceof AstExprIdent) {
      AstExprIdent exprIdent = (AstExprIdent) astExpr;
      return vmExecContext.getSymbolByName(exprIdent.ident).descriptor();
    }

    throw new SemaCantDetermineTypeException(astExpr);
  }

  public void addClassDeclaration(VmClassInfo classInfo) {
    this.classDeclarations.add(classInfo);
  }

  public void addClassDeclarations(List<VmClassInfo> classInfos) {
    this.classDeclarations.addAll(classInfos);
  }

  public static class SemaException extends RuntimeException {
    private final AstNode astNode;

    public SemaException(AstNode astNode, String message) {
      super(message + " (" + astNode.srcLocation + ")");
      this.astNode = astNode;
    }
  }

  public static class SemaCantDetermineTypeException extends SemaException {
    public SemaCantDetermineTypeException(AstExpr astExpr) {
      super(astExpr, "Can not determine type");
    }
  }
}
