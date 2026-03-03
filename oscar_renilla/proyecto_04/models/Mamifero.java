package programacion.simulacros_Proyectos.segundaEval.proyecto_04.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Mamifero que representa a un animal mamifero
 *
 * @author Alumno - Óscar
 * @version 1.0
 *
 */
public class Mamifero extends Animal{
    private int numeroPatas;

    /**
     * Constructor de mamifero
     *
     * @param id codigo unico del animal
     * @param fechaRegistro fecha en la que se registra el animal
     * @param numeroPatas numero de patas del animal
     */
    public Mamifero(String id, LocalDate fechaRegistro, int numeroPatas) {
        super(id, fechaRegistro);
        this.numeroPatas = numeroPatas;
    }

    /**
     * Devuelve el numero de patas
     *
     * @return numero de patas
     */
    public int getNumeroPatas() {
        return numeroPatas;
    }

    /**
     * Establece un nuevo numero de patas para el animal
     *
     * @param numeroPatas numero de patas
     */
    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    /**
     * Devuelve el tipo de animal
     *
     * @return descripcion del tipo de animal
     */
    @Override
    public String getTipoAnimal(){
        return "Mamifero";
    }

    /**
     * Devuelve una representacion en texto de la reserva
     *
     * @return datos completos del animal en texto
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        return String.format("Mamifero: id: %s | Fecha de registro: %s | Numero de patas: %s", super.getId(), registro, this.getNumeroPatas());
    }
}
