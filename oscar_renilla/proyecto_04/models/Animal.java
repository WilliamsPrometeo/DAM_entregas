package programacion.simulacros_Proyectos.segundaEval.proyecto_04.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase abstracta Animal que representa un animal.
 * Contiene información común para distintos tipos de animales.
 *
 * @author Alumno - Óscar
 * @version 1.0
 *
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDate fechaRegistro;

    /**
     * Constructor con parametros
     *
     * @param id codigo identificativo unico
     * @param fechaRegistro fecha en la que se registra un nuevo animal
     */
    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el codigo del animal
     *
     * @return codigo del animal
     */
    public String getId() {
        return id;
    }

    /**
     * Modifica el codigo del animal
     *
     * @param id nuevo codigo del animal
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha del registro
     *
     * @return la fecha del registro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha del registro
     *
     * @param fechaRegistro nueva fecha de registro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo abstracto que devuelve el tipo de animal
     *
     * @return tipo de animal en formato de texto
     */
    public abstract String getTipoAnimal();

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.id != null ? id.equals(animal.id) : animal.id == null;
    }
}
