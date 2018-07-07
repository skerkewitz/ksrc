package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.util.Objects;

/**
 * Each method, including each instance initialization method and the class or interface initialization method, is
 * described by a method_info structure. No two methods in one class file may have the same name and descriptor.
 *
 * No two fields in one class file may have the same name and descriptor.
 */
public class VmMethodInfo {

  /** A valid unqualified name of the method. */
  public final String name;

  /** The descriptor of this field. */
  public final VmMethodDescriptor descriptor;

  public VmMethodInfo(String name, VmMethodDescriptor descriptor) {
    this.name = name;
    this.descriptor = descriptor;
  }

}
