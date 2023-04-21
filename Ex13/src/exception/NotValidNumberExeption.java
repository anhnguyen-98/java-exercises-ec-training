package exception;

public class NotValidNumberExeption extends RuntimeException {

    public NotValidNumberExeption() {};

    public NotValidNumberExeption(String message) {
        super(message);
    }
}
