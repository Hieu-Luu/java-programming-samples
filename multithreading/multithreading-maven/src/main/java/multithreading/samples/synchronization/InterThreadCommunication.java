package multithreading.samples.synchronization;

public class InterThreadCommunication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMsg("message 1");
        Waiter waiter = new Waiter(message);
        new Thread(waiter, "Waiter thread-1").start();

        Waiter waiter2 = new Waiter(message);
        new Thread(waiter2, "Waiter thread-2").start();

        Notifier notifier1 = new Notifier(message);
        new Thread(notifier1, "Notifier thread-1").start();

        // message.setMsg("message 2");
        // Notifier notifier2 = new Notifier(message);
        // new Thread(notifier2, "Notifier thread-2").start();

    }
}

class Message {
    private String msg;

    public Message() {
    }

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " waiting to get notification at time : " + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " waiter thread got notification at time : " + System.currentTimeMillis());
            System.out.println(name + " received message from " + msg.getMsg());
        }

    }

}

class Notifier implements Runnable {
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started, processing " +  msg.getMsg());
        try {
            Thread.sleep(10000);
            synchronized (msg) {
                String message = name + " " + msg.getMsg();
                msg.setMsg(message);
                msg.notify();
                // msg.notifyAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}