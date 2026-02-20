package proyecto4.exceptions;

public class InvalidAnimalException extends RuntimeException {
    public InvalidAnimalException(String message) {
        super(message);
    }
}
