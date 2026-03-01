package proyecto4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Clase hijo Ave (extiende de animal)
 * @author Alumno-Marco Martín
 * @version 1.0
 */
public class Ave extends Animal{
    private boolean vuelo;

    /**
     * Constructor principal de la clase Ave
     * @param idAnimal
     * @param fechaRegistro
     * @param vuelo
     */
    public Ave(String idAnimal, LocalDate fechaRegistro, boolean vuelo) {
        super(idAnimal, fechaRegistro);
        this.vuelo = vuelo;
    }

    /**
     * Booleano que pregunta si el animal vuela o no
     * @return true si el animal vuela y false si no
     */
    public boolean isVuelo() {
        return vuelo;
    }
    /**
     * Setter que establece si el animal vuela o no
     * @return  si el animal vuela o no
     */
    public void setVuelo(boolean vuelo) {
        this.vuelo = vuelo;
    }
    /**
     * Metodo sobrescrito del getter del tipo de animal
     * @return que el animal registrado es un ave
     */
    @Override
    public String getTipoAnimal() {
        return "Ave registrada";
    }

    /**
     * Metodo toString para mostrar los datos del ave formateados
     * @return los datos del ave formateados
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = super.getFechaRegistro().format(dtf);
        String vueloformat=this.isVuelo() ? "Si":"No";
        return String.format("Ave registrada: \n ID: %s \n Fecha de registro: %s\n ¿Puede volar?: %s", super.getIdAnimal(), fecha, vueloformat);
    }
}
