package proyecto4.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase padre Animal
 * Incluye los atributos compartidos de cada tipo de animal.
 *
 * @author Alumno - Pablo Sánchez
 * @version 2.0
 */

public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idAnimal;
    private LocalDate fechaRegistro;

    /**
     * Constructor con parámetros.
     *
     * @param idAnimal Identificador del animal.
     * @param fechaRegistro Fecha del registro del animal.
     */
    public Animal(String idAnimal, LocalDate fechaRegistro) {
        this.idAnimal = idAnimal;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene la id del animal.
     *
     * @return Id del animal.
     */
    public String getIdAnimal() {
        return idAnimal;
    }

    /**
     * Establece la id del animal.
     *
     * @param idAnimal nuevo id del animal.
     */
    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    /**
     * Obtiene la fecha de registro.
     *
     * @return fecha de registro.
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro.
     *
     * @param fechaRegistro nueva fecha de registro.
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el tipo de animal.
     *
     * @return tipo de animal.
     */
    public abstract String getTipoAnimal();

    @Override
    public int hashCode() {
        return idAnimal != null ? idAnimal.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() !=obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.idAnimal != null ? this.idAnimal.equals(animal.idAnimal) : animal.idAnimal == null;
    }
}
