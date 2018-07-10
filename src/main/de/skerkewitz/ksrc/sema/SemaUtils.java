package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

import java.util.List;

public class SemaUtils {
  public static Vm.Function expectExactlyOneFunctionMatch(List<Vm.Function> matches, String functionName, List<VmDescriptor> parameterDescriptors) {
    if (matches.isEmpty()) {
      throw new VmRuntimeException("Can not find suitable function '" + functionName + "' with parameter '" + parameterDescriptors + "'", null);
    }

    if (matches.size() > 1) {
      throw new VmRuntimeException("Ambiguous function call of function '" + functionName + "' with parameter '" + parameterDescriptors + "'. Found possible matches: " + matches, null);
    }

    return matches.get(0);
  }
}
