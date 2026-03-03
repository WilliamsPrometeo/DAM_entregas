package proyecto_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Mamifero
 * Representa una reserva específica de animal.
 * <p>
 * Hereda de la clase {@link Animal } e incorpora
 *
 * información adicional sobre el numero de patas del animal.
 * </p>
 *
 * @author Sebastian Acero
 * @version 1.0
 */
public class Mamifero extends Animal{

    /** Indica si los animales tienen patas. */
    private boolean patas;


    /**
     * Constructor de la clase Mamifero.
     * Inicializa los datos generales del animal y
     * especifica si tienen patas
     *
     * @param id código único de los animales
     * @param fechaEntrada fecha de registro
     * @param patas el numero de patas de los animales
     */
    public Mamifero(String id, LocalDate fechaEntrada, boolean patas) {
        super(id, fechaEntrada);
        this.patas = patas;
    }

    /**
     * Indica si los animales tienen patas.
     *
     * @return true si tienen patas, false en caso contrario
     */
    public boolean isPatas() {
        return patas;
    }

    /**
     * Modifica si el animal tiene patas
     *
     * @param patas nuevo valor que indica si incluye patas
     */
    public void setPatas(boolean patas) {
        this.patas = patas;
    }

    /**
     * Devuelve el tipo específico de animal.
     *
     * @return cadena de texto que indica el tipo de animal
     */
    @Override
    public String getTipoAnimal() {
        return "Mamifero";
    }

    /**
     * Devuelve una representación en formato texto de los animales.
     * <p>
     * Incluye el código id, las fechas formateadas
     * en formato dd/MM/yyyy y si el desayuno está incluido o no.
     * </p>
     *
     * @return cadena con la información completa de los animales
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getClass().format(dtf);
        return String.format("Mamifero");
    }

}
