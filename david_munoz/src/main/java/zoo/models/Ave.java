package zoo.models;


import exceptions.InvalidAnimalException;
import exceptions.InvalidDateException;

import java.time.LocalDate;

/**
 * Representa un animal de tipo ave.
 */
public class Ave extends models.Animal {

    private static final long serialVersionUID = 1L;

    private double envergadura;

    public Ave(String id, LocalDate fechaRegistro, double envergadura)
            throws InvalidAnimalException, InvalidDateException {
        super(id, fechaRegistro);
        this.envergadura = envergadura;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    @Override
    public String getTipo() {
        return "Ave";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Envergadura: " + envergadura;
    }
}