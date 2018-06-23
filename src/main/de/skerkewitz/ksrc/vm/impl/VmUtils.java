package de.skerkewitz.ksrc.vm.impl;

public class VmUtils {

  private VmUtils() {
  }

  public static final Double doubleFromString(String value) {
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

  public static final Integer integerFromString(String value) {
    if (value == null) {
      return null;
    }

    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      // e.printStackTrace();
      return 0;
    }
  }

}
