package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Clase abstracta que representa un animal del zoo.
 * Cada animal se identifica de forma unica por su id alfanumerico.
 */
public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private LocalDate fecha_registro;
    /**
     * Constructor con parámetros.
     *
     * @param id id del animal.
     * @param fecha_registro Fecha de registro del animal.
     */
    public Animal(String id, LocalDate fecha_registro) {
        this.id = id;
        this.fecha_registro = fecha_registro;
    }
    /**
     * Obtiene el id del animal.
     *
     * @return id del animal.
     */

    public String getId() {
        return id;
    }
    /**
     * Establece el id del animal.
     *
     * @param id nuevo id del animal.
     */

    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene la fecha de registro del animal.
     *
     * @return la fecha de registro del animal.
     */


    public LocalDate getFecha_registro() {
        return fecha_registro;
    }
    /**
     * Establece la fecha de registro del animal.
     *
     * @param fecha_registro nuevo fecha de registro del animal.
     */

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    public abstract String getTipoAnimal();
    /**
     * Genera el id hash del animal basado en el id.
     *
     * @return id hash del vehículo.
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    /**
     * Compara este animal con otro objeto.
     * Dos animales se consideran iguales si tienen el mismo id.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambos animales son iguales; {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return this.id != null ? this.id.equals(animal.id) : animal.id == null;
    }
}
