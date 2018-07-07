package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.Type;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VmMethodDescriptorTest {

  @Test
  void testFromString() {

    VmMethodDescriptor sut = VmMethodDescriptor.fromString("(IDLjava.lang.Thread;)Ljava.lang.Object;");

    assertEquals(sut.returnDescriptor, new VmDescriptor(Type.ANY_REF, "java.lang.Object"));

  }

  @Test
  void testToString() {

    VmDescriptor returnDescriptor = new VmDescriptor(Type.ANY_REF, "java.lang.Object");
    List<VmDescriptor> parameterDescriptors = List.of(
        new VmDescriptor(Type.INT, null),
        new VmDescriptor(Type.DOUBLE, null),
        new VmDescriptor(Type.ANY_REF, "java.lang.Thread")
      );

    VmMethodDescriptor sut = new VmMethodDescriptor(returnDescriptor, parameterDescriptors);

    assertEquals("(IDLjava.lang.Thread;)Ljava.lang.Object;", sut.toString());
  }
}