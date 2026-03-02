package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un mamífero
 * Clase que se extiende de animal.
 * Incluye si anda o salta
 * @author Sosa
 * @see Animal
 * @see Mamifero
 * @version 1.0
 */


public class Mamifero extends Animal {
    private boolean epocaReproduccion;


    public Mamifero(LocalDate fechaRegistro, String codigoAnimal, boolean epocaReproduccion) {
        super(fechaRegistro, codigoAnimal);
        this.epocaReproduccion = epocaReproduccion;
    }

    public boolean isepocaReproduccion() {
        return epocaReproduccion;
    }

    public void setEpocaReproduccion(boolean epocaReproduccion) {
        this.epocaReproduccion = epocaReproduccion;
    }



    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        String reproduccion = this.epocaReproduccion ? "Está en época de reproducción" : "No está en época de reproducción";
        return String.format("Mamifero: %s, %s, %s, %s", super.getCodigoAnimal(), fecha, reproduccion);
    }

    @Override
    public String getHabitat() {
        return "Mamífero: ";
    }
}
