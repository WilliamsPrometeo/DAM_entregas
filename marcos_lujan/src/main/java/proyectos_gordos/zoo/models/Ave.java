package proyectos_gordos.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Ave que extiende Animal.
 *
 * Representa un ave del zoológico con longitud de alas y
 * si se trata de una rapaz.
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public class Ave extends Animal {

    private int longitud_alas;
    private boolean rapaz;

    /**
     * Constructor de Ave.
     *
     * @param id identificador del ave
     * @param nombre nombre del ave
     * @param especie especie del ave
     * @param raza raza del ave
     * @param fechaEntrada fecha de entrada al zoológico
     * @param longitud_alas longitud de las alas en centímetros
     * @param rapaz true si es rapaz, false en caso contrario
     */
    public Ave(String id, String nombre, String especie, String raza, LocalDate fechaEntrada, int longitud_alas, boolean rapaz) {
        super(id, nombre, especie, raza, fechaEntrada);
        this.longitud_alas = longitud_alas;
        this.rapaz = rapaz;
    }

    /**
     * Getter de longitud_alas
     * @return longitud de las alas en centímetros
     */
    public int getLongitud_alas() {
        return longitud_alas;
    }

    /**
     * Setter de longitud_alas
     * @param longitud_alas longitud de las alas en centímetros
     */
    public void setLongitud_alas(int longitud_alas) {
        this.longitud_alas = longitud_alas;
    }

    /**
     * Consulta si el ave es rapaz
     * @return true si es rapaz, false de lo contrario
     */
    public boolean isRapaz() {
        return rapaz;
    }

    /**
     * Setter de la propiedad rapaz
     * @param rapaz indica si el ave es rapaz
     */
    public void setRapaz(boolean rapaz) {
        this.rapaz = rapaz;
    }

    /**
     * Devuelve el tipo de animal.
     * @return cadena que describe el tipo de animal
     */
    @Override
    public String getTipoAnimal() {return "";
    }

    /**
     * Método toString para mostrar los datos del ave.
     * @return texto con la información formateada del ave
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaEntrada().format(dtf);

        return String.format("Ave - ID: %s, Nombre: %s, Especie: %s, Raza: %s, Fecha: %s, Longitud alas: %d cm, Rapaz: %s", 
                super.getId(), super.getNombre(), super.getEspecie(), super.getRaza(), entrada, this.longitud_alas, this.rapaz);
    }
}
