package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa un animal
 * Clase abstracta que implementa un serializable
 * Incluye si anda o salta
 * @author Sosa
 * @see Animal
 * @see Mamifero
 * @version 1.0
 */

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigoAnimal;
    private LocalDate fechaRegistro;


    /**
     * Constructor del animal
     * @param codigoAnimal Representa el codigo del animal del zoo
     * @param fechaRegistro Fecha de registro del animal
     */

    public Animal(LocalDate fechaRegistro, String codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoAnimal() {
        return codigoAnimal;
    }

    public void setCodigoAnimal(String codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return codigoAnimal != null ? codigoAnimal.equals(animal.codigoAnimal) : animal.codigoAnimal == null;
    }


    public abstract String getHabitat();
}
