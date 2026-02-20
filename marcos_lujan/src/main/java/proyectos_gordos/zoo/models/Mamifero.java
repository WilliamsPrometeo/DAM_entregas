package proyectos_gordos.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mamifero extends Animal {

    private int numero_patas;
    private String color_pelaje;

    public Mamifero(String id, String nombre, String especie, String raza, LocalDate fechaEntrada, int numero_patas, String color_pelaje) {
        super(id, nombre, especie, raza, fechaEntrada);
        this.numero_patas = numero_patas;
        this.color_pelaje = color_pelaje;
    }

    public int getNumero_patas() {
        return numero_patas;
    }

    public void setNumero_patas(int numero_patas) {
        this.numero_patas = numero_patas;
    }

    public String getColor_pelaje() {
        return color_pelaje;
    }

    public void setColor_pelaje(String color_pelaje) {
        this.color_pelaje = color_pelaje;
    }

    @Override
    public String getTipoAnimal() {return "Mamífero registrado";
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaEntrada().format(dtf);

        return String.format("Mamífero - ID: %s, Nombre: %s, Especie: %s, Raza: %s, Fecha: %s, Patas: %d, Pelaje: %s", 
                super.getId(), super.getNombre(), super.getEspecie(), super.getRaza(), entrada, this.numero_patas, this.color_pelaje);
    }
}
