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
public class AnimalMamifero extends Animal {
    private boolean Carnivoro;

    /**
     * Constructor vacio donde se inicializan las colecciones
     */
    public AnimalMamifero(String animalId, LocalDate fechaRegistro, LocalDate fechaSalida, boolean carnivoro) {
        super(animalId, fechaRegistro);
        Carnivoro = carnivoro;
    }
    /**
     * Getter del atributo mamifero
     *
     * @return la coleccion de tipos de mamiferos
     */
    public boolean isCarnivoro() {
        return Carnivoro;
    }

    /**
     * Setter del atributo Carnivoro
     *
     * @param carnivoro establece la colección de aves
     */
    public void setCarnivoro(boolean carnivoro) {
        Carnivoro = carnivoro;
    }

    @Override
    public String getTipoAnimal() {
        return "Mamifero";
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
        String carnivoro = this.Carnivoro ? "Carnivoro" : "Herbívoro";
        return String.format("Registro Mamifero: %s, %s, %s, %d",super.getFechaRegistro(), entrada, salida, carnivoro);
    }
}
