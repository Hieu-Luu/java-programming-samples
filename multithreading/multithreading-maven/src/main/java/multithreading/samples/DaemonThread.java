package multithreading.samples;

import java.util.Scanner;

// It provides services to user threads for background supporting tasks. 
// It has no role in life than to serve user threads.
// Its life depends on user threads.
// It is a low priority thread.

public class DaemonThread {
    public static void main(String[] args) {
      
        String a = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choose options:" + " \n1-Start Deamon thread without user thread"
                + "\n2-Start Deamon thread with user threads");
            a = sc.nextLine();
            switch(a){
                case "1":
                    startDeamonThreadWithNoUserThread();
                break;
                case "2":
                    startDeamonThreadWithUserThread();
                break;
                default:
            }

        } while (!a.equals("x"));
        sc.close();
    }

    static void startDeamonThreadWithNoUserThread() {
        MyDeamonThread t1 = new MyDeamonThread();
        t1.setDaemon(true);
        t1.start();
    }

    static void startDeamonThreadWithUserThread() {
        MyDeamonThread t1 = new MyDeamonThread();
        MyDeamonThread t2 = new MyDeamonThread();
        MyDeamonThread t3 = new MyDeamonThread();

        t1.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyDeamonThread extends Thread {

    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("This is daemon thread");
        } else {
            System.out.println("This is user thread");
        }
    }

}