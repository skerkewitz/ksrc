package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class VmValueDouble extends AbstractVmValue<Double> {

  public VmValueDouble(Double value) {
    super(value, new VmDescriptor(Type.DOUBLE));
  }

  @Override
  public String string_value() {
    return value == null ? null : value.toString();
  }

  @Override
  public Double double_value() {
    return value;
  }

  @Override
  public Integer int_value() {
    return value.intValue();
  }

  @Override
  public Boolean bool_value() {
    return !eq(new VmValueDouble(0.0));
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return Math.abs(value - rhs.double_value()) < 0.00001;
  }

  @Override
  public Vm.Value add(Vm.Value other) {
    return new VmValueDouble(double_value() + other.double_value());

  }
}
