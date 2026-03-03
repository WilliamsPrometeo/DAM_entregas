package gestion_zoo.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase Animal
 * @author Alumno - Ibrahima
 * @version 1.1
 * Se inicializa una clase abstracta porque es la clase padre siendo la principal.
 * Se implementa el Serializable para indicar que la clase se puede convertir en bytes.
 * Se implementa el serialVersion UID para verificar la compatibilidad al deserializar
 * y evitar errores si la clase cambia.
 **/

public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idAnimal;
    private LocalDate fechaRegistro;

    /**
     * Constructor principal de la clase Animal
     * Inicializa el atributo de fechaRegistro con la fecha del momento de registro
     * y el atributo idAnimal con la identificación del animal.
     * @param fechaRegistro  atributo heredado
     * @param idAnimal atributo heredado
     */

    public Animal(String idAnimal, LocalDate fechaRegistro) {
        this.idAnimal = idAnimal;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getter del atributo idAnimal
     *
     * @return la identificacion del animal
     */

    public String getIdAnimal() {
        return idAnimal;
    }
    /**
     * Setter del atribtuo Nombre
     *
     * @param idAnimal establece la identificacion del animal
     */

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    /**
     * Getter del atributo FechaRegistro
     *
     * @return la Fecha de Registro del animal
     */

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Setter del atribtuo Fecha_estreno
     *
     * @param fechaRegistro establece la Fecha de Registro del animal
     */

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Se incializa un constructor para ver que tipo de animal es en funcion e las clases hijas
     * @return null
     */

    public String getTipoAnimal() {
        return null;
    }

    /**
     * Genera el id hash de la animal basado en el codigo.
     *
     * @return id hash del animal.
     */

    @Override
    public int hashCode() {
        return idAnimal != null ? idAnimal.hashCode() : 0;
    }

    /**
     * Compara este animal con otro objeto.
     * Dos animales se consideran iguales si tienen el mismo id
     * @param obj objeto a comparar.
     * @return {@code true} si ambos animales son iguales; {@code false} en caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.idAnimal != null ? this.idAnimal.equals(animal.idAnimal) : animal.idAnimal == null;
    }
}
