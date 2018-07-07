package de.skerkewitz.ksrc.vm.descriptor;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

/**
 * A field descriptor represents the type of a class, instance, or local variable.
 */
public class VmFieldDescriptor extends VmDescriptor {

  public VmFieldDescriptor(Type type, String fqClassName) {
    super(type, fqClassName);
  }




}
