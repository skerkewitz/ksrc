package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

public class VmUnknownFunction extends VmRuntimeException {
  public VmUnknownFunction(String name, VmMethodDescriptor descriptor) {
    super("Unknown function '" + name + descriptor.toString() + "'", null);
  }
}
