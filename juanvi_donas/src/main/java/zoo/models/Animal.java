package zoo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;


/**
 * Creo la clase animal y la pongo como serializable
 */
public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String codigoAnimal;
    private LocalDate fechaRegistro;

    /**
     * Le digo que al id nada mas se le pueden poner 3 letras y dos numeros
     */

    private static final Pattern ID_PATTERN = Pattern.compile("^[A-Z]{3}\\d{2}$");

    public Animal(String id, LocalDate fechaRegistro)
            throws InvalidAnimalException, InvalidDateException {

        if (id == null || !ID_PATTERN.matcher(id).matches()) {
            throw new InvalidAnimalException("ID inválido. Formato: ABC12");
        }

        if (fechaRegistro.isAfter(LocalDate.now())) {
            throw new InvalidDateException("La fecha no puede ser futura");
        }

        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Le pido que me devuelva el ID y la fecha de registro
     * @return
     */
    public String getId() { return id; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }

    public abstract String getTipo();


    /**
     * Aquí comparo dos animales cualquiera que se pongan para que no tengan el mismo id
     * @param o   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}