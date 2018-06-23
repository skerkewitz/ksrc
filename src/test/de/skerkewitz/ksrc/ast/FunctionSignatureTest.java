package de.skerkewitz.ksrc.ast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionSignatureTest {

  @Test
  void simpleTest() {

    {
      Type[] types = { Type.STRING };
      FunctionSignature sig = new FunctionSignature(Type.VOID, types);
      assertEquals("(STRING):(VOID)", sig.toString());
    }

    {
      Type[] types = { Type.STRING, Type.INT };
      FunctionSignature sig = new FunctionSignature(Type.VOID, types);
      assertEquals("(STRING,INT):(VOID)", sig.toString());
    }


  }
}