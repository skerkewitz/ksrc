package de.skerkewitz.ksrc.vm.exceptions;

public class VmUtils {

  private VmUtils() {
  }

  public static final Double convertStringToNumber(String value) {
    if (value == null) {
      return null;
    }

    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      // e.printStackTrace();
      return 0.0;
    }
  }

}
