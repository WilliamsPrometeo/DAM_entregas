package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un ave
 * Clase que se extiende de animal.
 * Incluye si anda o salta
 * @author Sosa
 * @see Animal
 * @see Mamifero
 * @version 1.0
 */


    public class Ave extends Animal {
        private boolean anda;

        /** Constructor vacío
         * @param anda Para saber si anda o salta
         */


    public Ave(String codigoAnimal, LocalDate fechaRegistro, boolean anda) {
        super(fechaRegistro, codigoAnimal);
        this.anda = anda;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        String andaCorre = this.anda ? "Anda" : "Salta";
        return String.format("Ave: %s, %s, %s, %s", super.getCodigoAnimal(), fecha, andaCorre);
    }

    @Override
    public String getHabitat() {
        return "Ave";
    }
}




