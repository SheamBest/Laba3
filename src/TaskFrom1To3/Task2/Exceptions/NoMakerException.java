package TaskFrom1To3.Task2.Exceptions;

public class NoMakerException extends Exception {
    public NoMakerException() {
        super("There are no maker in goods!");
    }
}
