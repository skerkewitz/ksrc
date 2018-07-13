package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VmDescriptorTest {

  @Test
  void testToString() {

    assertEquals("S", new VmDescriptor(Type.STRING, null).toString());
    assertEquals("I", new VmDescriptor(Type.INT, null).toString());
    assertEquals("D", new VmDescriptor(Type.DOUBLE, null).toString());
    assertEquals("LSomeCoolClass;", new VmDescriptor(Type.ANY_REF, "SomeCoolClass").toString());
  }

  @Test
  void testFromString() {

    final VmDescriptor stringDescriptor = VmDescriptor.fromString("S");
    assertEquals(Type.STRING, stringDescriptor.type);
    assertNull(stringDescriptor.fqClassName);

    VmDescriptor intFieldDescriptor = VmDescriptor.fromString("I");
    assertEquals(Type.INT, intFieldDescriptor.type);
    assertNull(intFieldDescriptor.fqClassName);

    VmDescriptor doubleFieldDescriptor = VmDescriptor.fromString("D");
    assertEquals(Type.DOUBLE, doubleFieldDescriptor.type);
    assertNull(doubleFieldDescriptor.fqClassName);

    VmDescriptor classFieldDescriptor = VmDescriptor.fromString("LSomeCoolClass;");
    assertEquals("SomeCoolClass", classFieldDescriptor.fqClassName);
    assertEquals(Type.ANY_REF, classFieldDescriptor.type);
  }

  @Test
  void equals() {
    assertEquals(new VmDescriptor(Type.STRING, null), VmDescriptor.fromString("S"));
    assertEquals(new VmDescriptor(Type.INT, null), VmDescriptor.fromString("I"));
    assertEquals(new VmDescriptor(Type.DOUBLE, null), VmDescriptor.fromString("D"));
    assertEquals(new VmDescriptor(Type.ANY_REF, "SomeCoolClass"), VmDescriptor.fromString("LSomeCoolClass;"));
  }

}