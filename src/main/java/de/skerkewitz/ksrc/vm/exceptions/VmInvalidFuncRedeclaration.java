package de.skerkewitz.ksrc.vm.exceptions;

import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.vm.exceptions.VmRuntimeException;

public class VmInvalidFuncRedeclaration extends VmRuntimeException {
  public VmInvalidFuncRedeclaration(String functionName, SourceLocation srcLocation) {
    super("Invalid function redeclaration of '" + functionName + "' in " + srcLocation, srcLocation);
  }
}
