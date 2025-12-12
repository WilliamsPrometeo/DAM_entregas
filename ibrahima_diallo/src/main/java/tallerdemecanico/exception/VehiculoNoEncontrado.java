package tallerdemecanico.exception;
/**
 * Clase Vehiculo No encontrado
 *
 * @author Alumno - Ibra
 * @version 1.0
 */
public class VehiculoNoEncontrado extends RuntimeException {
    public VehiculoNoEncontrado(String message) {
        super(message);
    }
}
