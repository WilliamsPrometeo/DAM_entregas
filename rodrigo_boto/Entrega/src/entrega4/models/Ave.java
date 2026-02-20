package entrega4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    /**
     * Clase Ave que se extiende de Animal
     * Esta clase tiene un atributo distinto, en este caso un boolean de si puede volar o no
     * @author Rodrigo Boto
     * @version 1.0
     */

public class Ave extends Animal{


    private boolean puedeVolar;

    public Ave(String id_animal, LocalDate fechaRegistro, boolean puedeVolar) {
        super(id_animal, fechaRegistro);
        this.puedeVolar = puedeVolar;
    }

    public boolean getPuedeVolar() {
        return puedeVolar;
    }
    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    /**
     * Método que recoge que tipo de animal es
     * @author Rodrigo Boto
     * @version 1.0
     */

    @Override
    public String getTipoAnimal(){
        return "Ave";
    }

    /**
     * Método para formatear la fecha de registro
     * @author Rodrigo Boto
     * @version 1.0
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        String volar = this.puedeVolar ? "Puede volar" : "No puede volar";
        return String.format("Ave: %s, %s, %s", super.getId_animal(), registro, volar);
    }
}
