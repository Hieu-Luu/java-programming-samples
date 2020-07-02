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

        System.out.println("1. Extends class Thread \n" + "Thread info: \n" + "Name: "
                + Thread.currentThread().getName() + "\n" + "Id: " + Thread.currentThread().getId() + "\n"
                + "Priority: " + Thread.currentThread().getPriority());

    }

}