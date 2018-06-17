package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.exceptions.VmUtils;

public class VmValueString implements Vm.Value {

  private final String value;

  public VmValueString(String value) {
    this.value = value;
  }

  @Override
  public Type type() {
    return Type.STRING;
  }

  @Override
  public String str() {
    return value;
  }

  @Override
  public Double num() {
    return VmUtils.convertStringToNumber(value);
  }
}
