package exception;

public class BirthdayException extends RuntimeException{

    public BirthdayException() {};

    public BirthdayException(String message) {
        super(message);
    }
}
