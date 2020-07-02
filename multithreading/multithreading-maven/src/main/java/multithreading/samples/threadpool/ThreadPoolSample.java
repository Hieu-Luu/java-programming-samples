package multithreading.samples.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSample {

    public static void main(String[] args) {

        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);

        // Initilize a thread pool
        // corePoolSize = 5, during threadpool initialization, if the number of thread < corePoolSize, 
        // new thread will be created util reach corePoolSize value
        // maximumPoolSize = 5
        // keepAliveTime = 10s, after 10s if a thread still there is no task to do then it's destroyed
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, queue);
        for(int i = 0; i < 10; i++){
            executor.execute(new MyRunnale(i));
        }
    }
}

class MyRunnale implements Runnable {

    int id;

    @Override
    public void run() {
        System.out.println("Processing thread " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + id + " done");
    }

    public MyRunnale(int id) {
        this.id = id;
    }

}