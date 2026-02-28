package proyecto_4.models;

import proyecto_4.models.enums.Habitat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Clase hijo que hereda de animal.
 * Cada ave se identifica con su propio codigo y se especifica el numero de especie.
 *
 * @author Alumno08 - Alejandro Galazo
 * @version 1.0
 */
public class Reptil extends Animal{
    boolean venenoso;
    /**
     * Constructor con parámetros.
     *
     * atributos heredados de la clase padre
     * @param venenoso  dice si el animal es venenoso.
     */
    public Reptil(String codigoAnimal, LocalDate fecha_adquisicion, Habitat habitat, boolean venenoso) {
        super(codigoAnimal, fecha_adquisicion, habitat);
        this.venenoso = venenoso;
    }
    /**
     * Obtiene si es venenoso.
     *
     * @return valor true o false.
     */
    public boolean isVenenoso() {
        return venenoso;
    }

    public/**
     * Establece si el animal es venenoso.
     *
     * @param venenoso.
     */ void setVenenoso(boolean venenoso) {
        this.venenoso = venenoso;
    }
    /**
     * Obtiene el tipo de animal
     *
     * Devuelve que es un ave
     */
    @Override
    public String getTipoAnimal() {
        return "Reptil";
    }
    /**
     * Devuelve una representación en forma de cadena del animal.
     *
     * @return información del animal formateada.
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String adquisicion = super.getFecha_adquisicion().format(dtf);
        String venenoso = this.venenoso ? "es venenoso" : "no es venenoso";
        return String.format("Reptil: %s, %s, %s", super.getCodigoAnimal(), adquisicion, venenoso);
    }
}
