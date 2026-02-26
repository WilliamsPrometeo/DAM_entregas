package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase abstracta Animmal de la que se extenderan Mamifero y Ave
 * @author Unax
 * @see Mamifero
 * @see Ave
 * @version 1.0
 */

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idAnimal;
    private LocalDate fechaRegistro;

    /**
     * Constructor para la clase base Animal.
     * @param idAnimal Identificador unico (formato 00-AAAA)
     * @param fechaRegistro Fecha de comienzo del proyecto
     */

    /**
     * Constructor vacio con:
     * @param idAnimal
     * @param fechaRegistro
     */
    public Animal(String idAnimal, LocalDate fechaRegistro) {
        this.idAnimal = idAnimal;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getters & Setters
     */

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo abstracto para definir el rol según el tipo de asignacion.
     */
    public abstract String tipoAnimal();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.idAnimal != null ? this.idAnimal.equals(animal.idAnimal) : animal.idAnimal == null;
    }

    @Override
    public int hashCode() {
        return idAnimal != null ? idAnimal.hashCode() : 0;
    }
}
