package de.skerkewitz.ksrc.vm;

/**
 * The heap is shared among all virtual machine threads. The heap is the run-time data area from which memory for all
 * class instances and arrays is allocated.
 */
public interface VmHeap {

  interface Ref {

    int getHeapAddress();

  }

  interface RefInstance extends Ref {
    VmClassInfo getVmClassInfo();
  }

  interface RefArray extends Ref {

  }

  RefInstance allocClass(VmClassInfo vmClassInfo);

  RefArray allocArray();

}
