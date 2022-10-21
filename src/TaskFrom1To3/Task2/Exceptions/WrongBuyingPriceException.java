package TaskFrom1To3.Task2.Exceptions;

public class WrongBuyingPriceException extends Exception {
    public WrongBuyingPriceException(){
        super("Buying price of this good is wrong!");
    }
}
