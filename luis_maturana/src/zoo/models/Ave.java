package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * La clase {@code Ave} representa una Ave que es clase hija de Animal dentro del sistema
 * de AppZoo.
 * <p>
 * Contiene información básica nombreAve y hereda atributos de su clase padre
 *
 * @author Gabriel Maturana
 * @version 1.0
 * @since 1.0
 */


public class Ave extends Animal {
    /** Nombre del ave */
    private String nombreAve;
    /**
     * Constructor de la clase {@code Pelicula}.
     *
     * @param id código unico del ave
     * @param fechaRegistro fecha en la que se registra el animal
     * @param nombreAve nombre del ave
     */
    public Ave(String id, LocalDate fechaRegistro, String nombreAve) {
        super(id, fechaRegistro);
        this.nombreAve = nombreAve;

    }
    /**
     * Devuelve el nombre del ave.
     *
     * @return nombre del ave
     */
    public String getNombre() {
        return nombreAve;
    }
    /**
     * Modifica el nombre del ave
     *
     * @param nombreAve nuevo nombre ave
     */
    public void setNombreAve(String nombreAve) { this.nombreAve = nombreAve; }
    /**
     * Devuelve una representación en texto del ave,
     * mostrando todos sus datos formateados.
     *
     * @return cadena con la información del ave
     */
    @Override
    public String getTipoAnimal() {
        return "Ave";
    }
    /**
     * Fecha formateada
     */
    public String toString() {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String fechaRegistro = dtf.format(super.getFechaRegistro());
       return String.format("Ave: %s, %s, %s", super.getId(), fechaRegistro, this.nombreAve);
    }
}
