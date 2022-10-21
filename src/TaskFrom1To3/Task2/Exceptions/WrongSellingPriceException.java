package TaskFrom1To3.Task2.Exceptions;

public class WrongSellingPriceException extends Exception {
    public WrongSellingPriceException(){
        super("Selling price of this good is wrong!");
    }
}
