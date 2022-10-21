package Task4;

public class Calculations {
    public static void sum(final int a, final int b){
        System.out.println("sum started");
        System.out.println("a + b = " + (a + b));
        try {
            Thread.sleep(1000);
        } catch (final InterruptedException e){
            System.out.println("Interrupted exception");
        }
        System.out.println("sum finished");
    }

    public static void sub(final int a, final int b){
        System.out.println("sub started");
        System.out.println("a - b = " + (a - b));
        try {
            Thread.sleep(1001);
        } catch (final InterruptedException e){
            System.out.println("Interrupted exception");
        }
        System.out.println("sub finished");
    }

    public static void mul(final int a, final int b){
        System.out.println("mul started");
        System.out.println("a * b = " + (a * b));
        try {
            Thread.sleep(1002);
        } catch (final InterruptedException e){
            System.out.println("Interrupted exception");
        }
        System.out.println("mul finished");
    }

    public static void div(final int a, final int b){
        System.out.println("div started");
        if (b != 0) {
            System.out.println("a / b = " + (a / b));
        } else {
            System.out.println("Error: division by zero is not allowed!");
        }

        try {
            Thread.sleep(999);
        } catch (final InterruptedException e){
            System.out.println("Interrupted exception");
        }
        System.out.println("div finished");
    }

}
