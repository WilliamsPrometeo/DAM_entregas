package entrega4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    /**
     * Clase Mamífero que se extiende de Animal
     * Esta clase tiene un atributo distinto, en este caso un int de el número de patas del animal
     * @author Rodrigo Boto
     * @version 1.0
     */

public class Mamifero extends Animal {
    private int numPatas;

    public Mamifero(String id_animal, LocalDate fechaRegistro, int numPatas) {
        super(id_animal, fechaRegistro);
        this.numPatas = numPatas;
    }

    public int getNumPatas() {
        return numPatas;
    }
    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    /**
     * Método que recoge que tipo de animal es
     * @author Rodrigo Boto
     * @version 1.0
     */

    @Override
    public String getTipoAnimal() {
        return "Mamifero";
    }

    /**
     * Método para formatear la fecha de registro
     * @author Rodrigo Boto
     * @version 1.0
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);;
        return String.format("Mamífero: %s, %s, %s", super.getId_animal(), registro, this.numPatas);
    }
}
