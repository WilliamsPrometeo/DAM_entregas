package zoologico.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Ave que extiende de Animal
 * @see Animal
 * @author Adam Perez - Alumno
 * @version 1.0
 */

public class Ave extends Animal{
    private boolean puedeVolar;

    /**
     * Constructor principal de la clase ave
     * @param id String con el id del ave
     * @param fechaRegistro LocalDate con la fecha de registro
     * @param puedeVolar boolean true si puede volar, false si no puede
     */

    public Ave(String id, LocalDate fechaRegistro, boolean puedeVolar) {
        super(id, fechaRegistro);
        this.puedeVolar = puedeVolar;
    }

    /**
     * Getter del atributo puedeVolar
     * @return true si puede volar, false si no
     */

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    /**
     * Setter del atributo puedeVolar
     * @param puedeVolar boolean true si puede volar, false si no
     */

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    /**
     * Metodo que se sobreescribe toString
     * @return String formateado con la información del ave
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaRegistro = super.getFechaRegistro().format(dtf);
        String vuela = this.puedeVolar ? "Vuela" : "No vuela";

        return String.format("Animal: %s, %s, %s", super.getId(), fechaRegistro, vuela);
    }

    /**
     * Metodo que se sobreescribe de la clase animal
     * @return String con el tipo de animal
     */

    @Override
    public String getTipoAnimal() {
        return "Animal de tipo ave";
    }
}
