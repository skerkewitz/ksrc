package de.skerkewitz.ksrc.sil

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SilTypeTest {

  @Test
  fun toSilString() {

    assertEquals("\$BuildIn.Int32", SilType("BuildIn.Int32").toSilString())
    assertEquals("\$*BuildIn.Int32", SilType("BuildIn.Int32", pointer = true).toSilString())

  }
}