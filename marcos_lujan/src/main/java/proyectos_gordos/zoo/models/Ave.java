package proyectos_gordos.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ave extends Animal {

    private int longitud_alas;
    private boolean rapaz;

    public Ave(String id, String nombre, String especie, String raza, LocalDate fechaEntrada, int longitud_alas, boolean rapaz) {
        super(id, nombre, especie, raza, fechaEntrada);
        this.longitud_alas = longitud_alas;
        this.rapaz = rapaz;
    }

    public int getLongitud_alas() {
        return longitud_alas;
    }

    public void setLongitud_alas(int longitud_alas) {
        this.longitud_alas = longitud_alas;
    }

    public boolean isRapaz() {
        return rapaz;
    }

    public void setRapaz(boolean rapaz) {
        this.rapaz = rapaz;
    }

    @Override
    public String getTipoAnimal() {return "";
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaEntrada().format(dtf);

        return String.format("Ave - ID: %s, Nombre: %s, Especie: %s, Raza: %s, Fecha: %s, Longitud alas: %d cm, Rapaz: %s", 
                super.getId(), super.getNombre(), super.getEspecie(), super.getRaza(), entrada, this.longitud_alas, this.rapaz);
    }
}
