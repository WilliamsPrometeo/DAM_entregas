package clases;

import enums.TipoVehiculo;

/**
 * Clase Vehiculo
 *
 * @author Alumno - Luis
 * @version 1.0
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor vacio de la clase Vehiculo
     */
    public Vehiculo() {
    }

    /**
     * Constructor principal de la clase Vehiculo
     *
     * @param matricula la matricula del vehiculo
     * @param modelo el modelo del Vehiculo
     * @param tipo enumeracion para establecer el tipo de vehiculo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * Getter del atributo matricula
     *
     * @return la matricula del vehiculo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atributo matricula
     *
     * @param matricula establece la matricula del vehiculo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo modelo
     *
     * @return el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo modelo
     *
     * @param modelo establece el modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo tipo
     *
     * @return el tipo de vehiculo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     *
     * @param tipo establece el tipo de vehiculo
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString para mostrar los datos del vehiculo
     *
     * @return texto formateado con los datos del vehiculo
     */
    @Override
    public String toString() {
        return String.format("Vehiculo: %s, modelo: %s, tipo: %s", this.matricula, this.modelo, this.tipo);
    }

    /**
     * Metodo hashCode
     *
     * @return la matricula en hashcode si la matricula no es nula o 0 si la matricula es nula
     */
    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode() : 0;
    }

    /**
     * Metodo equals para comparar otros objetos con vehiculo
     *
     * @param obj  el objeto de referencia con el que se va a comparar
     * @return true si el objeto es el mismo, flase si el objeto es nulo o las clases son distintas, null si
     * la matricula es null o la matricula del vehiculo si la matricula no es null
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ( obj == null | getClass() != obj.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) obj;

        return getMatricula() != null ? getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;
    }
}
