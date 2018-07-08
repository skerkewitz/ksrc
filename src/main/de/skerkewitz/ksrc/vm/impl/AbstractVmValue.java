package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public abstract class AbstractVmValue<T> implements Vm.Value {

  protected final T value;
  protected final VmDescriptor descriptor;

  protected AbstractVmValue(T value, VmDescriptor type) {
    this.value = value;
    this.descriptor = type;
  }

  @Override
  public VmDescriptor descriptor() {
    return descriptor;
  }

  @Override
  public Double double_value() {
    throw new RuntimeException("Operation add is not supported on descriptor " + descriptor.toString());
  }

  @Override
  public Vm.Value add(Vm.Value other) {
    throw new RuntimeException("Operation add is not supported on descriptor " + descriptor.toString());
  }

  @Override
  public Object ref_value() {
    throw new RuntimeException("Operation add is not supported on descriptor " + descriptor.toString());
  }
}
