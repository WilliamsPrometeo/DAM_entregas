package practica4.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un animal mamifero de un zoo.
 * Hereda todos los atributos de la clase animal.
 *
 * @author Pablo María
 * @version 1.0
 */

public class Mamifero extends Animal {
    private int numPatas;

    /**
     * Constructor con parámetros.
     *
     * @param codigoAnimal Código del animal.
     * @param fechaRegistro Fecha en la que el animal fue registrado.
     * @param numPatas Numero de patas sobre las que camina el animal.
     */

    public Mamifero(String codigoAnimal, LocalDate fechaRegistro, int numPatas) {
        super(codigoAnimal, fechaRegistro);
        this.numPatas = numPatas;
    }

    /**
     * Obtiene el numero de patas que el animal usa para moverse.
     *
     * @return numero de patas del animal.
     */

    public int getNumPatas() {
        return numPatas;
    }

    /**
     * Establece el numero de patas del animal.
     *
     * @param numPatas nuevo numero de patas del animal.
     */

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    /**
     * Obtiene el habitat en el que el animal vive.
     *
     * @return habitat.
     */

    @Override
    public String getHabitat(){
        return "Habitat";
    }

    /**
     * Devuelve una representación en forma de cadena del animal.
     *
     * @return información del animal formateada.
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        return String.format("Animal mamifero : %s, %s, %s, %s", super.getCodigoAnimal(), registro, this.numPatas, getHabitat());
    }
}