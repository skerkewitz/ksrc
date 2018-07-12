package de.skerkewitz.ksrc.vm.impl;

import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.VmClassInfo;
import de.skerkewitz.ksrc.vm.VmFieldInfo;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VmClassInstance {

  public final Map<String, Vm.Value> fields;
  public final VmClassInfo classInfo;

  public VmClassInstance(VmClassInfo classInfo) {
    this.classInfo = classInfo;

    fields = new HashMap<>();
    for (var f : classInfo.fields) {
      fields.put(f.name, VmDescriptor.Int.type.getDefault_init_value());
    }

  }

  public void setFieldValue(String fieldname, Vm.Value value) {
    Optional<VmFieldInfo> fieldInfo = classInfo.getFieldByName(fieldname);
    if (!fieldInfo.isPresent()) {
      throw new RuntimeException("Class " + classInfo.fqThisClassName + " has no field " + fieldname);
    }

    fields.put(fieldname, value);
  }

  public Vm.Value getFieldValue(String fieldname) {
    Optional<VmFieldInfo> fieldInfo = classInfo.getFieldByName(fieldname);
    if (!fieldInfo.isPresent()) {
      throw new RuntimeException("Class " + classInfo.fqThisClassName + " has no field " + fieldname);
    }

    return fields.get(fieldname);
  }
}
