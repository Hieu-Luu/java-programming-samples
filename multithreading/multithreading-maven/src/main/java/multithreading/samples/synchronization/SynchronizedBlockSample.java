package multithreading.samples.synchronization;

public class SynchronizedBlockSample {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                table.displayNumber(5);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                table.displayNumber(100);
            }
        };
        t1.start();
        t2.start();
    }

    static class Table {
        void displayNumber(int n) {
            // synchronized block
            synchronized (this) {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(n * i);
                    try {
                        Thread.sleep(400);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}