package proyecto_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Ave
 * Representa ave especifica de una animal.
 * <p>
 * Hereda de la clase {@link Animal} e incorpora
 * el número de aves
 *
 * @author Sebastian Acero
 * @version 1.0
 */
public class Ave extends Animal {

    /** Número identificador del apartamento reservado. */
    private int numAve;

    /**
     * Constructor de la clase Ave.
     * Inicializa los datos generales.
     *
     * @param id código único
     * @param fechaRegistro fecha de registro del animal
     */
    public Ave (String id, LocalDate fechaRegistro, int numAve ) {
        super(id, fechaRegistro);
        this.numAve = numAve;
    }

    /**
     * Obtiene el número de aves registrado
     *
     * @return número de aves
     */
    public int getNumAve() {
        return numAve;
    }

    /**
     * Modifica el número de aves
     *
     * @param numAve nuevo número de aves
     */
    public void setNumAve(int numAve) {
        this.numAve = numAve;
    }

    /**
     * Devuelve el tipo específico de animal.
     *
     * @return cadena de texto que indica el tipo de animal
     */
    @Override
    public String getTipoAnimal() {
        return "Ave ";
    }

    /**
     * Devuelve una representación en formato texto del registro.
     * <p>
     * Incluye el código de id, las fechas formateadas
     * en formato dd/MM/yyyy y el número de aves.
     * </p>
     *
     * @return cadena con la información completa de los animales
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaRegistro().format(dtf);
        return String.format("Reserva Apartamento: %s, %s, %s, %d", super.getId(), entrada, this.numAve);
    }
}
