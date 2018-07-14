package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.vm.Vm;

import java.io.OutputStream;

public interface VmExecContext {

  Vm.Value getSymbolByName(String name);
  void declareSymbol(String name, Vm.Value value, AstNode node);
  void setSymbolToValue(String ident, Vm.Value value, AstExprIdent astExprIdent);

  boolean shouldLeaveFrame();
  void resetLeaveFrame();

  Vm.Value getReturnValue();

  /**
   * Specifies the value the frame should return null. Null indicate a break instead of a return.
   * Use(or {@link de.skerkewitz.ksrc.vm.impl.VmValueVoid#shared} to return void.
   */
  void markLeaveFrame(Vm.Value returnValue);

  void pushFrame(VmStackFrame vmStackFrame);

  VmStackFrame popFrame();

  VmStackFrame getCurrentFrame();

  OutputStream getStdout();

  OutputStream getStderr();


  class VmUnknownSymbol extends RuntimeException {
    private final String name;

    public VmUnknownSymbol(String name) {
      super("Unknown VM symbol '" + name + "'");
      this.name = name;
    }
  }

  class VmSymbolAlreadyDeclared extends RuntimeException {
    private final String name;

    public VmSymbolAlreadyDeclared(String name) {
      this.name = name;
    }
  }
}
