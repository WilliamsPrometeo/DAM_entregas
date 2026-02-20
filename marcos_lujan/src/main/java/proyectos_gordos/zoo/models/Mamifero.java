package proyectos_gordos.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Mamifero representa animales mamíferos dentro del zoológico.
 * Contiene información adicional sobre patas y color de pelaje.
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public class Mamifero extends Animal {

    /** número de patas del mamífero */
    private int numero_patas;
    /** color del pelaje del mamífero */
    private String color_pelaje;

    /**
     * Constructor Mamifero
     *
     * @param id identificador único del animal
     * @param nombre nombre común del mamífero
     * @param especie especie biológica
     * @param raza raza concreta dentro de la especie
     * @param fechaEntrada fecha de ingreso al zoológico
     * @param numero_patas número de patas del mamífero
     * @param color_pelaje color del pelaje del mamífero
     */
    public Mamifero(String id, String nombre, String especie, String raza, LocalDate fechaEntrada, int numero_patas, String color_pelaje) {
        super(id, nombre, especie, raza, fechaEntrada);
        this.numero_patas = numero_patas;
        this.color_pelaje = color_pelaje;
    }

    /**
     * Getter del atributo numero_patas
     * @return cantidad de patas del mamífero
     */
    public int getNumero_patas() {
        return numero_patas;
    }

    /**
     * Setter del atributo numero_patas
     * @param numero_patas nueva cantidad de patas
     */
    public void setNumero_patas(int numero_patas) {
        this.numero_patas = numero_patas;
    }

    /**
     * Getter del atributo color_pelaje
     * @return color del pelaje
     */
    public String getColor_pelaje() {
        return color_pelaje;
    }

    /**
     * Setter del atributo color_pelaje
     * @param color_pelaje nuevo color del pelaje
     */
    public void setColor_pelaje(String color_pelaje) {
        this.color_pelaje = color_pelaje;
    }

    /**
     * Devuelve el tipo de animal para mostrar en el sistema
     * @return descripción breve de que se trata de un mamífero
     */
    @Override
    public String getTipoAnimal() {return "Mamífero registrado";
    }

    /**
     * Método toString para mostrar los datos completos del mamífero
     * @return texto formateado con los atributos heredados y propios
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaEntrada().format(dtf);

        return String.format("Mamífero - ID: %s, Nombre: %s, Especie: %s, Raza: %s, Fecha: %s, Patas: %d, Pelaje: %s", 
                super.getId(), super.getNombre(), super.getEspecie(), super.getRaza(), entrada, this.numero_patas, this.color_pelaje);
    }
}
