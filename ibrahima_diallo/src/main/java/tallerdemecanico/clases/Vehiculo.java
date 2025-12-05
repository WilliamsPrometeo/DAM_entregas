package tallerdemecanico.clases;

import tallerdemecanico.enums.TipoVehiculo;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Clase Vehiculo
 *
 * @author Alumno - Ibra
 * @version 1.0
 */

public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipovehiculo;

    /**
     *
     * @param matricula  atributo heredado
     * @param modelo  heredado
     * @param    tipoVehiculo  heredado
     * @see
     */
    public Vehiculo(String matricula, String modelo,  TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipovehiculo = tipovehiculo;
    }

    /**
     * Hago el constructor
     */

    public Vehiculo() {

    }

/**
 * Después del constructor vacio hago los métodos con getter y setter.
 *
 */


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

    public TipoVehiculo getTipovehiculo() {
        return tipovehiculo;
    }

    public void setGenero(TipoVehiculo tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }
    /**
     * Pongo el formato de la clase con el override.
     */


    @Override
    public String toString() {
        return String.format("Matricula: %s, Modelo: %s, Tipo de vehiculo: %s", this.matricula, this.modelo, this.tipovehiculo);

    }

    public void add(Vehiculo vehiculo) {

    }
}


