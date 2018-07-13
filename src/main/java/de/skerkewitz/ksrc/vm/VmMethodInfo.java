package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
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

  public final AstDeclarationFunction functionDeclaration;

  public VmMethodInfo(String name, VmMethodDescriptor descriptor, AstDeclarationFunction functionDeclaration) {
    // TODO: use factory method for each kind (native, abstract, instance, class, global)
    if (name == null || descriptor == null) {
      throw new IllegalArgumentException("Arguments can not be null");
    }

    this.name = name;
    this.descriptor = descriptor;
    this.functionDeclaration = functionDeclaration;
  }

  @Override
  public String toString() {
    return name + ':' + descriptor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VmMethodInfo)) return false;
    VmMethodInfo that = (VmMethodInfo) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(descriptor, that.descriptor);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, descriptor);
  }
}
