package zoo.models;

import exceptions.InvalidAnimalException;
import exceptions.InvalidDateException;

import java.time.LocalDate;

/**
 * Representa un animal de tipo mamífero.
 */
public class Mamifero extends models.Animal {

    private static final long serialVersionUID = 1L;

    private boolean esSalvaje;

    public Mamifero(String id, LocalDate fechaRegistro, boolean esSalvaje)
            throws InvalidAnimalException, InvalidDateException {
        super(id, fechaRegistro);
        this.esSalvaje = esSalvaje;
    }

    public boolean isEsSalvaje() {
        return esSalvaje;
    }

    @Override
    public String getTipo() {
        return "Mamífero";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Salvaje: " + esSalvaje;
    }
}