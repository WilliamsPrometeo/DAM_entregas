package taller_mecanico.excepcion;

public class VehiculoNoEncontrado extends RuntimeException {
    public VehiculoNoEncontrado(String message) {
        super(message);
    }
}
