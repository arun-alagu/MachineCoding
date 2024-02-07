package exceptions;

public class InvalidSymbolException extends Exception{
    public InvalidSymbolException() {
        super("Symbol chosen by the user was already taken!!");
    }

    public InvalidSymbolException(String message) {
        super(message);
    }
}
