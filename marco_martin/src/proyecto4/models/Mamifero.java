package proyecto4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase hijo Mamífero (extiende de animal)
 * @author Alumno-Marco Martín
 * @version 1.0
 */

public class Mamifero extends Animal{
    private int pezones;

    /**
     * Constructor principal de la clase mamífero
     * @param idAnimal
     * @param fechaRegistro
     * @param pezones
     */
    public Mamifero(String idAnimal, LocalDate fechaRegistro, int pezones) {
        super(idAnimal, fechaRegistro);
        this.pezones = pezones;
    }

    /**
     * Metodo sobrescrito del getter del tipo de animal
     * @return que el animal registrado es un mamífero
     */
    @Override
    public String getTipoAnimal() {
        return "Mamifero registrado";
    }
    /**
     * Metodo toString para mostrar los datos del mamífero formateados
     * @return los datos del mamífero formateados
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        return String.format("Mamifero registrado: \n ID: %s \n Fecha de registro: %s\n Número de pezones: %d", super.getIdAnimal(), fecha, this.pezones);
    }
}
