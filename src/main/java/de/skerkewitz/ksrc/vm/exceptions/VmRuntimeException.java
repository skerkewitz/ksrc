package de.skerkewitz.ksrc.vm.exceptions;

import de.skerkewitz.ksrc.common.SourceLocation;

public class VmRuntimeException extends RuntimeException {
  public final SourceLocation sourceLocation;

  public VmRuntimeException(String message, SourceLocation sourceLocation) {
    super(message + " at " + sourceLocation);
    this.sourceLocation = sourceLocation;
  }
}
