package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pez que hereda de Animal
 *
 * @author Alumno - Luis
 * @version 1.0
 * @see Animal
 */
public class Pez extends Animal {

    private int numEscamas;

    /**
     * Constructor principal de la clase Pez
     *
     * @param id atributo heredado de la clase Animal
     * @param fechaRegistro atributo heredado de la clase Animal
     * @param numEscamas el numero de escamas del pez
     */
    public Pez(String id, LocalDate fechaRegistro, int numEscamas) {
        super(id, fechaRegistro);
        this.numEscamas = numEscamas;
    }

    /**
     * Getter del atributo numEscamas
     *
     * @return el numero de escamas del pez
     */
    public int getNumEscamas() {
        return numEscamas;
    }

    /**
     * Setter del atributo numEscamas
     *
     * @param numEscamas establece el numero de escamas del pez
     */
    public void setNumEscamas(int numEscamas) {
        this.numEscamas = numEscamas;
    }

    /**
     * Metodo heredado de Animal
     *
     * @return el tipo de animal que es
     */
    @Override
    public String getTipoAnimal() {
        return "Animal : Pez";
    }

    /**
     * Metodo toString para mostrar los datos del Pez
     *
     * @return texto formateado con los datos del Pez
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        return String.format("Pez:  %s - %s - %d ", super.getId(), fecha, this.numEscamas);
    }
}
