package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa un animal de un zoologico.
 * Cada animal se identifica de forma unica mediante su id.
 *
 * @author David Pino
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String animalId;
    private LocalDate fechaRegistro;

    /**
     * Constructor con parametros
     * @param animalId
     * @param fechaRegistro
     */

    public Animal(String animalId, LocalDate fechaRegistro) {
        this.animalId = animalId;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el ID del animal
     *
     * @return ID del animal
     */

    public String getAnimalId() {
        return animalId;
    }

    /**
     * Establece el Id del animal
     * @param animalId
     */

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    /**
     * obtiene la fecha de registro
     *
     * @return fecha registro
     */

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Devuelve la fecha de registro de el animal
     *
     * @return fecha de registro
     */

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    public abstract String getTipoAnimal();

    /**
     * Genera el código hash del animal basado en el id.
     *
     * @return código hash del animal.
     */

    @Override
    public int hashCode() {
        return animalId != null ? animalId.hashCode() : 0;
    }

    /**
     * Compara el animal con otro objeto
     * Dos animales iguales se considera que tienen el mismo id
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambos animales son iguales; {@code false} en caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;


        Animal animal = (Animal) obj;
        return this.animalId != null ? animalId.equals(animal.animalId) : animal.animalId == null;
    }
}
