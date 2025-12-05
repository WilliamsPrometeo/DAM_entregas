package clases;

import recursos.TipoVehiculo;

/**
 * Clase Servicio
 * @author Adam Perez -Alumno
 * @version 1.0
 */

public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor principal de la clase Vehiculo
     * @param matricula String con la matricula del vehiculo
     * @param modelo String con el modelo del vehiculo
     * @param tipo Enum con el tipo de vehiculo
     */

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * Getter del atributo matricula
     * @return String con la matricula del vehiculo
     */

    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atributo  matricula
     * @param matricula String con la matricula del vehiculo
     */

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo modelo
     * @return String con el modelo del vehiculo
     */

    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo modelo
     * @param modelo String con el modelo del vehiculo
     */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo tipo
     * @return Enum  con el tipo de vehiculo
     */

    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     * @param tipo El tipo del vehiculo
     */

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString
     * @return Un string formateado con la informacion del vehiculo
     */

    @Override
    public String toString() {
        return String.format("Matricula: %s%n Modelo: %s%n Tipo: %s%n", this.matricula, this.modelo, this.tipo);
    }

    /**
     * Metodo hashcode de matricula
     * @return El hashcode de la matricula
     */

    @Override
    public int hashCode() {
        return this.getMatricula() != null ? this.getMatricula().hashCode() : 0;
    }

    /**
     * Metodo equals
     * @param obj   the reference object with which to compare.
     * @return true o false si la matricula coincide
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        return this.getMatricula() != null ? this.getMatricula().equals(this.getMatricula()) : this.getMatricula() == null;
    }
}
