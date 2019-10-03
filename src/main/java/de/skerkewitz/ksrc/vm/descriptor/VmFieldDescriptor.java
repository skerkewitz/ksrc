package de.skerkewitz.ksrc.vm.descriptor;

import de.skerkewitz.ksrc.parse.ast.Type;

/**
 * A field descriptor represents the descriptor of a class, instance, or local variable.
 */
public class VmFieldDescriptor extends VmDescriptor {

  public VmFieldDescriptor(Type type, String fqClassName) {
    super(type, fqClassName);
  }




}
