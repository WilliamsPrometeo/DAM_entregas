package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Clase ave que hereda de la clase animal del zoo.
 * Cada ave tiene como atributo especial el numero de alas.
 */
public class Ave extends Animal {
    private int numAlas;
    /**
     * Constructor con parámetros.
     *
     * @param id id del animal.
     * @param fecha_registro Fecha de registro del animal.
     * @param numAlas numero de alas del animal
     */
    public Ave(String id, LocalDate fecha_registro, int numAlas) {
        super(id, fecha_registro);
        this.numAlas = numAlas;
    }
    /**
     * Obtiene el numero de alas del animal.
     *
     * @return numero de alas del animal.
     */

    public int getNumAlas() {
        return numAlas;
    }
    /**
     * Establece el numero de alas del animal.
     *
     * @param numAlas nuevo numAlas del animal.
     */
    public void setNumAlas(int numAlas) {
        this.numAlas = numAlas;
    }
    /**
     *  Metodo String que obtiene el tipo de animal
     * Devuelve el tipo de animal "ave"
     */

    @Override
    public String getTipoAnimal() {
        return "Ave";
    }
    /**
     *  Metodo toString que obtiene la fecha puesta y la devuelve formateada
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFecha_registro().format(dtf);
        return String.format("Ave: %s, %s, %d", super.getId(), registro, numAlas);
    }
}
