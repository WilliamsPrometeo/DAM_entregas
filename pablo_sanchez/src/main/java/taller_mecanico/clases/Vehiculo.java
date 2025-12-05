package taller_mecanico.clases;

import taller_mecanico.enums.TipoServicio;
import taller_mecanico.enums.TipoVehiculo;

/**
 * Clase Vehiculo
 * @author Pablo Sánchez
 * @version 1.0
 */

public class Vehiculo {

    String matricula;
    String modelo;
    TipoVehiculo tipoVehiculo;

    /**
     * Constructor vacio de la clase vehiculo
     * @param matricula
     * @param modelo
     * @param tipoServicio
     */

    public Vehiculo(String matricula, String modelo, TipoServicio tipoServicio) {
    }

    /**
     * Constructor vacio de la clase vehiculo
     */

    public Vehiculo() {
    }

    /**
     * Constructor principal de la clase vehiculo
     * @param matricula
     * @param modelo
     * @param tipoVehiculo
     */

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Getter del atributo Matricula
     *
     * @return matriculas de vehiculos
     */

    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param matricula que establece las matriculas de los vehisuclos
     */

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo Modelo
     *
     * @return modelos de vehiculos
     */

    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param modelo que establece los modelos de los vehiculos que hay
     */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo Tipo
     *
     * @return tipos disponibles mediante un enum
     */

    public TipoVehiculo getTipo() {
        return tipoVehiculo;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param tipo que establece los tipos de vehiculos que hay mediante un enum
     */

    public void setTipo(TipoVehiculo tipo) {
        this.tipoVehiculo = tipo;
    }

    /**
         * Metodo toString
         * @return la información del usuario
         */

    @Override
    public String toString() {
        return String.format("Vehiculo: $s, Matricula: %s, Modelo: %s", tipoVehiculo, this.getMatricula(), this.getModelo());
    }


    /**
         * Metodo equals de la clase
         * @param o the reference object with which to compare
         * @return true o false si el dni es igual o no
         */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getMatricula() != null ? getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;
    }

    /**
         * Metodo hashcode de la clase
         * @return la clave del mapa dni
         */

    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode() : 0;
    }

    public void add(Vehiculo vehiculos) {
    }
}
