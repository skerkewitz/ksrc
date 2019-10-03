package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.parse.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class VmValueBool extends AbstractVmValue<Boolean> {

  public VmValueBool(Boolean value) {
    super(value, new VmDescriptor(Type.BOOL));
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
