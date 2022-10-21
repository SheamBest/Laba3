package Task4;

public class LowLevel {
    public static void main(final String[] args) {
        final Thread thread1 = new Thread(new SimpleRunnable1());
        final Thread thread2 = new Thread(new SimpleRunnable2());
        final Thread thread3 = new Thread(new SimpleRunnable3());
        final Thread thread4 = new Thread(new SimpleRunnable4());


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public static class SimpleRunnable1 implements Runnable{
        @Override
        public void run() {
            Calculations.sum(5, 6);
        }
    }

    public static class SimpleRunnable2 implements Runnable{
        @Override
        public void run() {
            Calculations.sub(7, 8);
        }
    }

    public static class SimpleRunnable3 implements Runnable{
        @Override
        public void run() {
            Calculations.mul(9, 6);
        }
    }

    public static class SimpleRunnable4 implements Runnable{
        @Override
        public void run() {
            Calculations.div(4, 2);
        }
    }
}
