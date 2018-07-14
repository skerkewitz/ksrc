package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.AstDeclarationClass;
import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.ast.nodes.expr.*;
import de.skerkewitz.ksrc.ast.nodes.statement.*;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationNamedValue;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.vm.Vm;

/**
 * Quick and dirty default implementation of the ksrc {@link Vm}. Its actually a interpreter and not a real virtual
 * machine.
 */
public class DefaultVm implements Vm {

  public final Sema sema;

  public DefaultVm(Sema sema) {
    this.sema = sema;
  }

  @Override
  public Sema getSema() {
    return sema;
  }

  @Override
  public final Value eval(AstExpr expression, VmExecContext vmExecContext) {

    if (expression == null) {
      throw new IllegalArgumentException("astNode can not be null");
    }

    if (expression instanceof AstExprLiteral) {
      final AstExprLiteral exprValue = (AstExprLiteral) expression;
      switch (exprValue.descriptor.type) {
        case STRING: return new VmValueString(exprValue.value);
        case INT: return new VmValueInt(VmUtils.integerFromString(exprValue.value));
        case DOUBLE: return new VmValueDouble(VmUtils.doubleFromString(exprValue.value));
        default: return VmValueVoid.shared;
      }
    }
    else if (expression instanceof AstExprInfixOp) {
      final AstExprInfixOp infixOp = (AstExprInfixOp) expression;
      Value lhs = eval(infixOp.lhs, vmExecContext);
      Value rhs = eval(infixOp.rhs, vmExecContext);
      switch (infixOp.op) {
        case POW: throw new RuntimeException("Infix operator " + infixOp.op + " no implemented yet");
        case MINUS: {
          switch (lhs.descriptor().type) {
            case INT: return new VmValueInt(lhs.int_value() - rhs.int_value());
            case DOUBLE: return new VmValueDouble(lhs.double_value() - rhs.double_value());
            default: throw new RuntimeException("Infix operator " + infixOp.op + " no implemented for descriptor " + lhs.descriptor());
          }
        }
        case MULT: return new VmValueDouble(lhs.double_value() * rhs.double_value());
        case DIV: return new VmValueDouble(lhs.double_value() / rhs.double_value());
        case MOD: {
          switch (lhs.descriptor().type) {
            case INT: return new VmValueInt(lhs.int_value() % rhs.int_value());
            default: throw new RuntimeException("Infix operator " + infixOp.op + " no implemented for descriptor " + lhs.descriptor());
          }
        }
        case PLUS: return lhs.add(rhs);
        case LTEQ: return new VmValueBool(lhs.double_value() <= rhs.double_value());
        case GTEQ: return new VmValueBool(lhs.double_value() >= rhs.double_value());
        case LT: return new VmValueBool(lhs.double_value() < rhs.double_value());
        case GT: return new VmValueBool(lhs.double_value() > rhs.double_value());
        case EQ: return new VmValueBool(lhs.eq(rhs));
        case IDEQ: throw new RuntimeException("Infix operator " + infixOp + " no implemented yet");
        case NEQ: return new VmValueBool(!lhs.eq(rhs));
        case AND: return new VmValueBool(lhs.bool_value() && rhs.bool_value());
        case OR: return new VmValueBool(lhs.bool_value() || rhs.bool_value());
      }
    }
    else if (expression instanceof AstExprIdent) {
      final AstExprIdent exprIdent = (AstExprIdent) expression;
      return vmExecContext.getSymbolByName(exprIdent.ident);
    }

    // -- Function call
    if (expression instanceof AstExprFunctionCall) {
      final AstExprFunctionCall exprFuncCall = (AstExprFunctionCall) expression;
      return VmFunctionCallHelper.exec(exprFuncCall, this, vmExecContext);
    }

    if (expression instanceof AstExprExplicitMemberAccess) {
      AstExprExplicitMemberAccess memberAccess = (AstExprExplicitMemberAccess)expression;

      Value baseType = eval(memberAccess.lhs, vmExecContext);

      if (baseType == null) {
        throw new Sema.SemaException(memberAccess.lhs, "Could not resolve type for '" + memberAccess.lhs + "'");
      }

      if (baseType.descriptor().type != Type.ANY_REF) {
        throw new Sema.SemaException(memberAccess.lhs, "lhs of member acccess is not a reference type '" + memberAccess.lhs + "'");
      }

      VmClassInstance classInstance = (VmClassInstance) baseType.ref_value();
      String fieldname = ((AstExprIdent) memberAccess.rhs).ident;
      return classInstance.getFieldValue(fieldname);
    }

    throw new UnknownExpression(expression);
  }

  @Override
  public Value exec(AstStatement statement, VmExecContext vmExecContext) {

    if (statement == null) {
      throw new IllegalArgumentException("thenStatement can not be null");
    }

    if (statement instanceof AstExpr) {
      AstExpr expr = (AstExpr) statement;
      return eval(expr, vmExecContext);
    }
    else if (statement instanceof AstStatements) {
      AstStatements stmtList = (AstStatements) statement;
      Value result = VmValueVoid.shared;
      for (AstStatement stmt : stmtList.statements) {
        if (stmt == null) {
          continue;
        }

        result = exec(stmt, vmExecContext);
        if (vmExecContext.shouldLeaveFrame()) {
          return vmExecContext.getReturnValue();
        }
      }
      return result;
    }
    else if (statement instanceof AstStatementReturn) {
      AstStatementReturn stmtReturn = (AstStatementReturn) statement;
      Value value = eval(stmtReturn.expr, vmExecContext);
      vmExecContext.markLeaveFrame(value);
      return value;
    }
    else if (statement instanceof AstStatementBreak) {
      vmExecContext.markLeaveFrame(null);
      return VmValueVoid.shared;
    }
    else if (statement instanceof AstDeclarationStatement) {
        return execDeclarationStatement(statement, vmExecContext);
    }
    else if (statement instanceof AstStatementIf) {
      final var stmtDeclIf = (AstStatementIf) statement;
      var value = eval(stmtDeclIf.condition, vmExecContext);
      if (value.bool_value()) {
        return exec(stmtDeclIf.thenStatement, vmExecContext);
      } else if (stmtDeclIf.elseStatement != null) {
        return exec(stmtDeclIf.elseStatement, vmExecContext);
      }

      return VmValueVoid.shared;
    }
    else if (statement instanceof AstStatementWhile) {
      final var statementWhile = (AstStatementWhile) statement;
      var value = eval(statementWhile.condition, vmExecContext);
      while (value.bool_value()) {
        vmExecContext.getCurrentFrame().pushLexcialScope();
        exec(statementWhile.body, vmExecContext);
        vmExecContext.getCurrentFrame().popLexcialScope();
        /* Check for break or return. */
        if (vmExecContext.shouldLeaveFrame()) {
          if (vmExecContext.getReturnValue() == null) {
            vmExecContext.resetLeaveFrame();
          }
          return vmExecContext.getReturnValue();
        }

        value = eval(statementWhile.condition, vmExecContext);
      }

      return VmValueVoid.shared;
    }
    else if (statement instanceof AstStatementAssign) {
      final var assignStatement = (AstStatementAssign) statement;
      var value = eval(assignStatement.expression, vmExecContext);
      if (assignStatement.ident instanceof AstExprIdent) {
        AstExprIdent ident = (AstExprIdent)assignStatement.ident;
        vmExecContext.setSymbolToValue(ident.ident, value, ident);
      } else {
        AstExprExplicitMemberAccess memberAccess = (AstExprExplicitMemberAccess)assignStatement.ident;

        Value baseType = eval(memberAccess.lhs, vmExecContext);

        if (baseType == null) {
          throw new Sema.SemaException(memberAccess.lhs, "Could not resolve type for '" + memberAccess.lhs + "'");
        }

        if (baseType.descriptor().type != Type.ANY_REF) {
          throw new Sema.SemaException(memberAccess.lhs, "lhs of member acccess is not a reference type '" + memberAccess.lhs + "'");
        }

        VmClassInstance classInstance = (VmClassInstance) baseType.ref_value();
        String fieldname = ((AstExprIdent) memberAccess.rhs).ident;
        classInstance.setFieldValue(fieldname, value);
      }

      return VmValueVoid.shared;
    }

    throw new UnknownStatement(statement);
  }

  private Value execDeclarationStatement(AstStatement statement, VmExecContext vmExecContext) {

    if (statement instanceof AstDeclarationNamedValue) {
      final var astDeclarationVar = (AstDeclarationNamedValue) statement;
      Value value;
      if (astDeclarationVar.initializer == null) {
        value = astDeclarationVar.typeIdentifier.descriptor.type.getDefault_init_value();
      } else {
        value = eval(astDeclarationVar.initializer, vmExecContext);
      }
      vmExecContext.declareSymbol(astDeclarationVar.name.ident, value, astDeclarationVar);
      return value;
    }
    else if (statement instanceof AstDeclarationFunction) {
//      final var stmtDeclFunc = (AstDeclarationFunction) statement;
//      final var funcIdent = stmtDeclFunc.name.ident;
//      try {
//        var list = stmtDeclFunc.signature.list.stream().map(o -> o.type.descriptor.type).toArray(Type[]::new);
//        FunctionSignature functionSignature = new FunctionSignature(Type.VOID, list);
//        vmExecContext.declareFunc(new FunctionRef(funcIdent, stmtDeclFunc, functionSignature));
//      } catch (VmDefaultExecContext.VmSymbolAlreadyDeclared e) {
//        throw new VmInvalidFuncRedeclaration(funcIdent, stmtDeclFunc.srcLocation);
//      }
      return VmValueVoid.shared;
    }
    else if (statement instanceof AstDeclarationClass) {
//      final var stmtDeclClass = (AstDeclarationClass) statement;
//      final var className = stmtDeclClass.name.ident;
//
//      /* Declare all functions. */
//      for (var f: stmtDeclClass.functions) {
//        exec(f, vmExecContext);
//      }
//
//      try {
//        vmExecContext.declareClass(new ClassRef(className, stmtDeclClass));
//      } catch (VmDefaultExecContext.VmSymbolAlreadyDeclared e) {
//        throw new VmInvalidFuncRedeclaration(className, stmtDeclClass.srcLocation);
//      }
      return VmValueVoid.shared;
    }


    throw new UnknownStatement(statement);
  }



}
