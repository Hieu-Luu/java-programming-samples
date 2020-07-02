package multithreading;

/**
 * Demonstrate how to create a thread
 */
public class ExtendsThreadClass extends Thread {

    @Override
    public void run() {
        super.run();
        // Print thread info
        // the name, priority can be changed

        System.out.println("1. Extend class Thread \n" + "Name: "
        + Thread.currentThread().getName() + " Id: " + Thread.currentThread().getId());

    }

}