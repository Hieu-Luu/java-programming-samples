package multithreading.samples.synchronization;

import java.util.Scanner;

public class StaticSynchronizedSample {

    // Chua hieu
    public static void main(String[] args) {

        // String a = "";
        // Scanner sc = new Scanner(System.in);
        // do {
        //     System.out.println("Choose options:" + " \n1-Static Synchronized"
        //             + "\n2-Non-Static Synchronized");
        //     a = sc.nextLine();
        //     switch (a) {
        //         case "1":
        //             StaticSynchronized();
        //             break;
        //         case "2":
        //             nonStaticSynchronized();
        //             break;
        //         default:
        //     }

        // } while (!a.equals("x"));
        // sc.close();
        
        Thread t1 = new Thread() {
            public void run() {
                Table.displayNumber(1);
            }
        };
        t1.setName("Static sync Thread-1");
        Thread t2 = new Thread() {
            public void run() {
                Table.displayNumber(10);
            }
        };
        t2.setName("Static sync Thread-2");
        Thread t3 = new Thread() {
            public void run() {
                Table.displayNumber(100);
            }
        };
        t3.setName("Static sync Thread-3");
        Thread t4 = new Thread() {
            public void run() {
                Table.displayNumber(1000);
            }
        };
        t4.setName("Static sync Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static void StaticSynchronized() {
        Thread t1 = new Thread() {
            public void run() {
                Table.displayNumber(1);
            }
        };
        t1.setName("Static sync Thread-1");
        Thread t2 = new Thread() {
            public void run() {
                Table.displayNumber(10);
            }
        };
        t2.setName("Static sync Thread-2");
        Thread t3 = new Thread() {
            public void run() {
                Table.displayNumber(100);
            }
        };
        t3.setName("Static sync Thread-3");
        Thread t4 = new Thread() {
            public void run() {
                Table.displayNumber(1000);
            }
        };
        t4.setName("Static sync Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    // static void nonStaticSynchronized() {
    //     Board board = new Board();
    //     Thread t1 = new Thread() {
    //         public void run() {
    //             board.displayNumber(1);
    //         }
    //     };
    //     t1.setName("Non-static sync Thread-1");
    //     Thread t2 = new Thread() {
    //         public void run() {
    //             board.displayNumber(10);
    //         }
    //     };
    //     t2.setName("Non-static sync Thread-2");
    //     Thread t3 = new Thread() {
    //         public void run() {
    //             board.displayNumber(100);
    //         }
    //     };
    //     t3.setName("Non-static sync Thread-3");

    //     Thread t4 = new Thread() {
    //         public void run() {
    //             board.displayNumber(1000);
    //         }
    //     };
    //     t4.setName("Non-static sync Thread-4");

    //     t1.start();
    //     t2.start();
    //     t3.start();
    //     t4.start();
    // }
}

class Table {
    synchronized static void displayNumber(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Board {
    synchronized void displayNumber(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}