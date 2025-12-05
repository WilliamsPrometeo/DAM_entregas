package proyecto2.clases;

import enums.TipoVehiculo;

/**
 * Clase Vehiculo
 *
 * @author Alumno-Marco Martín
 * @version 1.0
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;



    /**
     * Constructor principal de la clase Vehiculo
     *
     * @param matricula
     * @param tipoVehiculo
     * @param modelo
     */


    public Vehiculo(String matricula, TipoVehiculo tipoVehiculo, String modelo) {
        this.matricula = matricula;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
    }

    /**
     * Getter de la matricula del Vehiculo
     *
     * @return la matricula del Vehiculo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter de la matricula del Vehiculo
     *
     * @return la matricula del Vehiculo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del modelo del Vehiculo
     *
     * @return el modelo del Vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del modelo del Vehiculo
     *
     * @return el modelo del Vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del tipo de Vehiculo
     *
     * @return el tipo de Vehiculo
     * @see TipoVehiculo
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Setter del tipo de Vehiculo
     *
     * @return el tipo de Vehiculo
     * @see TipoVehiculo
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Metodo toString
     * @return la informacion del vehiculo
     */
    @Override
    public String toString() {
    return String.format("Vehiculo: %s, Matricula: %s, Modelo: %s \n", tipoVehiculo ,matricula, modelo);
    }

    /**
     * Metodo equals de la clase
     * @param o   the reference object with which to compare.
     * @return true o false si la matricula es igual o no, respectivamente.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;

        return this.getMatricula() != null ? this.getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;
    }

    /**
     * Metodo hashCode de la clase
     * @return la clave del mapa de las matriculas
     */
    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode() : 0;
    }
}
