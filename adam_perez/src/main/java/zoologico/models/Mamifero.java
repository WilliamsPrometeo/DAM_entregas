package zoologico.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase mamifero que extiende de animal
 * @see Animal
 * @author Adam Perez - Almuno
 * @version 1.0
 */

public class Mamifero extends Animal {
    private int numeroPatas;

    /**
     * Constructor principal de la clase mamifero
     * @param id String con el id del mamifero
     * @param fechaRegistro LocalDate con la fecha de registro
     * @param numeroPatas int con el numero de patas que tiene
     */

    public Mamifero(String id, LocalDate fechaRegistro, int numeroPatas) {
        super(id, fechaRegistro);
        this.numeroPatas = numeroPatas;
    }

    /**
     * Getter del atributo numeroPatas
     * @return int con el numero de patas que tiene el animal
     */

    public int getNumeroPatas() {
        return numeroPatas;
    }

    /**
     * Setter del atributo numPatas
     * @param numeroPatas int con el numero de patas que tiene el animal
     */

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    /**
     * Metodo que se sobreescribe toString
     * @return String formateado con la informacion del mamifero
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaRegistro = super.getFechaRegistro().format(dtf);

        return String.format("Animal: %s, %s, %d", super.getId(), fechaRegistro, this.numeroPatas);
    }

    /**
     * Metodo que se sobreescribe de la clase animal
     * @return String con el tipo de animal
     */

    @Override
    public String getTipoAnimal() {
        return "Animal de tipo mamífero";
    }
}
