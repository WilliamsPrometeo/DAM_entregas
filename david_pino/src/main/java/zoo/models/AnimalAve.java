package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase AnimalAve
 * Permite gestionar animales en el caso de que sean aves.
 *
 * @author David Pino
 * @version 2.0
 */

public class AnimalAve extends Animal {
    private boolean tipoAve;

    /**
     * Constructor vacio donde se inicializan las colecciones
     */

    public AnimalAve(String animalId, LocalDate fechaRegistro, LocalDate fechaSalida, boolean tipoAve) {
        super(animalId, fechaRegistro);
        this.tipoAve = tipoAve;
    }
    /**
     * Getter del atributo tipoAve
     *
     * @return la coleccion de tipos de ave
     */
    public boolean isTipoAve() {
        return tipoAve;
    }
/**
 * Setter del atributo tipoAves
 *
 * @param tipoAve establece la colección de aves
 */
    public void setTipoAve(boolean tipoAve) {
        this.tipoAve = tipoAve;
    }

    @Override
    public String getTipoAnimal() {
        return "Registro de Ave";
    }
    /**
     * Devuelve una representación en forma de cadena de el registro.
     *
     * @return información del registro formateada.
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaRegistro().format(dtf);
        String salida = super.getFechaRegistro().format(dtf);
        String tipoAve = this.tipoAve ? "Voladora" : "No Voladora";
        return String.format("Registro de Ave: %s, %s, %s, %d", super.getAnimalId(), entrada, salida, this.tipoAve);
    }
}
