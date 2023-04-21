package exception;

public class FullNameException extends RuntimeException{

    public FullNameException() {};

    public FullNameException(String message) {
        super(message);
    }
}
