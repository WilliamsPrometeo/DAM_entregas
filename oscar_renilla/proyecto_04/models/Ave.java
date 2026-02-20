package programacion.simulacros_Proyectos.segundaEval.proyecto_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Ave que representa a un ave
 *
 * @author Alumno - Óscar
 * @version 1.0
 *
 */
public class Ave extends Animal{
    private boolean puedeVolar;

    /**
     * Constructor para aves
     *
     * @param id codigo unico del animal
     * @param fechaRegistro fecha en la que se registra el animal
     * @param puedeVolar indica si el ave puede volar
     */
    public Ave(String id, LocalDate fechaRegistro, boolean puedeVolar) {
        super(id, fechaRegistro);
        this.puedeVolar = puedeVolar;
    }

    /**
     * Devuelve si el ave puede volar
     *
     * @return si el ave puede volar
     */
    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    /**
     * Modifica si el ave puede volar
     *
     * @param puedeVolar nuevo valor para poder volar
     */
    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    /**
     *Devuelve el tipo de animal
     *
     * @return descripcion del tipo de animal
     */
    @Override
    public String getTipoAnimal() {
        return "Ave";
    }

    /**
     * Representa el animal en formato de texto
     *
     * @return informacion completa sobre el animal en texto
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        return String.format("Ave: id: %s | Fecha del registro: %s | Puede volar: %s", super.getId(), registro, puedeVolar);
    }
}
