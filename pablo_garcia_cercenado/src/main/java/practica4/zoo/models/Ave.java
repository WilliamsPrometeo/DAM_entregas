package practica4.zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un ave de un zoo.
 * Hereda todos los atributos de la clase animal.
 *
 * @author Pablo María
 * @version 1.0
 */

public class Ave extends Animal {
    private String colorPlumas;

    /**
     * Constructor con parámetros.
     *
     * @param codigoAnimal Código del animal.
     * @param fechaRegistro Fecha en la que el animal fue registrado.
     * @param colorPlumas Color de las plumas del animal.
     */

    public Ave(String codigoAnimal, LocalDate fechaRegistro, String colorPlumas) {
        super(codigoAnimal, fechaRegistro);
        this.colorPlumas = colorPlumas;
    }

    /**
     * Obtiene el color de las plumas del animal.
     *
     * @return color de las plumas del animal.
     */

    public String getColorPlumas() {
        return colorPlumas;
    }

    /**
     * Establece el color de las plumas del animal.
     *
     * @param colorPlumas nuevo color de plumas del animal.
     */

    public void setColorPlumas(String colorPlumas) {
        this.colorPlumas = colorPlumas;
    }

    /**
     * Obtiene el habitat en el que el animal vive.
     *
     * @return habitat.
     */

    @Override
    public String getHabitat() {
        return "Habitat";
    }

    /**
     * Devuelve una representación en forma de cadena del animal.
     *
     * @return información del animal formateada.
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        return String.format("Animal ave: %s, %s, %s, %s", super.getCodigoAnimal(), registro, this.colorPlumas, getHabitat());
    }

}
