package segunda_evaluacion.prueba4.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * La clase Animal representa un animal dentro del sistema
 * de gestión de un zoo
 * Contiene información básica como IdAnimal y fecha de registro

 * @author Marcel Abad
 * @version 1.0
 *
 */

public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String IdAnimal;
    private LocalDate fechaRegistro;

    /**
     * Constructor de la clase {Animal}.
     * @param idAnimal id del animal
     * @param fechaRegistro fecha de registro del animal
     */

    public Animal(String idAnimal, LocalDate fechaRegistro) {
        this.IdAnimal = idAnimal;
        this.fechaRegistro = fechaRegistro;
    }
    /**
    * Devuelve el ID del animal
    * @return ID del animal
    */
    public String getIdAnimal() {
        return IdAnimal;
    }

    /**
     * Modifica el ID del animal
     * @param idAnimal ID del animal
     */

    public void setIdAnimal(String idAnimal) {
        IdAnimal = idAnimal;
    }
    /**
     * Devuelve la fecha de registro del animal
     * @return fechaRegistro del animal
     */

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Modifica la fecha de registro del animal
     * @param fechaRegistro animal
     */

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Devuelve el tipo del animal
     * @return el tipo del animal
     */

    public abstract String getTipoAnimal();

    /**
     * Metodo que genera el hash basado únicamente en idAnimal
     */

    @Override
    public int hashCode() {
        return IdAnimal != null ? IdAnimal.hashCode() : 0;
    }
    /**
     * Metodo que compara y determina cuando dos animales son iguales
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Animal animal = (Animal) obj;

        return this.IdAnimal != null
                ? this.IdAnimal.equals(animal.IdAnimal)
                : animal.IdAnimal == null;

    }
}
