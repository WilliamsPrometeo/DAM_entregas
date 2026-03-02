package zoo.models;

import java.time.LocalDate;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;

/**
 * Creo la clase Ave que hereda de Animal y le creo la caracteristica de envergadura
 */
public class Ave extends Animal {

    private static final long serialVersionUID = 1L;

    private double envergadura;

    public Ave(String id, LocalDate fecha, double envergadura)
            throws InvalidAnimalException, InvalidDateException {
        super(id, fecha);
        this.envergadura = envergadura;
    }

    @Override
    public String getTipo() {
        return "Ave";
    }
}