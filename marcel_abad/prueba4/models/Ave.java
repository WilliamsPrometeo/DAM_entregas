package segunda_evaluacion.prueba4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * La clase Ave se hereda de Animal y representa una subclase de gestión de un zoo
 * Contiene un atributo propio y hereda de animal idanaimal y fecha registro

 * @author Marcel Abad
 * @version 1.0
 */

public class Ave extends Animal {

    private int numeroPatas;

    /**
     * Constructor de la clase {Ave}.
     * @param numeroPatas int de cuantas patas tienen
     */

    public Ave(String IdAnimal, LocalDate fechaRegistro, int numeroPatas) {

        super(IdAnimal, fechaRegistro);
        this.numeroPatas = numeroPatas;
    }

    /**
     * Devuelve el int de cuantas patas tiene el animal
     * @return numeroPatas
     */

    public int getNumeroPatas() {
        return numeroPatas;
    }

    /**
     * Modifica el int de cuantas patas tiene el animal
     * @param numeroPatas
     */

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    /**
     * Devuelve el tipo de animal
     */

    @Override
    public String getTipoAnimal() {
        return "Ave";
    }

    /**
     * Muestra los datos del AVE de manera clara y formateada
     */

    @Override
    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);

        return String.format(
                "Ave: %s,%s,%d",
                super.getIdAnimal(),
                registro,
                this.numeroPatas
        );
    }
}
