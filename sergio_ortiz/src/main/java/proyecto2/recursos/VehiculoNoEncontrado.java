package proyecto2.recursos;

public class VehiculoNoEncontrado extends RuntimeException {
    public VehiculoNoEncontrado(String message) {
        super("Vehiculo no encontrado: " + message);
    }
}
