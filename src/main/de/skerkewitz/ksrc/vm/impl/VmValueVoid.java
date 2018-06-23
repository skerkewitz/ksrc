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
  public String string_value() {
    return null;
  }

  @Override
  public Double double_value() {
      return null;
  }

  @Override
  public Integer int_value() { return null; }

  @Override
  public boolean eq(Vm.Value rhs) {
    return false;
  }

  @Override
  public Vm.Value add(Vm.Value other) {
    return VmValueVoid.shared;
  }
}
