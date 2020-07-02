package multithreading.samples;

import multithreading.ExtendsThreadClass;
import multithreading.MyRunable;

public class CreateThreadSample {
    // Constructor
    private CreateThreadSample() {
    }

    /**
     * 
     * @param args The arguments of the program.
     */
    public static void main(final String[] args) {
        System.out.println("Demonstrate how to create a thread \n");
        final ExtendsThreadClass myThread1 = new ExtendsThreadClass();
        myThread1.setName("Thread-1");
        myThread1.start();

        final ExtendsThreadClass myThread2 = new ExtendsThreadClass();
        myThread2.setName("Thread-2");
        myThread2.start();

        final ExtendsThreadClass myThread3 = new ExtendsThreadClass();
        myThread3.setName("Thread-3");
        myThread3.start();

        final MyRunable runable1 = new MyRunable();
        final Thread thread1 = new Thread(runable1);
        thread1.setName("Thread-runable-1");
        thread1.start();

        final MyRunable runable2 = new MyRunable();
        final Thread thread2 = new Thread(runable2);
        thread2.setName("Thread-runable-2");
        thread2.start();

        final MyRunable runable3 = new MyRunable();
        final Thread thread3 = new Thread(runable3);
        thread3.setName("Thread-runable-3");
        thread3.start();

    }
}