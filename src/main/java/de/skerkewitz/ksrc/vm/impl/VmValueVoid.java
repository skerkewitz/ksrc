package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.parse.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class VmValueVoid extends AbstractVmValue<Void> {

  public final static VmValueVoid shared = new VmValueVoid(null);

  public VmValueVoid(Void value) {
    super(value, new VmDescriptor(Type.VOID, null));
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
  public Boolean bool_value() {
    return null;
  }
}
