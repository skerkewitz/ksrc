package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public class VmValueString extends AbstractVmValue<String> {

  public VmValueString(String value) {
    super(value, Type.STRING);
  }

  @Override
  public String string_value() {
    return value;
  }

  @Override
  public Double double_value() {
    return VmUtils.doubleFromString(value);
  }

  @Override
  public Integer int_value() {
    return VmUtils.integerFromString(value);
  }

  @Override
  public Boolean bool_value() {
    return !value.isEmpty();
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return value.equals(rhs.string_value());
  }

  @Override
  public Vm.Value add(Vm.Value other) {
    return new VmValueString(string_value() + other.string_value());
  }
}
