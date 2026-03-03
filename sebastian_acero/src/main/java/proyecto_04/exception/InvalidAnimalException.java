package proyecto_04.exception;

public class InvalidAnimalException extends RuntimeException {
    public InvalidAnimalException(String message) {
        super(message);
    }
}
