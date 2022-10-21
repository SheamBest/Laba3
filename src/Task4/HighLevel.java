package Task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HighLevel {
    public static void main(final String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(()->Calculations.sum(5,6));
        executor.submit(()->Calculations.sub(7,8));
        executor.submit(()->Calculations.mul(9,6));
        executor.submit(()->Calculations.div(4,2));

        try{
            executor.shutdown();
        } catch (final Exception e){
            executor.shutdown();
        } finally {
            executor.shutdownNow();
        }
    }
}
