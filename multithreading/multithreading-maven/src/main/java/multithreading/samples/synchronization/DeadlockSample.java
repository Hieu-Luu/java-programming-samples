package multithreading.samples.synchronization;

// Deadlock can occur in a situation when a thread is waiting for an object lock, that is acquired by 
// another thread and second thread is waiting for an object lock that is acquired by first thread. 
// Since, both threads are waiting for each other to release the lock, the condition is called deadlock.
public class DeadlockSample {
    public static void main(String[] args) {
        String resource1 = "resource 1";
        String resource2 = "resource 2";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locking " + resource1);
                }
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locking " + resource2);
                }
            }
        };
        t1.setName("Thread-1");
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locking " + resource2);
                }
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locking " + resource1);
                }
            }
        };
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }

}