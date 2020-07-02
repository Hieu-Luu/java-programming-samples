package multithreading;

public final class App {
    // Constructor
    private App() {
    }

    /**
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Demonstrate how to create a thread \n");
        ExtendsThreadClass myThread0 = new ExtendsThreadClass();
        myThread0.setName("Thread-0");
        myThread0.setPriority(1);
        myThread0.start();

        ExtendsThreadClass myThread1 = new ExtendsThreadClass();
        myThread1.setName("Thread-1");
        myThread1.setPriority(2);
        myThread1.start();

        ImplementRunableInterface runable0 = new ImplementRunableInterface();
        Thread thread0 = new Thread(runable0);
        thread0.setName("Thread-runable-0");
        thread0.setPriority(1);
        thread0.start();

        Thread thread1 = new Thread(runable0);
        thread1.setName("Thread-runable-1");
        thread1.setPriority(2);
        thread1.start();

        Thread thread2 = new Thread(runable0);
        thread2.setName("Thread-runable-2");
        thread2.setPriority(2);
        thread2.start();

    }
}
