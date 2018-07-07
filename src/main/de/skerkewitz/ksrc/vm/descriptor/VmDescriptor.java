package de.skerkewitz.ksrc.vm.descriptor;

import de.skerkewitz.ksrc.ast.Type;

import java.util.Objects;

public class VmDescriptor {
  public final Type type;
  /**
   * If the field is of type <code>Type.ANY_REF</code> then this field specifes the fully qualified class name, else
   * it is null
   */
  public final String fqClassName;

  public VmDescriptor(Type type, String fqClassName) {
    this.fqClassName = fqClassName;
    this.type = type;
  }

  public static VmDescriptor fromString(String s) {
    /* Check for simple types first. */
    if (s.length() == 1) {
      if (s.equals("V")) {
        return new VmDescriptor(Type.VOID, null);
      }
      else if (s.equals("Z")) {
        return new VmDescriptor(Type.BOOL, null);
      }
      else if (s.equals("I")) {
        return new VmDescriptor(Type.INT, null);
      }
      else if (s.equals("D")) {
        return new VmDescriptor(Type.DOUBLE, null);
      }
      else if (s.equals("S")) {
        return new VmDescriptor(Type.STRING, null);
      }
    }

    if (s.startsWith("L") && s.endsWith(";")) {
      return new VmDescriptor(Type.ANY_REF, s.substring(1, s.length() - 1));
    }

    throw new IllegalArgumentException("Invalid type descriptor: " + s);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VmDescriptor)) return false;
    VmDescriptor that = (VmDescriptor) o;
    return type == that.type &&
            Objects.equals(fqClassName, that.fqClassName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, fqClassName);
  }

  @Override
  public String toString() {
    switch (type) {
      case VOID:
        return "V";
      case BOOL:
        return "Z";
      case INT:
        return "I";
      case DOUBLE:
        return "D";
      case STRING:
        return "S";
      case ANY_REF:
        return "L" + fqClassName + ";";
      case FUNCTION:
        throw new RuntimeException("Invalid type " + type);
    }
    throw new RuntimeException("Invalid type " + type);
  }
}
