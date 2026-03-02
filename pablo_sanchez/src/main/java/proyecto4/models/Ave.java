package proyecto4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Clase hija Ave que hereda de Animal
 * Incluye el atributo único de las aves.
 *
 * @author Alumno - Pablo Sánchez
 * @version 2.0
 */
public class Ave extends Animal {
    private boolean incluyeShow;

    /**
     * Constructor con parámetros.
     *
     * @param idAnimal Identificador del animal.
     * @param fechaRegistro Fecha del registro del animal.
     * @param incluyeShow Inclusión de show o no.
     */
    public Ave(String idAnimal, LocalDate fechaRegistro, boolean incluyeShow) {
        super(idAnimal, fechaRegistro);
        this.incluyeShow = incluyeShow;
    }

    /**
     * Obtiene los shows del animal.
     *
     * @return shows del animal.
     */
    public boolean isIncluyeShow() {
        return incluyeShow;
    }

    /**
     * Establece la id del animal.
     *
     * @param incluyeShow nuevo id del animal.
     */
    public void setIncluyeShow(boolean incluyeShow) {
        this.incluyeShow = incluyeShow;
    }

    /**
     * Metodo toString para mostrar el tipo de animal
     *
     * @return texto formateado con el tipo de animal
     */
    @Override
    public String getTipoAnimal() {
        return "Tipo de animal";
    }

    /**
     * Metodo toString para mostrar los datos del animal
     *
     * @return texto formateado con los datos del animal
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaReg = super.getFechaRegistro().format(dtf);
        String desayuno = this.incluyeShow ? "Show incluido" : "Show no incluido";
        return String.format("Animal: &s, %s, %s", super.getIdAnimal(), fechaReg, desayuno);
    }
}
