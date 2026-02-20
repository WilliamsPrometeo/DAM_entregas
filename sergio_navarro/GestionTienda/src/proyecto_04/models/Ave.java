package proyecto_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase principal que gestiona la lógica del ave
 * Permite registrar id, registrar fecha de registro, asigna si puede o no volar.
 */
public class Ave extends Animal {
    private boolean vuela;

    public Ave(String id, LocalDate fechaRegistro, boolean puedeVolar) {
        super(id, fechaRegistro);
        this.vuela = puedeVolar;
    }

    /**
     * Getter de Volar
     * @return vuela
     */
    public boolean isVuela() {
        return vuela;
    }

    /**
     * Setter de vuela
     * @param vuela
     */
    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }

    /**
     * Metodo para mostrar los datos del ave
     * @return Ave
     */
    @Override
    public String getTipoAnimal() {
        return "Ave";
    }


    /**
     * Metodo para mostrar los datos del ave
     * @return Ave
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        String puedeVolar = this.vuela ? "Vuela" : "No vuela";
        return String.format("Ave: %s, %s, %s", super.getId(), registro, puedeVolar);
    }
}
