package de.skerkewitz.ksrc.vm;

public class VmDefaultHeap implements VmHeap {

  private final Ref[] heap = new Ref[100];


  @Override
  public RefInstance allocClass(VmClassInfo vmClassInfo) {

    int i = getFreeSpot();

    RefInstance ref = new RefInstanceImp(i, vmClassInfo);
    heap[i] = ref;
    return ref;
  }

  private int getFreeSpot() {

    for(int i = 0; i < heap.length; ++i) {
      if (heap[i] == null) {
        return i;
      }
    }

    throw new OutOfMemoryError("KSrc VM out of memory");

  }

  @Override
  public RefArray allocArray() {
    int i = getFreeSpot();

    RefArray ref = new RefArrayImp(i);
    heap[i] = ref;
    return ref;
  }

  private static class BaseRef implements Ref {

    private final int heapAddress;

    private BaseRef(int heapAddress) {
      this.heapAddress = heapAddress;
    }

    @Override
    public int getHeapAddress() {
      return heapAddress;
    }
  }

  public static class RefInstanceImp extends BaseRef implements RefInstance {
    public final VmClassInfo vmClassInfo;

    private RefInstanceImp(int heapAddress, VmClassInfo vmClassInfo) {
      super(heapAddress);
      this.vmClassInfo = vmClassInfo;
    }

    public VmClassInfo getVmClassInfo() {
      return vmClassInfo;
    }
  }

  public static class RefArrayImp extends BaseRef implements RefArray {
    private RefArrayImp(int heapAddress) {
      super(heapAddress);
    }
  }


}
