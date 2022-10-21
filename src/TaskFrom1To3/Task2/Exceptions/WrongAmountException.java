package TaskFrom1To3.Task2.Exceptions;

public class WrongAmountException extends Exception {
    public WrongAmountException(){
        super("Amount of these goods is wrong!");
    }
}
