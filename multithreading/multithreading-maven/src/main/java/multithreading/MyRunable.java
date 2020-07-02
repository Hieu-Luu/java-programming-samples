package multithreading;

public class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("\n2. Implement Interfacae Runable \n" + "Name: "
                + Thread.currentThread().getName() + " Id: " + Thread.currentThread().getId() );

    }
}

   
