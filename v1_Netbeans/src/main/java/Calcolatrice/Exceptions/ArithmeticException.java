package Calcolatrice.Exceptions;

public class ArithmeticException extends RuntimeException {
    public ArithmeticException() {
        super();
    }

    public ArithmeticException(String msg) {
        super(msg);
    }
}
