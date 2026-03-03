package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * La clase {@code Animal} representa un Animal que es clase abstracta dentro del sistema
 * de AppZoo.
 * <p>
 * Contiene información básica id y fecha de registro
 *
 * @author Gabriel Maturana
 * @version 1.0
 * @since 1.0
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDate fechaRegistro;
    /**
     * Constructor de la clase {@code Animal}.
     *
     * @param id código unico del animal
     * @param fechaRegistro fecha en la que se registra el animal
     */

    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * Devuelve el id del animal.
     *
     * @return id del animal
     */

    public String getId() {
        return id;
    }
    /**
     * Modifica el id del animal.
     *
     * @param id nuevo codigo del animal
     */

    public void setId(String id) {
        this.id = id;
    }
    /**
     * Devuelve la fecha de registro
     *
     * @return fecha de registro
     */

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    /**
     * Modifica la fecha de registro.
     *
     * @param fechaRegistro Nueva fecha de registro
     */

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * Devuelve el tipo de animal
     */
    public abstract String getTipoAnimal();
    /**
     * Devuelve el código hash de animal.
     * <p>
     * El valor hash se calcula a partir del id
     * </p>
     *
     * @return valor hash del animal
     */

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    /**
     * Compara dos animales para determinar si son iguales.
     * <p>
     * Dos animales se consideran iguales si tienen el mismo id
     * </p>
     *
     * @param obj objeto a comparar
     * @return {@code true} si los codigos coinciden, {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.id != null? this.id.equals(animal.id): animal.id == null;

    }

}
