package multithreading;

public class ImplementRunableInterface extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("\n2. Implement Interfacae Runable \n");
        System.out.println("1. Extends class Thread \n" + "Thread info: \n" + "Name: "
                + Thread.currentThread().getName() + "\n" + "Id: " + Thread.currentThread().getId() + "\n"
                + "Priority: " + Thread.currentThread().getPriority());

    }

}