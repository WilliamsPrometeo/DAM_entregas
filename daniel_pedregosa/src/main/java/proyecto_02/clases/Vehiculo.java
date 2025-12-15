package proyecto_02.clases;

import clases.proyecto_02.enums.TipoVehiculo;

/**
 * clase del Vehiculo
 * @author A4Alumno05 - Pedregosa
 * @version 1.0
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor principal de la clase Vehiculo
     * @param matricula matriculadel vehiculo
     * @param modelo modelo del vehiculo
     * @param tipo tipo del vehiculo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * setter del atributo Matricula
     * @return Matricula del Vehiculo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * getter del atributo Matricula
     * @param matricula establece la matricula
     */
    public static void setMatricula(String matricula) {
        matricula = matricula;
    }

    /**
     * setter del atributo Modelo
     * @return el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * setter del atributo Modelo
     * @param modelo establece el modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * getter del atributo Tipo
     * @return el atributo tipo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * setter del atributo Tipo
     * @param tipo establece el tipo del vehiculo
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     *metodo sobreescrito para mostrar los datos del vehiculo
     * @return datos del usuario
     */
    @Override
    public String toString() {
        return String.format("Vehiculo: %nMatricula: %s, Modelo: %s, Tipo: %s", matricula, modelo, tipo);
    }

    /**
     * metodo sobreescrito para la matricula
     * @param o   the reference object with which to compare.
     * @return datos de la matricula
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getMatricula() != null ? getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null ;
    }

    /**
     * metodo sobreescrito para mostrar el hasmap con la matricula
     * @return hasMap
     */
    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode() : 0;
    }
}
