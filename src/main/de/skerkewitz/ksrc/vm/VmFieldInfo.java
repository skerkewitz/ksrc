package de.skerkewitz.ksrc.vm;

import java.util.Objects;

/**
 * Each field in a class is described by a {@link VmFieldInfo} structure.
 *
 * No two fields in one class file may have the same name and descriptor.
 */
public class VmFieldInfo {

  /** A valid unqualified name of the field. */
  public final String name;

  /** The descriptor of this field. */
  public final String fqClassName;

  public VmFieldInfo(String name, String fqClassName) {
    this.name = name;
    this.fqClassName = fqClassName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VmFieldInfo)) return false;
    VmFieldInfo that = (VmFieldInfo) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(fqClassName, that.fqClassName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, fqClassName);
  }
}
