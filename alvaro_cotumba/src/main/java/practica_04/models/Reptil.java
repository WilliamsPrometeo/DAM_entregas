package practica_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Representa un animal del zoo.
 *
 * @author Alumno - Alvaro Cotumba
 * @version 1.0
 */
public class Reptil extends Animal {
    private boolean incluyeSnackparaReptil;

    /**
     * Constructor de animal de hotel.
     *
     * @param id id único de la animal.
     * @param fechaRegistro Fecha de registro.
     * @param incluyeSnackReptil true si incluye incluyeSnackReptil.
     */
    public Reptil(String id, LocalDate fechaRegistro, boolean incluyeSnackReptil) {
        super(id, fechaRegistro);
        this.incluyeSnackparaReptil = incluyeSnackReptil;
    }

    /**
     * Indica si incluye incluyeSnackReptil.
     *
     * @return true si incluye incluyeSnackReptil.
     */
    public boolean isIncluyeSnackparaReptil() {
        return incluyeSnackparaReptil;
    }

    /**
     * Establece si incluye incluyeSnackReptil.
     *
     * @param incluyeSnackparaReptil nuevo valor.
     */
    public void setIncluyeSnackparaReptil(boolean incluyeSnackparaReptil) {
        this.incluyeSnackparaReptil = incluyeSnackparaReptil;
    }

    /**
     * Obtiene el tipo de animal.
     *
     * @return "Animal Zoo".
     */
    @Override
    public String getTipoAnimal() {
        return "Animal Zoo";
    }

    /**
     * Representación en texto de la animal.
     *
     * @return String con datos de la animal.
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        String snackreptil = this.incluyeSnackparaReptil ? "Snack para Reptil incluido" : "Snack para Reptil no incluido";
        return String.format("Animal hotel: %s, %s, %s, %s", super.getId(), registro, snackreptil);
    }

}