package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idAnimal;
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;

    /**
     * Constructor con parámetros.
     *
     * @param idAnimal Codigo que identifica al animal.
     * @param nombre nombre del animal.
     * @param edad edad del animal.
     * @param fechaNacimiento fecha de nacimiento del animal.
     */

    public Animal(String idAnimal, String nombre, int edad, LocalDate fechaNacimiento) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el codigo de identificación del animal.
     *
     * @return codigo de identificación.
     */

    public String getIdAnimal() {
        return idAnimal;
    }

    /**
     * Establece id del animal
     * @param idAnimal id.
     */

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    /**
     * Obtiene el nombre del animal.
     *
     * @return nombre.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     *
     * @param nombre nuevo nombre.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del animal
     *
     * @return edad.
     */

    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad
     *
     * @param edad nueva edad de la pelicula.
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la fecha de nacimiento.
     *
     * @return fecha de nacimiento.
     */

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimeinto.
     *
     * @param fechaNacimiento nueva fehca de nacimiento.
     */

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public abstract String getTipoAnimal();

    /**
     * Genera el código hash del animal.
     *
     * @return código hash del animal.
     */

    @Override
    public int hashCode() {
        return idAnimal != null ? idAnimal.hashCode() : 0;
    }

    /**
     * Compara un animal con otro según su id.
     * Dos animales se consideran iguales si tienen el mismo id.
     *
     * @param obj para comparar.
     * @return {@code true} si ambas animales son iguales; {@code false} en caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.idAnimal != null ? this.idAnimal.equals(animal.idAnimal) : animal.idAnimal == null;
    }

}


