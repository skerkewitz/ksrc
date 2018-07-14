package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.vm.Vm;

import java.io.OutputStream;
import java.util.*;

public final class VmDefaultExecContext implements VmExecContext {

  public static OutputStream stdout = System.out;
  public static OutputStream stderr = System.err;

  private Deque<VmStackFrame> stackFrames = new ArrayDeque<>();


  @Override
  public Vm.Value getSymbolByName(String name) {
    /* Check the current frame first. */
    VmStackFrame currentStackFrame = stackFrames.peek();
    var localSymbol = currentStackFrame.locals.getSymbolByName(name);
    if (localSymbol != null) {
      return localSymbol;
    }

    /* if the localSymbol is not declared in the current stack frame check the global stack frame. */
    VmStackFrame globalStackFrame = stackFrames.peekLast();
    var globalSymbol = globalStackFrame.locals.getSymbolByName(name);
    if (globalSymbol != null) {
      return globalSymbol;
    }

    throw new VmUnknownSymbol(name);
  }

  @Override
  public void declareSymbol(String name, Vm.Value value, AstNode node) {
    if (value == null) {
      // use Vm.NullValue instead
      throw new IllegalArgumentException("value can not be null");
    }

    /* Check the current frame first. */
    VmStackFrame currentStackFrame = stackFrames.peek();
    currentStackFrame.locals.declareSymbol(name, value, node);
  }

  @Override
  public void setSymbolToValue(String name, Vm.Value value, AstExprIdent astExprIdent) {
    if (value == null) {
      // use Vm.NullValue instead
      throw new IllegalArgumentException("value can not be null");
    }

    /* Check the current frame first. */
    VmStackFrame currentStackFrame = stackFrames.peek();
    var localSymbol = currentStackFrame.locals.getSymbolByName(name);
    if (localSymbol != null) {
      currentStackFrame.locals.redeclareSymbol(name, value, astExprIdent);
      return;
    }

    /* if the localSymbol is not declared in the current stack frame check the global stack frame. */
    VmStackFrame globalStackFrame = stackFrames.peekLast();
    var globalSymbol = globalStackFrame.locals.getSymbolByName(name);
    if (globalSymbol != null) {
      globalStackFrame.locals.redeclareSymbol(name, value, astExprIdent);
      return;
    }

    throw new VmUnknownSymbol(name);
  }

  @Override
  public boolean shouldLeaveFrame() {
    return stackFrames.peek().shouldLeaveFrame();
  }

  @Override
  public void markLeaveFrame(Vm.Value returnValue) {
    stackFrames.peek().markLeaveFrame(returnValue);
  }

  @Override
  public void pushFrame(VmStackFrame vmStackFrame) {
    stackFrames.push(vmStackFrame);
  }

  @Override
  public VmStackFrame popFrame() {
    return stackFrames.pop();
  }

  @Override
  public VmStackFrame getCurrentFrame() {
    return stackFrames.peek();
  }

  @Override
  public Vm.Value getReturnValue() {
    return stackFrames.peek().getReturnValue();
  }

  @Override
  public void resetLeaveFrame() {
    stackFrames.peek().resetLeaveFrame();
  }
}
