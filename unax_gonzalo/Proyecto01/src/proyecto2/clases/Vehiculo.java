/**
 * Clase vehiculo
 * Autor: Lobo
 * Version 1.0
 */

package proyecto2.clases;

import recursos.TipoVehiculo;

public class Vehiculo { //clase publica vehiculo
    private static String matricula;
    private static String modelo;
    private static TipoVehiculo tipoVehiculo;

    public Vehiculo(String modelo, String matricula, TipoVehiculo tipoVehiculo) { //constructor
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    //getters and setters

    public static String getMatricula() {
        return matricula;
    }

    public static void setMatricula(String matricula) {
        Vehiculo.matricula = matricula;
    }

    public static String getModelo() {
        return modelo;
    }

    public static void setModelo(String modelo) {
        Vehiculo.modelo = modelo;
    }

    public static TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public static void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        Vehiculo.tipoVehiculo = tipoVehiculo;
    }

    @Override //override, declaramos el formato de la opcion mostrar vehiculos
    public String toString() {
        return String.format(
                "Vehiculo:\n\tModelo: %s\n\tMatricula: %s\n\tTipo: %s",
                this.modelo, this.matricula, this.tipoVehiculo);
    }
}