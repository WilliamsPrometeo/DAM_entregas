package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/** Clase abstracta Animal
 *
 * @author Alumno - Luis
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private final static long  serialVersionUID = 1L;

    private String id;
    private LocalDate fechaRegistro;

    /**
     * Constructor principal de la clase Animal
     *
     * @param id el id del animal
     * @param fechaRegistro la fecha de registro del animal
     */
    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getter del atributo id
     *
     * @return el id del animal
     */
    public String getId() {
        return id;
    }

    /**
     * Setter del atributo id
     *
     * @param id establece el id del animal
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del atributo fechaRegistro
     *
     * @return la fecha de registro del animal
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Setter del atributo fechaRegistro
     *
     * @param fechaRegistro establece la fecha de registro del animal
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo abtracto que devuelve un string
     *
     * @return el tipo de animal
     */
    public abstract String getTipoAnimal();

    /**
     * Metodo equals para comprobar si otro objeto es igual a Animal
     *
     * @param o el objeto de referencia con  el que compararlo
     * @return verdadero si son iguales los objetos,
     * falso si el objeto es null o las clases son distintas,
     * el id si los dos id son iguales y null si el id es null
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return this.id != null ? this.id.equals(animal.id) : animal.id == null;
    }

    /**
     * Metodo hashCode para poder utilizar animal en un hashmap
     *
     * @return el id en hascode si es distinto de nulo o 0 si es nulo
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
