package proyecto2.clases;

import enums.TipoVehiculo;
/**
 * Clase Servicio
 *
 * @author Alumno - Cristian Peña

 */

public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;
    /**
     * Constructor principal de la clase Servicio

     *
     * @param matricula   matricula del vehiculo
     * @param modelo modelo del vehiculo
     * @param tipo     Tipo de vehiculo
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
     * Setter del atribtuo matricula
     *
     * @param matricula estable la matricula del vehiculo
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
     * @param tipo establece la edad de la persona
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
        return String.format("Vehiculo: %nmatricula: %s, modelo: %s, tipo: %s%n", this.matricula, this.modelo, this.tipo);
    }
    /**
     * Metodo equals para mostrar los datos del vehiculo
     *
     * @return para buscar por matricula
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

       return this.matricula != null ? this.matricula.equals(vehiculo.matricula) : vehiculo.matricula == null;
    }
    /**
     * Metodo hashcode para utilizar el mapa
     */
    @Override
    public int hashCode() {
        return matricula != null ? matricula.hashCode() : 0;
    }

}
