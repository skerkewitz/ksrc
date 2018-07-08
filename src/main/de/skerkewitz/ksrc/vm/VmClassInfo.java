package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;
import de.skerkewitz.ksrc.vm.descriptor.VmMethodDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/** Defines a class. */
public class VmClassInfo {

    // REF_getField         getfield C.f:T
    // REF_getStatic        getstatic C.f:T
    // REF_putField         putfield C.f:T
    // REF_putStatic        putstatic C.f:T
    // REF_invokeVirtual    invokevirtual C.m:(A*)T
    // REF_invokeStatic     invokestatic C.m:(A*)T
    // REF_invokeSpecial    invokespecial C.m:(A*)T
    // REF_newInvokeSpecial new C; dup; invokespecial C.<init>:(A*)void
    // REF_invokeInterface  invokeinterface C.m:(A*)T

  public final String fqThisClassName;

  public List<VmFieldInfo> fields = new ArrayList<>();
  public List<VmMethodInfo> methods = new ArrayList<>();

  public VmClassInfo(String fqThisClassName) {
    this.fqThisClassName = fqThisClassName;
  }


  @Override
  public String toString() {
    return "VmClassInfo{" +
            "className='" + fqThisClassName + '\'' +
            ", fields=" + fields +
            ", methods=" + methods +
            '}';
  }

  public List<VmMethodInfo> findMatchesByFunctionNameWithArgs(String functionName, List<VmDescriptor> argumentsDescriptor) {

    return methods.stream()
            .filter(vmMethodInfo -> vmMethodInfo.name.equals(functionName))
            .filter(vmMethodInfo -> vmMethodInfo.descriptor.parameterDescriptor.equals(argumentsDescriptor))
            .collect(Collectors.toList());
  }

  public Optional<VmMethodInfo> findMatchesByFunctionNameAndMethodDescriptor(String functionName, VmMethodDescriptor methodDescriptor) {
    return methods.stream()
            .filter(vmMethodInfo -> vmMethodInfo.name.equals(functionName))
            .filter(vmMethodInfo -> vmMethodInfo.descriptor.equals(methodDescriptor))
            .findFirst();
  }
}
