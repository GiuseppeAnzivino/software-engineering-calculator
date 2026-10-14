package Calcolatrice.Exceptions;

public class OverflowException extends RuntimeException {
    public OverflowException() {
        super();
    }

    public OverflowException(String msg) {
        super(msg);
    }
}
