package multithreading.samples;

public class PrioritySample {
    public static void main(String[] args) {
        MyPriorityThread thread1 = new MyPriorityThread();
        MyPriorityThread thread2 = new MyPriorityThread();
        MyPriorityThread thread3 = new MyPriorityThread();

        thread1.setName("Thread1");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setName("Thread2");
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setName("Thread3");
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

 class MyPriorityThread extends Thread {

    @Override
    public void run() {
        System.out.println("running thread name is:"
                + Thread.currentThread().getName());
        System.out.println("running thread priority is:"
                + Thread.currentThread().getPriority());
    }
    
}