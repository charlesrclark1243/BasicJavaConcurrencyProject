public class ThreadTest {
    private static final int STEPS = 100;
    private static final int DELAY = 10;
    private static final double MAX_AMOUNT = 5000;
    public static void main(String[] args) {
        int nAccounts = 4;
        double startAmount = 100000;

        Bank bank = new Bank(nAccounts, startAmount);

        Runnable taskOne = () -> {
            try {
                int fromIndex, toIndex;
                for (int step = 0; step < STEPS; step++) {
                    if (step % 2 == 0) {
                        fromIndex = 0;
                        toIndex = 1;
                    }
                    else {
                        fromIndex = 2;
                        toIndex = 0;
                    }

                    double amount = MAX_AMOUNT * Math.random();                    
                    bank.transfer(fromIndex, toIndex, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException interruptedException) {
                System.out.println(Thread.currentThread() + " interrupted");
            }
        };

        Runnable taskTwo = () -> {
            try {
                int fromIndex, toIndex;
                for (int step = 0; step < STEPS; step++) {
                    if (step % 2 == 0) {
                        fromIndex = 3;
                        toIndex = 2;
                    }
                    else {
                        fromIndex = 1;
                        toIndex = 3;
                    }

                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(fromIndex, toIndex, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException interruptedException) {
                System.out.println(Thread.currentThread() + " interrupted");
            }
        };

        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);

        threadOne.start();
        threadTwo.start();
    }
}
