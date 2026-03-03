package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ave extends Animal {
    private int numeroDeMesesEnEclosionarUnHuevo;

    public Ave(String idAnimal, String nombre, int edad, LocalDate fechaNacimiento, int numeroDeMesesEnEclosionarUnHuevo) {
        super(idAnimal, nombre, edad, fechaNacimiento);
        this.numeroDeMesesEnEclosionarUnHuevo = numeroDeMesesEnEclosionarUnHuevo;
    }

    public int getNumeroDeMesesEnEclosionarUnHuevo() {
        return numeroDeMesesEnEclosionarUnHuevo;
    }

    public void setNumeroDeMesesEnEclosionarUnHuevo(int numeroDeMesesEnEclosionarUnHuevo) {
        this.numeroDeMesesEnEclosionarUnHuevo = numeroDeMesesEnEclosionarUnHuevo;
    }

    @Override
    public String getTipoAnimal() {
        return ("Animal Ave");
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimiento = super.getFechaNacimiento().format(dtf);
        return String.format("| ID Animal: %s | Nombre: %s | Edad: %d | Fecha de Nacimiento : %s | Meses que tardan en eclosionar los huevos : %d |", super.getIdAnimal(), super.getNombre(), super.getEdad(), fechaNacimiento, this.numeroDeMesesEnEclosionarUnHuevo);
    }
}
