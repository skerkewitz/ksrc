package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public abstract class AbstractVmValue<T> implements Vm.Value {

  protected final T value;
  protected final Type type;

  protected AbstractVmValue(T value, Type type) {
    this.value = value;
    this.type = type;
  }

  @Override
  public Type type() {
    return type;
  }

  @Override
  public Vm.Value add(Vm.Value other) {
    throw new RuntimeException("Operation add is not supported on type " + type.toString());
  }
}
