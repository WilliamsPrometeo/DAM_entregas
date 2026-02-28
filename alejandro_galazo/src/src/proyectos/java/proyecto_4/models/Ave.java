package proyecto_4.models;

import proyecto_4.models.enums.Habitat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase hijo que hereda de animal.
 * Cada ave se identifica con su propio codigo y se especifica el numero de especie.
 **
 * @author Alumno08 - Alejandro Galazo
 * @version 1.0
 */
public class Ave extends Animal{
    private int numEspecie;
    /**
     * Constructor con parámetros.
     *
     * atributos heredados de la clase padre
     * @param numEspecie Numero de especie del ave.
     */
    public Ave(String codigoAnimal, LocalDate fecha_adquisicion, Habitat habitat, int numEspecie) {
        super(codigoAnimal, fecha_adquisicion, habitat);
        this.numEspecie = numEspecie;
    }
    /**
     * Obtiene el numero de especie.
     *
     * @return numero de especie.
     */
    public int getNumEspecie() {
        return numEspecie;
    }
    /**
     * Establece el numero de especie.
     *
     * @param numEspecie numero de especie del ave.
     */
    public void setNumEspecie(int numEspecie) {
        this.numEspecie = numEspecie;
    }

    /**
     * Obtiene el tipo de animal
     *
     * Devuelve que es un ave
     */
    @Override
    public String getTipoAnimal() {
        return "Ave";
    }
    /**
     * Devuelve una representación en forma de cadena del animal.
     *
     * @return información del animal formateada.
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String adquisicion = super.getFecha_adquisicion().format(dtf);
        return String.format("Ave: %s, %s, %d", super.getCodigoAnimal(), adquisicion, this.numEspecie);
    }
}
