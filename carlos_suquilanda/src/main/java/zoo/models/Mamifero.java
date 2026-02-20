package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mamifero extends Animal {
    private int mesesDeGestacion;

    public Mamifero(String idAnimal, String nombre, int edad, LocalDate fechaNacimiento, int mesesDeGestacion) {
        super(idAnimal, nombre, edad, fechaNacimiento);
        this.mesesDeGestacion = mesesDeGestacion;
    }

    public int getMesesDeGestacion() {
        return mesesDeGestacion;
    }

    public void setMesesDeGestacion(int mesesDeGestacion) {
        this.mesesDeGestacion = mesesDeGestacion;
    }

    @Override
    public String getTipoAnimal() {
        return "Animal Mamífero";
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimiento = super.getFechaNacimiento().format(dtf);
        return String.format("| ID Animal: %s | Nombre: %s | Edad: %d | Fecha de Nacimiento : %s | Meses de Gestación: %d |", super.getIdAnimal(), super.getNombre(), super.getEdad(), fechaNacimiento, this.mesesDeGestacion);
    }
}
