package practica4.zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa un animal de un zoo.
 * Cada animal se identifica de forma única por su codigo.
 *
 * @author Pablo María
 * @version 1.0
 */

public abstract class Animal implements Serializable {

    /**
     * Serializable
     * Ayudará a guardar los datos de forma eficaz
     */

    private static final long serialVersionUID = 1L;

    private String codigoAnimal;
    private LocalDate fechaRegistro;

    /**
     * Constructor con parámetros.
     *
     * @param codigoAnimal Código del animal.
     * @param fechaRegistro Fecha en la que el animal fue registrado.
     */

    public Animal(String codigoAnimal, LocalDate fechaRegistro) {
        this.codigoAnimal = codigoAnimal;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el código del animal.
     *
     * @return codigo del animal.
     */

    public String getCodigoAnimal() {
        return codigoAnimal;
    }

    /**
     * Establece el código del animal.
     *
     * @param codigoAnimal nuevo codigo del animal.
     */

    public void setCodigoAnimal(String codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    /**
     * Obtiene la fecha de registro del animal.
     *
     * @return fecha de registro del animal.
     */

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro del animal.
     *
     * @param fechaRegistro nueva fecha de registro del animal.
     */

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el habitat en el que vivirá el animal.
     *
     * @return habitat (en las clases hiajs).
     */

    public abstract String getHabitat();

    /**
     * Genera el código hash del animal basado en su codigo propio.
     *
     * @return código hash del animal.
     */

    @Override
    public int hashCode() {
        return codigoAnimal != null ? codigoAnimal.hashCode() : 0;
    }

    /**
     * Compara este animal con otro objeto.
     * Dos animales se consideran iguales si tienen el mismo codigo.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambos animales son iguales; {@code false} en caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.codigoAnimal != null ? this.codigoAnimal.equals(animal.codigoAnimal) : animal.codigoAnimal == null;
    }



}