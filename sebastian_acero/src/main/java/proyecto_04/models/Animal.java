package proyecto_04.models;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * Clase abstracta Animal
 * Representa una reserva genérica dentro del sistema.
 * Contiene la información básica común a cualquier tipo de animal,
 * como el código identificador y fechas de registro.
 *
 * Esta clase debe ser extendida por clases concretas que
 * definan el tipo específico de reserva.
 *
 *
 * @author Sebastian Acero
 * @version 1.0
 */
public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la reserva.
     */
    private String id;

    /**
     * Fecha de registro.
     */
    private LocalDate fechaRegistro;

    /**
     * Constructor de la clase Reserva.
     * Inicializa los atributos básicos de la reserva.
     *
     * @param id            código único identificador del animal
     * @param fechaRegistro fecha de inicio de la reserva
     */
    public Animal(String id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el código identificador del animal.
     *
     * @return código
     */
    public String getId() {
        return id;
    }

    /**
     * Modifica el código identificador del animal.
     *
     * @param id nuevo código del animal
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de registro.
     *
     * @return fecha registro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Obtiene la fecha de registro del animal.
     *
     * @return fecha de regsitro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Genera el código hash del animal en su código identificador.
     *
     * @return valor hash del id
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    /**
     * Compara esta id con otro objeto para determinar si son iguales.
     * Dos id se consideran iguales si tienen el mismo código identificador.
     *
     * @param obj objeto a comparar
     * @return true si las id son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;
        return this.id != null ? this.id.equals(animal.id) : animal.id == null;
    }

    /**
     * clase abstracta que está implementado en la clase mamifero.
     *
     */
    public abstract String getTipoAnimal();
}


