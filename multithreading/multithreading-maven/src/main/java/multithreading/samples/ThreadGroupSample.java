package multithreading.samples;

// Java provides a convinient way to group multiple threads in a single object. In such way, we can suspend
// resume or interrupt group of threas by a single method call
public class ThreadGroupSample {
    public static void main(String[] args) {
        MyGroupThreadDemo r = new MyGroupThreadDemo();
        ThreadGroup tg = new ThreadGroup("Parent group");

        Thread t1 = new Thread(tg, r, "one");
        t1.start();
        Thread t2 = new Thread(tg, r, "two");
        t2.start();
        Thread t3 = new Thread(tg, r, "three");
        t3.start();

        System.out.println("Thread Group Name: " + tg.getName());
        tg.list();
    }
}

class MyGroupThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    
}