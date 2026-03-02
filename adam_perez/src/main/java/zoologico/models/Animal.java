package zoologico.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase abstracta Animal
 * @author Adam Perez ALumno
 * @version 1.0
 */

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDate fechaRegistro;

    /**
     * Constructor principal de la clase animal
     * @param id String con el id del animal
     * @param fechaRegistro LocalDate con la fecha de registro del animal
     */

    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getter del atributo id
     * @return String con el id del animal
     */

    public String getId() {
        return id;
    }

    /**
     * Setter del atributo id
     * @param id String con el id del animal
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del atributo fechaRegistro
     * @return LocalDate con la fecha de registro del animal
     */

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Setter del atributo fechaRegistro
     * @param fechaRegistro LocalDate con la fecha de registro del animal
     */

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo abstracto getTipoAnimal
     * @return String con el tipo de animal que se registra
     */

    public abstract String getTipoAnimal();

    /**
     * Metodo que se sobreescribe equals
     * @param obj   the reference object with which to compare.
     * @return Si el id del objeto corresponde con el id del animal dentro del mapa
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.id != null ? this.id.equals(animal.id) : animal.id == null;
    }

    /**
     * Metodo que se sobreescribe hashcode
     * @return Asigna un hashcode a los animales al introducirlos en el mapa
     */

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
