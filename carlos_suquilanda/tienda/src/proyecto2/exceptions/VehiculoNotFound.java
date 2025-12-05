package proyecto2.exceptions;

/**
 * Este es el error que hace que duando no se encuentre un vehiculo nos deje poner un mensaje.
 */
public class VehiculoNotFound extends Exception {
    public VehiculoNotFound(String message) {
        super(message);
    }
}
