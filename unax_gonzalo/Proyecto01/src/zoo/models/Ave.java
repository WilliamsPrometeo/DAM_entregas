package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Clase Ave que se extiende de Animal
 * Que agrega además el atributo propio esRapaz
 * @author Unax
 * @see Animal
 * @see Mamifero
 * @version 1.0
 */

public class Ave extends Animal {
    private boolean esRapaz;

    /**
     * Constructor vacio
     * @param idAnimal Padre
     * @param fechaRegistro Padre
     * @param esRapaz Propio
     */
    public Ave(String idAnimal, LocalDate fechaRegistro, boolean esRapaz) {
        super(idAnimal, fechaRegistro);
        this.esRapaz = esRapaz;
    }

    public boolean isEsRapaz() {
        return esRapaz;
    }

    public void setEsRapaz(boolean esRapaz) {
        this.esRapaz = esRapaz;
    }

    @Override
    public String tipoAnimal() {
        return "Ave";
    }

    /**
     * Para dar formato a la salida
     * volvemos los localdate y el boolean en cadenas de texto string
     * (polimorfismo)
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        String rapaz = this.esRapaz ? "Es rapaz" : "No es rapaz";
        return String.format("Ave: %s, %s, %s", super.getIdAnimal(), registro,rapaz);
    }
}
