package exception;

public class EmailException extends RuntimeException{

    public EmailException() {};

    public EmailException(String message) {
        super(message);
    }
}
