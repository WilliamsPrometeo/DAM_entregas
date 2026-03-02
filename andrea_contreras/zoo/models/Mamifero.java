package proyecto04.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Clase Mamifero que hereda de la clase abstracta Animal
 * @author Alumna - Andrea
 * @version 1.0
 */

public class Mamifero extends Animal {

    private int numpatas;

    /**
     * Contructor heredado de la clase Animal
     * @param idAnimal
     * @param fecharegistro
     * @param numpatas
     */

    public Mamifero(String idAnimal, LocalDate fecharegistro, int numpatas) {
        super(idAnimal, fecharegistro);
        this.numpatas = numpatas;
    }

    /**
     * Getter del atributo Mamifero
     * @return numero de patas
     */

    public int getNumpatas() {
        return numpatas;
    }

    /**
     * Setter del atributo Mamifero
     * @param numpatas numero de patas
     */

    public void setNumpatas(int numpatas) {
        this.numpatas = numpatas;
    }

    /**
     *
     * @return Habitat
     */

    @Override
    public String getHabitat() {
        return "Habitat";
    }

    /**
     * Metodo sobreescrito de la clase heredada para mostrar los datos del Mamifero
     *
     * @return datos del Mamifero
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecharegistro = super.getFecharegistro().format(dtf);
        return String.format("Animal Mamifero: %s, %s, %s, %s", super.getIdAnimal(), fecharegistro, this.numpatas, getHabitat());
    }
}
