package zoo.models;

import exceptions.InvalidAnimalException;
import exceptions.InvalidDateException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase abstracta que representa un animal del zoo.
 * Contiene los datos comunes y las validaciones básicas.
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;
    protected LocalDate fechaRegistro;

    /**
     * Constructor del animal.
     *
     * @param id identificador único (formato 3 letras y 2 números)
     * @param fechaRegistro fecha de registro del animal
     * @throws InvalidAnimalException si el ID no es válido
     * @throws InvalidDateException si la fecha es posterior a la actual
     */
    public Animal(String id, LocalDate fechaRegistro)
            throws InvalidAnimalException, InvalidDateException {

        if (id == null || !id.matches("^[A-Za-z]{3}\\d{2}$")) {
            throw new InvalidAnimalException("ID inválido. Debe tener 3 letras y 2 números (Ej: ABC12)");
        }

        if (fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())) {
            throw new InvalidDateException("La fecha no puede ser posterior a hoy.");
        }

        this.id = id.toUpperCase();
        this.fechaRegistro = fechaRegistro;
    }

    public String getId() {
        return id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public abstract String getTipo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Fecha: " + fechaRegistro +
                " | Tipo: " + getTipo();
    }
}
