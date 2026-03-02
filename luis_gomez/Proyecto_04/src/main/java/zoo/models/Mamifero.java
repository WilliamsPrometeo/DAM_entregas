package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Mamifero que hereda de Animal
 *
 * @author Alumno - Luis
 * @version 1.0
 * @see Animal
 */
public class Mamifero extends Animal{

    private int numPatas;

    /**
     * Constructor principal de la clase Mamifero
     *
     * @param id atributo heredado de la clase Animal
     * @param fechaRegistro atributo heredado de la clase Animal
     * @param numPatas el numero de patas del mamifero
     */
    public Mamifero(String id, LocalDate fechaRegistro, int numPatas) {
        super(id, fechaRegistro);
        this.numPatas = numPatas;
    }

    /**
     * Getter del atributo numPatas
     *
     * @return el numero de patas del mamifero
     */
    public int getNumPatas() {
        return numPatas;
    }

    /**
     * Setter del atributo numPatas
     *
     * @param numPatas establece el numero de patas del mamifero
     */
    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    /**
     * Metodo heredado de Animal
     *
     * @return el tipo de animal que es
     */
    @Override
    public String getTipoAnimal() {
        return "Animal : Mamifero";
    }

    /**
     * Metodo toString para mostrar los datos del Mamifero
     *
     * @return texto formateado con los datos del Mamifero
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        return String.format("Mamifero: %s - %s - %d ", super.getId(), fecha, this.numPatas);
    }
}
