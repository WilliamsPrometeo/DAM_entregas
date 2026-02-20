package zoo.models;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
/**
 * ingreso los atributos y el connstructor con sus atributos como codigo animal y fecha¡regitro
 */
    private String codigoAnimal;
    private String fechaRegistro;
    public Animal(String codigoAnimal, String fechaRegistro) {
        this.codigoAnimal = codigoAnimal;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * aplico el get de codigo animal retornando la variable
     * @return
     */
    public String getCodigoAnimal() {
        return codigoAnimal;
    }

    /**
     * aplico el set deñl codigo animal
     * aplicando el retorno de este
     * @param codigoAnimal
     */
    public void setCodigoAnimal(String codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    /**
     * realizo los retornos de la variable y atributo
     * getfecharegistrop
     * @return
     */

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * realizo el set del atributo fecha registro
     * @param fechaRegistro
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public abstract String getTipoAnimal();

    public abstract String getHabitad();

    /**
     * realizo el override de codigo animal
     * @return
     */
    @Override
    public int hashCode() { return codigoAnimal != null ? codigoAnimal.hashCode() : 0;}

    /**
     * aplico el equals con lo que concateno los atributos
     * @param o   the reference object with which to compare.
     * @return
     */
    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return  this.codigoAnimal != null ? codigoAnimal.equals(animal.codigoAnimal) : animal.codigoAnimal == null;

    }


}
