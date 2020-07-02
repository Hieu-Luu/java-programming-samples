package multithreading.samples.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceSample {

    public static void main(String[] args) {

        // Creates an Executor that uses a single worker thread operating off an
        // unbounded queue. (Note however that if this single thread terminates due to a
        // failure during execution prior to shutdown, a new one will take its place if
        // needed to execute subsequent tasks.) Tasks are guaranteed to execute
        // sequentially, and no more than one task will be active at any given time.
        // Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor
        // is guaranteed not to be reconfigurable to use additional threads.
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleThreadPool.submit(new RunPool(i, "singleThreadPool-"));
        }

        try {
            // Blocks until all tasks have completed execution after a shutdown request, or
            // the timeout occurs, or the current thread is interrupted, whichever happens
            // first.
            singleThreadPool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        singleThreadPool.shutdown();

        // Creates a thread pool that creates new threads as needed, but will reuse
        // previously constructed threads when they are available. These pools will
        // typically improve the performance of programs that execute many short-lived
        // asynchronous tasks. Calls to execute will reuse previously constructed
        // threads if available. If no existing thread is available, a new thread will
        // be created and added to the pool. Threads that have not been used for sixty
        // seconds are terminated and removed from the cache. Thus, a pool that remains
        // idle for long enough will not consume any resources. Note that pools with
        // similar properties but different details (for example, timeout parameters)
        // may be created using ThreadPoolExecutor constructors.
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.submit(new RunPool(i, "cachedThreadPool-"));
        }
        try {
            cachedThreadPool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cachedThreadPool.shutdown();

        // If there is a new tasks, but all threads in ThreadPool are busy, these tasks
        // will be put to Blocking Queue
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.submit(new RunPool(i, "newFixedThreadPool-"));
        }

        try {
            fixedThreadPool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fixedThreadPool.shutdown();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        // A delayed result-bearing action that can be cancelled. Usually a scheduled
        // future is the
        // result of scheduling a task with a ScheduledExecutorService.
        ScheduledFuture<?> beepHandler = scheduledThreadPool.scheduleAtFixedRate(new Beep(), 2, 2, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                beepHandler.cancel(true);
                scheduledThreadPool.shutdown();
            }
        }, 10, TimeUnit.SECONDS);

        // Creates a single-threaded executor that can schedule commands to run after a
        // given delay, or to execute periodically. (Note however that if this single
        // thread terminates due to a failure during execution prior to shutdown, a new
        // one will take its place if needed to execute subsequent tasks.) Tasks are
        // guaranteed to execute sequentially, and no more than one task will be active
        // at any given time. Unlike the otherwise equivalent newScheduledThreadPool(1,
        // threadFactory) the returned executor is guaranteed not to be reconfigurable
        // to use additional threads.
        ScheduledExecutorService singleScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 10; i++) {
            RunPool pool = new RunPool(i, "SingleThreadScheduledExecutor-");
            ScheduledFuture<?> handler = singleScheduledThreadPool.scheduleAtFixedRate(pool, 0, 2, TimeUnit.SECONDS);
            singleScheduledThreadPool.schedule(new Runnable(){
            
                @Override
                public void run() {
                    // handler.cancel(true);
                    // singleScheduledThreadPool.shutdown();
                }
            }, 4, TimeUnit.SECONDS);
        }

    }
}

class RunPool implements Runnable {

    int id;
    String name;

    @Override
    public void run() {
        System.out.println("Processing thread " + name + id);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + id + " done");
    }

    public RunPool(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

class Beep implements Runnable {
    public void run() {
        System.out.println("beep");
    }
}