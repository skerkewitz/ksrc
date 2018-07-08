package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

public class VmValueRef extends AbstractVmValue<Object> {

  public VmValueRef(Object value, String classname) {
    super(value, new VmDescriptor(Type.ANY_REF, classname));
  }

  @Override
  public String string_value() {
    return value == null ? null : value.toString();
  }

  @Override
  public Integer int_value() {
    return value.hashCode();
  }

  @Override
  public Boolean bool_value() {
    return value != null;
  }

  @Override
  public Object ref_value() {
    return value;
  }

  @Override
  public boolean eq(Vm.Value rhs) {
    return rhs.descriptor().equals(this.descriptor) && value.equals(rhs.ref_value());
  }

}
