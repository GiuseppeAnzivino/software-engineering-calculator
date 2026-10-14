package Calcolatrice.Exceptions;

public class InputException extends RuntimeException {
    public InputException() {
        super();
    }

    public InputException(String msg) {
        super(msg);
    }
}
