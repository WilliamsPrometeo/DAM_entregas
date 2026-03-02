package segunda_evaluacion.prueba4.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * La clase Mamifero se hereda de Aniaml y representa una subclase de gestión de un zoo
 * Contiene un atributo propio y hereda de animal idanaimal y fecha registro

 * @author Marcel Abad
 * @version 1.0
 */

public class Mamifero extends Animal {

    private boolean sonTerrestres;

    /**
     * Constructor de la clase {Mamifero}.
     * @param sonTerrestres booleano de si el maimerfero es terrestre o no
     */

    public Mamifero (String IdAnimal, LocalDate fechaRegistro, boolean sonTerrestres) {

        super(IdAnimal, fechaRegistro);
        this.sonTerrestres = sonTerrestres;
    }

    /**
     * Devuelve el booleano de si el animal es terrestre
     * @return sonTerrestres
     */
    public boolean isSonTerrestres() {
        return sonTerrestres;
    }
    /**
     * Modifica el booleano de si el animal es terrestre
     * @param sonTerrestres
     */
    public void setSonTerrestres(boolean sonTerrestres) {
        this.sonTerrestres = sonTerrestres;
    }

    /**
     * Devuelve el tipo de animal
     */

    @Override
    public String getTipoAnimal() {
        return "Mamifero";
    }

    /**
     * Muestra los datos del MAMIFERO de manera clara y formateada
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String registro = super.getFechaRegistro().format(dtf);

        String mamifero = this.sonTerrestres
                ? "Es terrestre"
                : "No es terrestre";

        return String.format(
                "Mamifero: %s,%s,%s",
                super.getIdAnimal(),
                registro,
                mamifero
        );
    }
}
