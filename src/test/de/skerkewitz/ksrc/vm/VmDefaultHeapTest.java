package de.skerkewitz.ksrc.vm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VmDefaultHeapTest {

  @Test
  void allocClass() {

    VmDefaultHeap sut = new VmDefaultHeap();

    VmClassInfo vmClassInfo = new VmClassInfo("TestClass");


    VmHeap.RefInstance ref = sut.allocClass(vmClassInfo);

    assertNotNull(ref);
    assertEquals(0, ref.getHeapAddress());
    assertEquals(1, sut.allocClass(vmClassInfo).getHeapAddress());
    assertEquals(2, sut.allocClass(vmClassInfo).getHeapAddress());

    assertEquals("TestClass", ref.getVmClassInfo().fqThisClassName);
  }

  @Test
  void allocArray() {

    VmDefaultHeap sut = new VmDefaultHeap();

    VmHeap.RefArray ref = sut.allocArray();

    assertNotNull(ref);
    assertEquals(0, ref.getHeapAddress());
    assertEquals(1, sut.allocArray().getHeapAddress());
    assertEquals(2, sut.allocArray().getHeapAddress());
  }
}