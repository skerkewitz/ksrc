package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public class VmValueVoid implements Vm.Value {

  public final static VmValueVoid shared = new VmValueVoid();

  @Override
  public Type type() {
    return Type.VOID;
  }

  @Override
  public String str() {
    return null;
  }

  @Override
  public Double num() {
      return null;
  }
}
