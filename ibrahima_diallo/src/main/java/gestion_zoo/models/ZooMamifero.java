package gestion_zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase ZooAnimal
 * @author Alumno - Ibrahima
 * @version 1.1
 **/

public class ZooMamifero extends Animal {

    public boolean colorOscuro;

    /**
     * Constructor principal de la clase Mamifero que hereda de animal que es su clase padre
     * Inicializa el atributo de colorOscuro para identficar si el animal es oscuro o no
     * Inicializa el atributo de fechaRegistro con la fecha del momento de registro
     * y el atributo idAnimal con la identificación del animal.
     * @param colorOscuro   atributo heredado
     * @param fechaRegistro  atributo heredado
     * @param idAnimal atributo heredado
     */
    public ZooMamifero(String idAnimal, LocalDate fechaRegistro, boolean colorOscuro) {
        super(idAnimal, fechaRegistro );
        this.colorOscuro =colorOscuro;
    }

    /**
     * Getter del atributo colorOscuro
     *
     * @return la oscuridad del animal
     */

    public boolean getColorOscuro() {
        return colorOscuro;
    }

    /**
     * Setter del atribtuo Nombre
     *
     * @param colorOscuro establece el tono de oscuridad del animal
     */

    public void setColorOscuro(boolean colorOscuro) {
        this.colorOscuro = colorOscuro;
    }

    /**
     * Se hace un override para establecer que el tipo de animal es un mamifero en este caso
     * @return Animal Ave
     */

    @Override
    public String getTipoAnimal() {
        return "Animal Mamifero";
    }

    /**
     * Metodo toString para mostrar los datos del animal
     *
     * @return texto formateado con los datos del animal
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFechaRegistro().format(dtf);
        String oscuro = this.colorOscuro ? "Animal Oscuro" : "Animal claro";
        return String.format("Mamifero: %s - %s -%s -%s ", getIdAnimal(), registro, oscuro, this.colorOscuro);
    }

}