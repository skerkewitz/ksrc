package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExpr;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprFunctionCall;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprValue;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprInfixOp;
import de.skerkewitz.ksrc.vm.Vm;

public class Sema {

  public static Type getResultType(AstExpr astExpr, VmExecContext vmExecContext) {

    if (astExpr instanceof AstExprValue) {
      return ((AstExprValue) astExpr).type;
    }
    else if (astExpr instanceof AstExprFunctionCall) {
      AstExprFunctionCall exprFuncCall = (AstExprFunctionCall) astExpr;
      Vm.Function function = vmExecContext.getFuncByName(exprFuncCall.fnName, null);
      return function.signature.returnType;
    }
    else if (astExpr instanceof AstExprInfixOp) {
      AstExprInfixOp exprOp = (AstExprInfixOp) astExpr;
      return getResultType(exprOp.lhs, vmExecContext);
    }
    else if (astExpr instanceof AstExprIdent) {
      AstExprIdent exprIdent = (AstExprIdent) astExpr;
      return vmExecContext.getSymbolByName(exprIdent.ident).type();
    }

    throw new SemaCantDetermineTypeException(astExpr);
  }

  private static class SemaCantDetermineTypeException extends RuntimeException {
    public SemaCantDetermineTypeException(AstExpr astExpr) {
    }
  }
}
