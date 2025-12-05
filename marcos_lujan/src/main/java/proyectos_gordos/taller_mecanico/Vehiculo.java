package proyectos_gordos.taller_mecanico;

import proyectos_gordos.enums.TipoVehiculo;

import java.util.Objects;


/**
 * Clase Vehículo
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public class Vehiculo {

    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor Vehículo
     *
     * @param matricula atributo de la clase vehiculo
     * @param modelo atributo de la clase vehiculo
     * @param tipo atributo de la clase vehiculo que contiene los enums del tipo de vehiculo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * Constructor vacío Vehículo
     */
    public Vehiculo() {
    }

    /**
     *Getter del atributo matricula
     *
     * @return la matricula del vehiculo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *Setter del atributo matricula
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *Getter del atributo modelo
     *
     * @return el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo modelo
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo Tipo
     *
     * @return el tipo del vehiculo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo Tipo
     * @param tipo
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo tostring para mostrar los datos del vehiculo
     * @return texto formateado con los datos del vehiculo
     */
    @Override
    public String toString() {
        return String.format("Matricula: %s, Modelo: %s, Tipo: %s: ",  getMatricula(), getModelo(), getTipo());
    }

    /**
     * Metodo equals que compara la matricula
     * @param o   the reference object with which to compare.
     * @return  true si el valor de la matricula es valido
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        return getMatricula() !=null ? getMatricula().equals(vehiculo.getMatricula()) :  vehiculo.getMatricula() == null;
    }

    /**
     * Metodo hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return getMatricula() !=null ? getMatricula().hashCode() : 0;
    }


}
