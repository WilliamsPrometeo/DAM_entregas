package proyecto_04.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa un animal dentro del sistema del taller
 * Contiene información básica: id y fecha de registro
 * @author Alumno - Sergio Navarro
 * @version 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDate fechaRegistro;

    /**
     * Constructor con paramertros para crear una clase libro completa
     * @param id
     * @param fechaRegistro
     */
    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * Getter del atributo id
     * @return Devuelve el id del animal
     */
    public String getId() {
        return id;
    }

    /**
     * Setter de la Matricula, asigna un id al animal
     * @param id Establece un id para el animal
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del atributo Fecha de registro
     * @return Devuelve la fecha de regitro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    /**
     * Setter del TipoVehiculo, asigna una fehca de registro
     * @param fechaRegistro Establece una fecha de registro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Clase abstrabta de tipo animal
     */
    public abstract String getTipoAnimal ();


    /**
     * Calcula el hashCode usando id
     * Si equals compara matrículas, hashCode debe hacerse también con el id
     * @return hash basado en el id
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * Determina si dos vehículos son iguales comparando su id
     * @param obj Objeto a comparar
     * @return true si el id coincide, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.id != null ? this.id.equals(animal.id) : animal.id == null;
    }
}
