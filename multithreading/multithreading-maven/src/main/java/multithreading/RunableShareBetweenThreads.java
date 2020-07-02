package multithreading;

public class RunableShareBetweenThreads implements Runnable {

    private int shareVariable = 0;

    public int getShareVariable() {
        return shareVariable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("3. Share attribute between threads" 
                    + ", Name: " + Thread.currentThread().getName() 
                    + ",ID:" + Thread.currentThread().getId() 
                    + ", shareVariable = " + shareVariable);
            shareVariable += 2;
        }
    }
    

}