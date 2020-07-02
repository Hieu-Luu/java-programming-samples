package multithreading.samples.synchronization;

import multithreading.Customer;

class SynchronizedMethodSample {

    public static void main(final String[] args) {

        Customer customer = new Customer();

        final Thread thread1 = new Thread() {
            public void run() {
                // synchronized method
                customer.withdraw(20000);
            }
        };
        thread1.start();

        final Thread thread3 = new Thread() {
            public void run() {
                // synchronized method
                customer.withdraw(2000);
            }
        };
        thread3.start();

        final Thread thread4 = new Thread() {
            public void run() {
                customer.withdraw(2000);
            }
        };
        thread4.start();

        Thread thread2 = new Thread() {

            public void run() {
                customer.deposit(30000);
            }
        };
        thread2.start();
    }
}
