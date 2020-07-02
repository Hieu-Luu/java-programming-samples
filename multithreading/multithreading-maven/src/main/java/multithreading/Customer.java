package multithreading;

public class Customer {

    private int balance = 10000;

    public Customer() {
        System.out.println("Account Balance: " + balance + "$");
    }

    public synchronized void withdraw(int amount) {
        System.out.println("Withdraw Transaction is processing," + " amount = " + amount + "...");
        if (balance < amount) {
            System.out.println("Balace is not enough!");
            try {
                // Causes the current thread to wait until it is awakened, typically by being
                // notified or interrupted
                wait();
            } catch (InterruptedException exception) {
                System.out.println(exception.toString());
            }
        }
        balance -= amount;
        System.out.println("withdraw sucessfully, balance = " + balance);
    }

    public synchronized void deposit(int amount) {
        System.out.println("Deposit Transaction is processing," + " amount = " + amount + "...");
        balance += amount;
        System.out.println("Deposit Successfull, balance = " + balance);
        notify();
    }

}