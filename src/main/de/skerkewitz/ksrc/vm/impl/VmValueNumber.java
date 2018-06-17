package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public class VmValueNumber implements Vm.Value {

  private final Double value;

  public VmValueNumber(Double value) {
    this.value = value;
  }

  @Override
  public Type type() {
    return Type.NUMBER;
  }

  @Override
  public String str() {
    return value == null ? null : value.toString();
  }

  @Override
  public Double num() {
    return value;
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return Math.abs(value - rhs.num()) < 0.00001;
  }
}
