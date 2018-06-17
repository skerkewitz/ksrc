package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public class VmValueString implements Vm.Value {

  private final String value;

  public VmValueString(String value) {
    this.value = value;
  }

  @Override
  public Type type() {
    return Type.STRING;
  }

  @Override
  public String str() {
    return value;
  }

  @Override
  public Double num() {
    return VmUtils.convertStringToNumber(value);
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return value.equals(rhs.str());
  }
}
