package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * La clase {@code Mamifero} representa un mamifero que es clase hija de Animal dentro del sistema
 * de AppZoo.
 * <p>
 * Contiene información básica raza y hereda atributos de su clase padre
 *
 * @author Gabriel Maturana
 * @version 1.0
 * @since 1.0
 */

public class Mamifero extends Animal {
    /** Raza del mamifero */
    private String raza;
    /**
     * Constructor de la clase {@code Mamifero}.
     *
     * @param id código unico del mamifero
     * @param fechaRegistro fecha en la que se registra el animal
     * @param raza raza del mamifero
     */

    public Mamifero(String id, LocalDate fechaRegistro, String raza) {
        super(id, fechaRegistro);
        this.raza = raza;
        /**
         * Devuelve la raza del  mamifero
         *
         * @return raza del mamifero
         */
    }
    public String getRaza() {
        return raza;
    }
    /**
     * Modifica la raza del mamifero
     *
     * @param raza nueva raza del mamifero
     */
    public void setRaza(String raza) { this.raza = raza; }
    /**
     * Devuelve una representación en texto del mamifero,
     * mostrando todos sus datos formateados.
     *
     * @return cadena con la información del mamifero
     */
    @Override
    public String getTipoAnimal() {
        return "Mamifero";

    }
    /**
     * Fecha formateada
     */
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaRegistro = dtf.format(super.getFechaRegistro());
        return String.format("Mamifero: %s, %s, %s", super.getId(), fechaRegistro, this.raza);
    }
}
