package de.skerkewitz.ksrc.vm.exceptions;

import de.skerkewitz.ksrc.antlr.SourceLocation;

public class VmRuntimeException extends RuntimeException {
  public final SourceLocation sourceLocation;

  public VmRuntimeException(String message, SourceLocation sourceLocation) {
    super(message);
    this.sourceLocation = sourceLocation;
  }
}
