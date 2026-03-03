package proyecto_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Clase principal que gestiona la lógica del mamifero
 * Permite registrar id, registrar fecha de registro, asigna si es carnivoro y/o hervivoro.
 */
public class Mamifero extends Animal {
    private boolean carnivoro;
    private boolean hervivoro;

    /**
     * Constructor que inicializa las estructuras necesarias;
     */
    public Mamifero(String id, LocalDate fechaRegistro, boolean comeCarne, boolean comePlantas) {
        super(id, fechaRegistro);
        this.carnivoro = comeCarne;
        this.hervivoro = comePlantas;
    }

    /**
     * Getter de Carnivoro
     * @return Carnivoro
     */
    public boolean isCarnivoro() {
        return carnivoro;
    }

    /**
     * Setter de Carnivoro
     * @param carnivoro
     */
    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }

    /**
     * Getter de Hervivoro
     * @return Hervivoro
     */
    public boolean isHervivoro() {
        return hervivoro;
    }

    /**
     * Setter de Carnivoro
     * @param hervivoro
     */
    public void setHervivoro(boolean hervivoro) {
        this.hervivoro = hervivoro;
    }

    /**
     * Metodo para mostrar los datos del mamifero
     * @return Mamifero
     */
    @Override
    public String getTipoAnimal() {
        return "Mamífero";
    }


    /**
     * Metodo para mostrar los datos del mamifero
     * @return datos del mamifero
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        String comeCarne = this.carnivoro ? "Come carne" : "No come carne";
        String comePlantas = this.hervivoro ? "Come plantas" : "No come plantas";
        return String.format("Mamífero: %s, %s, %s, %s", super.getId(), registro, comeCarne, comePlantas);
    }
}

