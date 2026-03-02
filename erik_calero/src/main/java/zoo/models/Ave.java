package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ave extends Animal {
    private String colorPlumaje;

    /**
     * aplico el constructor con los atributos requeridos como codigo animal , colorplumaje
     * @param codigoAnimal
     * @param fechaRegistro
     * @param colorPlumaje
     */
    public Ave(String codigoAnimal, LocalDate fechaRegistro, String colorPlumaje) {
        super(codigoAnimal, String.valueOf(fechaRegistro));
        this.colorPlumaje = colorPlumaje;
    }

    /**
     * realizo el get del atributo get color plumaje
     * @return
     */
    public String getColorPlumaje() {
        return colorPlumaje;
    }

    /**
     * implemento el set del atributo colorPlumaje
     * @param colorPlumaje
     */
    public void setColorPlumaje(String colorPlumaje) {
        this.colorPlumaje = colorPlumaje;
    }

    /**
     * aplico el override de getTipoAniaml
     * con el retorno en mensaje
     * @return
     */
    @Override
    public String getTipoAnimal(){
        return " animal mamifero";
    }

    /**
     * implemento el override
     * de gethabitad
     * con el retorno vacio
     * @return
     */
    @Override
    public String getHabitad() {
        return "";
    }

    /**
     * aplico el override de to string para concatenar los atributos del constructor
     * @return
     */

    @Override
    public String toString(){
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = getFechaRegistro().format(String.valueOf(dft));
        return  String.format("animal mamifero: %s - %s - %s ", getCodigoAnimal(), registro, this.colorPlumaje);
    }
}
