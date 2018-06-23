package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public class VmValueBool extends AbstractVmValue<Boolean> {

  public VmValueBool(Boolean value) {
    super(value, Type.BOOL);
  }


  @Override
  public String string_value() {
    return value == null ? null : value.toString();
  }

  @Override
  public Double double_value() {
    return value ? 1.0 : 0.0;
  }

  @Override
  public Integer int_value() {
    return value ? 1 : 0;
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return value.booleanValue() == rhs.bool_value();
  }

  @Override
  public Boolean bool_value() {
    return value;
  }
}
