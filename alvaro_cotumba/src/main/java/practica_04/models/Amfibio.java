package practica_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un animal de apartamento.
 *
 * @author Alumno - Alvaro Cotumba
 * @version 1.0
 */
public class Amfibio extends Animal {
    private int numAmfibio;

    /**
     * Constructor de animal de registro.
     *
     * @param id id único de la animal.
     * @param fechaRegistro Fecha de registro.
     * @param numAmfibio Número de registro.
     */
    public Amfibio (String id, LocalDate fechaRegistro, int numAmfibio) {
        super(id, fechaRegistro);
        this.numAmfibio = numAmfibio;
    }

    /**
     * Obtiene el número de registro.
     *
     * @return Número de registro.
     */
    public int getnumAmfibio() {
        return numAmfibio;
    }

    /**
     * Establece el número de registro.
     *
     * @param numAmfibio Nuevo número.
     */
    public void setnumAmfibio(int numAmfibio) {
        this.numAmfibio = numAmfibio;
    }

    /**
     * Obtiene el tipo de animal.
     *
     * @return "Animal registro".
     */
    @Override
    public String getTipoAnimal() {
        return "Animal registro";
    }

    /**
     * Representación en texto de la animal.
     *
     * @return String con datos de la animal.
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        return String.format("Animal amfibio: %s, %s, %s, %d", super.getId(), registro, this.numAmfibio);
    }
}