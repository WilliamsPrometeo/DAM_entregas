package proyectos_gordos.zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase abstracta Animal.
 *
 * Representa los datos comunes de cualquier animal del zoológico.
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaEntrada;


    /**
     * Constructor de la clase Animal.
     *
     * @param id identificador único del animal
     * @param nombre nombre del animal
     * @param especie especie del animal
     * @param raza raza del animal
     * @param fechaEntrada fecha de entrada al zoológico
     */
    public Animal(String id, String nombre, String especie, String raza, LocalDate fechaEntrada) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Getter del atributo id
     * @return id del animal
     */
    public String getId() {
        return id;
    }

    /**
     * Setter del atributo id
     * @param id identificador del animal
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del atributo nombre
     * @return nombre del animal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atributo nombre
     * @param nombre nombre del animal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo especie
     * @return especie del animal
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Setter del atributo especie
     * @param especie especie del animal
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Getter del atributo raza
     * @return raza del animal
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Setter del atributo raza
     * @param raza raza del animal
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Getter de la fecha de entrada
     * @return fecha de entrada al zoológico
     */
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Setter de la fecha de entrada
     * @param fechaEntrada fecha de entrada al zoológico
     */
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public int hashCode() {return id != null ? id.hashCode() : 0;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() !=obj.getClass()) return false;

        Animal reserva = (Animal) obj;
        return this.id != null ? this.id.equals(reserva.id) : reserva.id == null;
    }

    /**
     * Devuelve el tipo específico de animal.
     * @return texto con el tipo de animal
     */
    public abstract String getTipoAnimal();
}
