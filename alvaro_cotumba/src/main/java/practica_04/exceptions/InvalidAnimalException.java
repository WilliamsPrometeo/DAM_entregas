package practica_04.exceptions;

public class InvalidAnimalException extends RuntimeException {
    public InvalidAnimalException(String message) {
        super(message);
    }
}
