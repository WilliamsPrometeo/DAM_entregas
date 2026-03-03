package practica_04.models;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Clase abstracta que representa un animal genérico.
 *
 * @author Alumno - Alvaro Cotumba
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDate fechaRegistro;
    /**
     * Constructor de animal.
     *
     * @param id id único del animal.
     * @param fechaRegistro Fecha de registro.
     */
    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el id de animal.
     *
     * @return id de animal.
     */
    public String getId() {
        return id;
    }
    /**
     * Establece el id de animal.
     *
     * @param id Nuevo id.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene la fecha de registro.
     *
     * @return Fecha de registro.
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    /**
     * Establece la fecha de registro.
     *
     * @param fechaRegistro Nueva fecha.
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * Obtiene el tipo de animal (implementado por subclases).
     *
     * @return String con el tipo de animal.
     */
    public abstract String getTipoAnimal();
    /**
     * Genera id hash basado en id de animal.
     *
     * @return id hash.
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    /**
     * Compara animales por id de animal.
     *
     * @param obj Objeto a comparar.
     * @return true si son iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.id != null ? this.id.equals(animal.id) : animal.id == null;
    }
}
