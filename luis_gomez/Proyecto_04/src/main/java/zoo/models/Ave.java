package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Ave que hereda de Animal
 *
 * @author Alumno - Luis
 * @version 1.0
 * @see Animal
 */
public class Ave extends Animal {

    private int numPlumas;

    /**
     * Constructor principal de la clase Ave
     *
     * @param id atributo heredado de la clase Animal
     * @param fechaRegistro atributo heredado de la clase Animal
     * @param numPlumas el numero de plumas del ave
     */
    public Ave(String id, LocalDate fechaRegistro, int numPlumas) {
        super(id, fechaRegistro);
        this.numPlumas = numPlumas;
    }

    /**
     * Getter del atributo numPlumas
     *
     * @return el numero de plumas del ave
     */
    public int getNumPlumas() {
        return numPlumas;
    }

    /**
     * Setter del atributo numPlumas
     *
     * @param numPlumas establece el numero de plumas del animal
     */
    public void setNumPlumas(int numPlumas) {
        this.numPlumas = numPlumas;
    }

    /**
     * Metodo heredado de Animal
     *
     * @return el tipo de animal que es
     */
    @Override
    public String getTipoAnimal() {
        return "Animal : Ave";
    }

    /**
     * Metodo toString para mostrar los datos del Ave
     *
     * @return texto formateado con los datos del Ave
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        return String.format("Ave: %s - %s - %d ", super.getId(), fecha, this.numPlumas);
    }
}
