package proyecto_4.models;

import proyecto_4.models.enums.Habitat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * La clase Animal es la clase padre que figura como abstracta y es serializable.
 *
 * @author Alumno08 - Alejandro Galazo
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoAnimal;
    private LocalDate fecha_adquisicion;
    Habitat habitat;

    /**
     * Constructor con parámetros.
     *
     * @param codigoAnimal id serializable del animal.
     * @param fecha_adquisicion fecha de aquisicion del animal.
     * @param habitat enum sobre tipo de habitat del animal.
     */
    public Animal(String codigoAnimal, LocalDate fecha_adquisicion, Habitat habitat) {
        this.codigoAnimal = codigoAnimal;
        this.fecha_adquisicion = fecha_adquisicion;
        this.habitat = habitat;
    }

    /**
     * Obtiene el codigo del animal.
     *
     * @return codigo del animal.
     */
    public String getCodigoAnimal() {
        return codigoAnimal;
    }
    /**
     * Establece el codigo de un animal.
     *
     * @param codigoAnimal nuevo animal con codigo.
     */
    public void setCodigoAnimal(String codigoAnimal) {
        codigoAnimal = codigoAnimal;
    }
    /**
     * Obtiene la fecha de adquisicion.
     *
     * @return fecha de adquisicion.
     */
    public LocalDate getFecha_adquisicion() {
        return fecha_adquisicion;
    }
    /**
     * Establece la fecha de adquisicion.
     *
     * @param fecha_adquisicion nueva fecha de adqusicion.
     */
    public void setFecha_adquisicion(LocalDate fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }
    /**
     * Obtiene el habitat del animal.
     *
     * @return habitat.
     */
    public Habitat getHabitat() {
        return habitat;
    }
    /**
     * Establece el tipo de habitat.
     *
     * @param habitat tipo de habitat.
     */
    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
    /**
     * Genera el código hash del animal basado en su codigo.
     *
     * @return código hash del animal.
     */
    @Override
    public int hashCode() {
        return codigoAnimal != null ? codigoAnimal.hashCode() : 0;
    }
    /**
     * Compara este animal con otro objeto.
     * Dos animaless se consideran iguales si tienen el mismo codigo.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambos animales son iguales; {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.codigoAnimal != null ? this.codigoAnimal.equals(animal.codigoAnimal) : animal.codigoAnimal == null;
    }

    public abstract String getTipoAnimal();
}
