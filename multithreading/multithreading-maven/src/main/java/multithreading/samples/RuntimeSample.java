package multithreading.samples;

public class RuntimeSample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory : " + runtime.totalMemory());
        System.out.println("Free memory : " + runtime.freeMemory());

        for (int i = 0; i < 10000; i++){
            new RuntimeSample();
        }
        System.out.println("After initiate 10000 instances, Free memory : " + runtime.freeMemory());
        System.gc();
        System.out.println("After call gc(), Free memory : " + runtime.freeMemory());
    }
}