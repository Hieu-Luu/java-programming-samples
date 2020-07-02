package multithreading.samples;

// if a thread is processing, other threads must wait until this thread finish
// join() can be used in case there are many thread in a program and we need some thread be executed
// in order they was started.
public class JoinSample {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        thread1.setName("Non-join thread 1");
        MyThread thread2 = new MyThread();
        thread2.setName("Non-join thread 2");
        MyThread thread3 = new MyThread();
        thread3.setName("Non-join thread 3");

        thread1.start();
        thread2.start();
        thread3.start();


        MyThread thread01 = new MyThread();
        thread01.setName("join thread 1");
        MyThread thread02 = new MyThread();
        thread02.setName("join thread 2");
        MyThread thread03 = new MyThread();
        thread03.setName("join thread 3");

        thread01.start();
        try{
            thread01.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread02.start();
        try{
            thread02.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread03.start();
        try{
            thread03.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + " is running...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish " + Thread.currentThread().getName());
    }

}