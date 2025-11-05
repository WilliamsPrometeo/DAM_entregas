package src.tienda;

public class PrecioNegativoException extends RuntimeException {
    public PrecioNegativoException(String message) {
        super(message);
    }
}
