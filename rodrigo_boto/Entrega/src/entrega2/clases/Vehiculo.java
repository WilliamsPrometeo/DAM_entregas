package entrega2.clases;

import entrega2.enums.TipoVehiculo;

/**
 * Clase Vehículo del programa
 * @author Rodrigo Boto
 * @version 1.0
 */

public class Vehiculo {
    //Atributos privados
    private String matricula;
    private String modelo;
    TipoVehiculo tipo;

    //Constructores

    /**
     * Constructor principal y vacío de la clase
     * @param matricula establece la matrícula
     * @param modelo establece el modelo del coche
     * @param tipo recoge la enumeración TipoVehiculo
     */

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }
    public Vehiculo() {
    }

    //Getters y Setters

    /**
     * Getter del atributo matrícula
     *
     * @return la matrícula
     */

    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atributo matricula
     *
     * @param matricula establece la matricula
     */

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo modelo
     *
     * @return el modelo del coche
     */

    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo Modelo
     *
     * @param modelo establece el modelo del coche
     */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del la enumeración Tipo
     *
     * @return el tipo
     */

    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo (de la enumeración)
     *
     * @param tipo establece el tipo de vehículo (de los que están dentro de la enumeración)
     */

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para mostrar los datos del vehículo
     *
     * @return texto formateado con los datos del vehículo
     */

    @Override
    public String toString() {
        return String.format("Matrícula: %s, Modelo: %s, Tipo: %s", this.matricula, this.modelo, this.tipo);
    }
}
//
