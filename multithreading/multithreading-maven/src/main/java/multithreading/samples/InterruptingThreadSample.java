package multithreading.samples;

public class InterruptingThreadSample {
    public static void main(String[] args) {
        
        MyThread t1 = new MyThread();
        t1.setName("Thread-1");
        MyThread t2 = new MyThread();
        t2.setName("Thread-2");
        t1.start();
        t1.interrupt();
        t2.start();
    }

    static class MyThread extends Thread {
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 2; i++){
                if (Thread.interrupted()) {
                    System.out.println(name + " interrupted");
                }else {
                    System.out.println(name + " working " + i);
                }
            }
        }
    }
}