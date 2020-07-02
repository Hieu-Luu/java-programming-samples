package multithreading.samples;

public class SleepSample {
    
    public static void main(String[] args) {
        // Sample using sleep
        System.out.println("\nsleep() sample\n");
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread number " + i);
            if (i == 5) {
                System.out.println("Finish!");
            }
            final TestRunnable r = new TestRunnable();
            final Thread t = new Thread(r);
            t.start();
        }
    }
}

class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Sleep for 5000 millisecond");
        try {
            Thread.sleep(5000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}