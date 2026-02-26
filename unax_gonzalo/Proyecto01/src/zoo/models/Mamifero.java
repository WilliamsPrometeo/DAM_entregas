package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Clase Mamifero que se extiende de Animal
 * Que agrega además el atributo propio pesoKG
 * @author Unax
 * @see Animal
 * @see Ave
 * @version 1.0
 */

public class Mamifero extends Animal {
    private int pesoKG;

    /**
     * Constructor vacio con:
     * @param idAnimal Padre
     * @param fechaRegistro Padre
     * @param pesoKG Propio
     */
    public Mamifero(String idAnimal, LocalDate fechaRegistro, int pesoKG) {
        super(idAnimal, fechaRegistro);
        this.pesoKG = pesoKG;
    }

    /**
     * Getters & Setters
     */
    public int getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(int pesoKG) {
        this.pesoKG = pesoKG;
    }

    @Override
    public String tipoAnimal() {
        return "Mamifero";
    }
    /**
     * Para dar formato a la salida
     * volvemos el localdate en cadena de texto string
     * (polimorfismo) agregamos %d ya que el atributo pesoKG
     * es numerico
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        return String.format("Mamifero: %s, %s, %d", super.getIdAnimal(), registro, this.pesoKG);
    }
}
