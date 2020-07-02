package multithreading.samples;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DemoCountDownLatch {

    public CountDownLatch count = new CountDownLatch(2000);

    public static void main(String[] args) {
        DemoCountDownLatch demo = new DemoCountDownLatch();
        demo.count();
    }

    public void count() {
        Thread thread1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count.countDown();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    count.countDown();
                }
            }
        });

        thread1.start();
        thread2.start();
        try {
            count.await(5, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Count = " + count.getCount());
    }
}

class NonCounDownLatch {
    private int count = 2000;

    public static void main(String[] args) {
        NonCounDownLatch demo = new NonCounDownLatch();
        demo.count();
    }

    public void count(){
        Thread thread1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < 1000; i ++){
                    count--;
                }    
            }
        });

        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    count--;
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("count = " + count);
    }
}