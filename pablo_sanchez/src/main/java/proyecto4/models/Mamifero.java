package proyecto4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase hija mamífero que hereda de Animal
 * Incluye el atributo único de las mamífero.
 *
 * @author Alumno - Pablo Sánchez
 * @version 2.0
 */
public class Mamifero extends Animal {

    private int crias;

    /**
     * Constructor con parámetros.
     *
     * @param idAnimal Identificador del animal.
     * @param fechaRegistro Fecha del registro del animal.
     * @param crias Cuantas crias puede tener.
     */
    public Mamifero(String idAnimal, LocalDate fechaRegistro, int crias) {
        super(idAnimal, fechaRegistro);
        this.crias = crias;
    }

    /**
     * Obtiene las crias del animal.
     *
     * @return crias del animal.
     */
    public int getCrias() {
        return crias;
    }

    /**
     * Establece la id del animal.
     *
     * @param crias nuevo id del animal.
     */
    public void setCrias(int crias) {
        this.crias = crias;
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
        return String.format("Animal visitado: &d, %d", super.getIdAnimal(), fechaReg, this.crias);
    }
}
