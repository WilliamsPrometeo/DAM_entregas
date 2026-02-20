package zoo.models;

import java.time.LocalDate;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;

/**
 * Hago lo mismo que con ave, creo la clase Mamifero que hereda de Animal y le creo la caracteristica de tipo de pelaje
 */
public class Mamifero extends Animal {

    private static final long serialVersionUID = 1L;

    private String tipoPelaje;

    public Mamifero(String id, LocalDate fecha, String tipoPelaje)
            throws InvalidAnimalException, InvalidDateException {
        super(id, fecha);
        this.tipoPelaje = tipoPelaje;
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    @Override
    public String getTipo() {
        return "Mamífero";
    }
}