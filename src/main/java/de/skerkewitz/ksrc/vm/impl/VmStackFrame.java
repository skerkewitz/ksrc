package de.skerkewitz.ksrc.vm.impl;


import de.skerkewitz.ksrc.sema.SymbolTable;
import de.skerkewitz.ksrc.vm.Vm;

/**
 * The stack frame usually has three parts: local variables, operand stack, and frame data. Currently we use this
 * not as efficient as it could be.
 */
public class VmStackFrame {

  /**
   * Local include all local variables as well as all parameter of an function.
   * Usually local variable should be managed with an array and direct index access. For the time we resolve symbols
   * on the fly.
   */
  public SymbolTable<Vm.Value> locals = new SymbolTable<>();

  // TODO: implement operand stack.

  // Frame data section contains all the information about the current frame.
  private final String name;
  private boolean _leaveFrame = false;
  private Vm.Value _returnValue;


  public VmStackFrame(String name) {
    this.name = name;
  }

  public boolean shouldLeaveFrame() {
    return _leaveFrame;
  }

  public void markLeaveFrame(Vm.Value returnValue) {
    _returnValue = returnValue;
    _leaveFrame = true;
  }

  public Vm.Value getReturnValue() {
    return _returnValue;
  }

  public void resetLeaveFrame() {
    _leaveFrame = false;
    _returnValue = null;
  }

  public void pushLexcialScope() {
    this.locals = new SymbolTable<>(this.locals);
  }
  public void popLexcialScope() {
    this.locals = this.locals.parent;
  }

}
