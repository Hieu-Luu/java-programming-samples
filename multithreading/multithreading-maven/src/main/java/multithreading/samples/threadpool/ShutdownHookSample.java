package multithreading.samples.threadpool;

public class ShutdownHookSample {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new MyThread());
        System.out.println("Now main is sleeping... press ctrl+c to exit");
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("shut down hook task completed..");
        }
    }
}
