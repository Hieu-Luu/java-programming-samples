package multithreading.samples;

import multithreading.RunableShareBetweenThreads;

public class ShareAtributeBetweenThreadsSample {
    
    public static void main(String[] args) {
        RunableShareBetweenThreads shareRunable = new RunableShareBetweenThreads();
        Thread shareThread1 = new Thread(shareRunable);
        shareThread1.setName("Thread-share-1");
        shareThread1.start();

        Thread shareThread2 = new Thread(shareRunable);
        shareThread2.setName("Thread-share-2");
        shareThread2.start();

        Thread shareThread3 = new Thread(shareRunable);
        shareThread3.setName("Thread-share-3");
        shareThread3.start();

        System.out.println("value of shareVariable = " + shareRunable.getShareVariable());
    }
}