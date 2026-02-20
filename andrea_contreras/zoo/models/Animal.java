package proyecto04.zoo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase abstracta Animal, para uso de herencia
 * @author Alumna - Andrea
 * @version 1.0
 */

public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idAnimal;
    private LocalDate fecharegistro;

    /**
     * Constructor principal de la clase Animal
     * @param idAnimal Identificador del animal
     * @param fecharegistro fecha de registro
     */

    public Animal(String idAnimal, LocalDate fecharegistro) {
        this.idAnimal = idAnimal;
        this.fecharegistro = fecharegistro;
    }

    /**
     * Getter del atributo Animal
     * @return el Id del animal
     */

    public String getIdAnimal() {
        return idAnimal;
    }

    /**
     * Setter del atributo Animal
     * @param idAnimal el Id del Animal
     */

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    /**
     * Getter del atributo Animal
     * @return fecha de registro
     */

    public LocalDate getFecharegistro() {
        return fecharegistro;
    }

    /**
     * Setter del atributo Animal
     * @param fecharegistro fecha de registro
     */

    public void setFecharegistro(LocalDate fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**

     *Compara este objeto con otro.*
     *@param "Object" objeto a comparar con este.
     *@return true si los codigos tienen los mismos valores y false en caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return  this.idAnimal != null ? this.idAnimal.equals(animal.idAnimal) : animal.idAnimal == null;

    }

    /**
     *Devuelve el código hash del codigo
     *@return retorna el codigo
     */

    @Override
    public int hashCode() {
       return idAnimal != null ? idAnimal.hashCode() : 0;
    }

    public abstract String getHabitat();
}
