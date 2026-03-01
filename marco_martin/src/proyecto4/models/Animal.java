package proyecto4.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase Padre Animal
 *
 * @author Alumno- Marco Martin
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idAnimal;
    private LocalDate fechaRegistro;

    /**
     * Constructor principal de la clase Animal
     * @param idAnimal
     * @param fechaRegistro
     */
    public Animal(String idAnimal, LocalDate fechaRegistro) {
        this.idAnimal = idAnimal;
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * Getter del id del animal
     *
     * @return el id del animal
     */
    public String getIdAnimal() {
        return idAnimal;
    }
    /**
     * Setter del id del animal
     *
     * @return el id del animal
     */
    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }
    /**
     * Getter de la fecha de registro del animal
     *
     * @return la fecha de registro del animal
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    /**
     * Setter de la fecha de registro del animal
     *
     * @return la fecha de registro del animal
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getter abstracto para obtener el tipo del animal (ENUM)
     * @return el tipo del animal
     */
    public abstract String getTipoAnimal();

    /**
     * Metodo equals para que el mapa identifique correctamente la clave
     *
     * @return el valor de la clave del mapa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return this.idAnimal != null ? idAnimal.equals(animal.idAnimal) : animal.idAnimal == null;
    }
    /**
     * Metodo hashCode para que el mapa identifique correctamente la clave
     *
     * @return la clave del mapa, siendo 0 si el valor es null
     */
    @Override
    public int hashCode() {
        return idAnimal != null ? idAnimal.hashCode() : 0;
    }
}
