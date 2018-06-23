package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;

public class VmValueVoid extends AbstractVmValue<Void> {

  public final static VmValueVoid shared = new VmValueVoid(null);

  public VmValueVoid(Void value) {
    super(value, Type.VOID);
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
