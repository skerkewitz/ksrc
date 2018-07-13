package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class VmValueInt extends AbstractVmValue<Integer> {

  public VmValueInt(Integer value) {
    super(value, new VmDescriptor(Type.INT, null));
  }

  @Override
  public String string_value() {
    return value == null ? null : value.toString();
  }

  @Override
  public Double double_value() {
    return value.doubleValue();
  }

  @Override
  public Integer int_value() {
    return value;
  }

  @Override
  public Boolean bool_value() {
    return value != 0;
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return Math.abs(value - rhs.double_value()) < 0.00001;
  }

  @Override
  public Vm.Value add(Vm.Value other) {
    return new VmValueInt(int_value() + other.int_value());
  }
}
