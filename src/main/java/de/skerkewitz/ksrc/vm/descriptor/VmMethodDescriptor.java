package de.skerkewitz.ksrc.vm.descriptor;

import de.skerkewitz.ksrc.parse.ast.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A method descriptor contains zero or more parameter descriptors, representing the types of parameters that the
 * method takes, and a return descriptor, representing the descriptor of the value (if any) that the method returns.
 */
public class VmMethodDescriptor {

  public final VmDescriptor returnDescriptor;
  public final List<VmDescriptor> parameterDescriptor;

  public VmMethodDescriptor(VmDescriptor returnDescriptor, List<VmDescriptor> parameterDescriptor) {
    this.returnDescriptor = returnDescriptor;
    this.parameterDescriptor = parameterDescriptor;
  }

  public static VmMethodDescriptor fromString(String s) {

    int paramStart = s.indexOf('(');
    int paramEnd = s.lastIndexOf(')');

    final VmDescriptor returnDescriptor = VmDescriptor.fromString(s.substring(paramEnd + 1));

    String paramStr = s.substring(paramStart + 1, paramEnd);
    final List<VmDescriptor> parameterDescriptors = new ArrayList<>();
    while (!paramStr.isEmpty()) {
      VmDescriptor next = getNextDescriptorFromString(paramStr);
      paramStr = paramStr.substring(next.toString().length());
      parameterDescriptors.add(next);
    }

    return new VmMethodDescriptor(returnDescriptor, parameterDescriptors);
  }

  private static VmDescriptor getNextDescriptorFromString(String paramStr) {
    char c = paramStr.charAt(0);

    if (c == 'V') {
      return new VmDescriptor(Type.VOID, null);
    }
    if (c == 'Z') {
      return new VmDescriptor(Type.BOOL, null);
    }

    if (c == 'I') {
      return new VmDescriptor(Type.INT, null);
    }

    if (c == 'D') {
      return new VmDescriptor(Type.DOUBLE, null);
    }

    if (c == 'S') {
      return new VmDescriptor(Type.STRING, null);
    }

    if (c == 'L') {
      int end = paramStr.indexOf(";");
      return new VmDescriptor(Type.ANY_REF, paramStr.substring(1, end));
    }

    throw new IllegalArgumentException("Can not parse '" + paramStr + "'");
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");

    for (var descriptor: parameterDescriptor) {
      stringBuilder.append(descriptor.toString());
    }

    stringBuilder.append(")");

    stringBuilder.append(returnDescriptor.toString());
    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VmMethodDescriptor)) return false;
    VmMethodDescriptor that = (VmMethodDescriptor) o;
    return Objects.equals(returnDescriptor, that.returnDescriptor) &&
            Objects.equals(parameterDescriptor, that.parameterDescriptor);
  }

  @Override
  public int hashCode() {

    return Objects.hash(returnDescriptor, parameterDescriptor);
  }
}
