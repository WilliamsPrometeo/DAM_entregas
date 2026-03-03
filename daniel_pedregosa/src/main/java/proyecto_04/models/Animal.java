package proyecto_04.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase abstracta que representa un animal registrado en el zoológico.
 * Contiene los atributos comunes a todas las especies: identificador, nombre
 * y fecha de registro. Implementa {@link Serializable} para permitir
 * serialización de instancias.
 * Autor: A4Alumno05 - Pedregosa
 * Versión: 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único del animal
    * Nombre asignado al animal
    * Fecha en la que el animal fue registrado en el sistema
    */
    private String id;
    private String nombre;
    private LocalDate fechaRegistro;
    private boolean volador;

    /**
     * Constructor principal de la clase Animal.
     * @param id identificador único (no nulo preferiblemente)
     * @param nombre nombre del animal
     * @param fechaRegistro fecha de registro (LocalDate)
     */
    public Animal(String id, String nombre, LocalDate fechaRegistro, boolean volador) {
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.volador = volador;
    }

    /**
     * Devuelve el identificador único del animal.
     * @return id del animal
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el nombre del animal.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la fecha de registro del animal.
     * @return fecha de registro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Devuelve si el animal vuela o no.
     * @return si vuela o no
     */
    public boolean isVolador() {
        return volador;
    }

    /**
     * Metodo abstracto que debe ser implementado por las subclases para
     * indicar el tipo concreto de animal.
     * @return cadena con el tipo del animal
     */
    public abstract String getTipo();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal other = (Animal) obj;
        return id != null ? id.equals(other.id) : other.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Animal: \nNombre: %s - ID: %s %n", nombre, id);
    }
}
