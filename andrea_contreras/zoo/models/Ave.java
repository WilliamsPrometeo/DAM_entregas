package proyecto04.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Ave que hereda de la clase abstracta Animal
 * @author Alumna - Andrea
 * @version 1.0
 */

public class Ave extends Animal {

    private String tipocomida;

    /**
     * Contructor heredado de la clase Animal
     * @param idAnimal Id del animal
     * @param fecharegistro fecha de regidtro
     * @param tipocomida tipo comida
     */

    public Ave(String idAnimal, LocalDate fecharegistro, String tipocomida) {
        super(idAnimal, fecharegistro);
        this.tipocomida = tipocomida;
    }

    /**
     * Getter del atributo Ave
     * @return tipo de comidd
     */

    public String getTipocomida() {
        return tipocomida;
    }

    /**
     * Setter del atributo Ave
     * @param tipocomida tipo de comida
     */

    public void setTipocomida(String tipocomida) {
        this.tipocomida = tipocomida;
    }

    /**
     *
     * @return Habitat
     */

    @Override
    public String getHabitat() {
        return "Habitat";
    }

    /**
     * Metodo sobreescrito de la clase heredada para mostrar los datos del Ave
     *
     * @return datos del Ave
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecharegistro = super.getFecharegistro().format(dtf);
        return String.format("Animal Ave: %s, %s, %s, %s", super.getIdAnimal(), fecharegistro, this.tipocomida,  getHabitat());
    }
}
