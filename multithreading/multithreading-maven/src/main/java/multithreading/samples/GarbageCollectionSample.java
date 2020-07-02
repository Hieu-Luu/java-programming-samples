package multithreading.samples;

// Garbage collection is performed by a daemon thread called Garbage Collector(GC). 
// This thread calls the finalize() method before object is garbage collected.
// The Garbage collector of JVM collects only those objects that are created by new keyword. 
// So if you have created any object without new, you can use finalize method to perform cleanup processing (destroying remaining objects).
public class GarbageCollectionSample {
    public static void main(String[] args) {
        GarbageCollectionSample gc1 = new GarbageCollectionSample();
        GarbageCollectionSample gc2 = new GarbageCollectionSample();
        gc1 = null;
        gc2 = null;
        System.gc();
    }

    @Override
    public void finalize() {
        System.out.println("object is garbage collected");
    }
}