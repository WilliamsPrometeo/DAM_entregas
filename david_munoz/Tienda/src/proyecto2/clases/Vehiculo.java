
package proyecto2.clases;

import enums.TipoVehiculo;

/**
 * La clase vehículo muestra los apartados del vehículo (matricula,modelo,Tipo ...) registra los métodos del main
 * mediante public voids y al final se encuentra el constructor Override. Los métodos en este caso son Registrar vehículos
 * Registrar servicios mecánicos
 * Asignar servicios a vehículos
 * Consultar vehículos registrados
 * Consultar servicios realizados
 * También se implementa el uso de getters and setters.
 *
 * @author David Muñoz @version Vehiculo
 */

public class Vehiculo {
    private static final MyScanner sc = new MyScanner();


    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    public static void Registrarvehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = TipoVehiculo.valueOf(tipoVehiculo);
    }

    @Override
    public String toString() {
        return matricula + modelo + tipoVehiculo.name();
    }
}
