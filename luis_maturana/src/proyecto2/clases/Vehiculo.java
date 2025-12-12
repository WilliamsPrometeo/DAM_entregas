package proyecto2.clases;

import proyecto2.enums.TipoVehiculo;

import java.util.Objects;

/**
 * Autor: Luis Gabriel Maturana
 *
 * Esta clase sirve para las arraylist y que cuando el cliente quiera registrar un vehiculo
 * podamos guardarlo
 *
 *
 */

/***
 *Aqui tenemos los atributos de esta entidad
 **/
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipovehi;
    /***
     *Constructor vacio
     **/
    public Vehiculo() {
    }
/**
 * Contructor principal
 * */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipovehi) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipovehi = tipovehi;
    }

    /**
     * Getter del atributo Matricula
     * Return la matricula
     * */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Setter del atributo Matricula
     * @param matricula Para establecer la matricula
     * */

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * Getter del atributo Modelo
     * Return el modelo
     * */

    public String getModelo() {
        return modelo;
    }
    /**
     * Setter del atributo Modelo
     * @param modelo para establecer el modelo
     * */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * Getter del tipo vehiculo
     * return tipo de vehiculo que nos dice el cliente
     * */

    public TipoVehiculo getTipovehi() {
        return tipovehi;
    }
    /**
     * Setter del tipo vehiculo
     * @param tipovehi para establecer el tipovehiculo que nos digita el cliente
     *
     * */

    public void setTipovehi(TipoVehiculo tipovehi) {
        this.tipovehi = tipovehi;
    }
    /**
     * Metodo sobreescrito con los datos de las entidades
     *
     * */
    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipovehi=" + tipovehi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }
}
