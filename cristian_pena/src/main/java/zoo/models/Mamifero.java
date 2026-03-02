package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Clase mamifero que hereda de la clase animal del zoo.
 * Cada mamifero que tiene como atributo especial el poder ser bipedo o no.
 */
public class Mamifero extends Animal {
    private Boolean esBipedo;
    /**
     * Constructor con parámetros.
     *
     * @param id id del animal.
     * @param fecha_registro Fecha de registro del animal.
     * @param esBipedo para comprobar si el animal es bipedo
     */
    public Mamifero(String id, LocalDate fecha_registro, Boolean esBipedo) {
        super(id, fecha_registro);
        this.esBipedo = esBipedo;
    }
    /**
     * Obtiene si el animal es bipedo o no.
     *
     * @return la respuesta si es bipedo o no del animal.
     */
    public Boolean getEsBipedo() {
        return esBipedo;
    }
    /**
     * Establece si el animal es bipedo.
     *
     * @param esBipedo del animal.
     */
    public void setEsBipedo(Boolean esBipedo) {
        this.esBipedo = esBipedo;
    }
    /**
     *  Metodo String que obtiene el tipo de animal
     * Devuelve el tipo de animal "mamifero"
     */
    @Override
    public String getTipoAnimal() {
        return "Mamifero";
    }
    /**
     *  Metodo toString que obtiene la fecha puesta y la devuelve formateada
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = super.getFecha_registro().format(dtf);
        String Bipedo = this.esBipedo ? "Es Bipedo" : "No es Bipedo";
        return String.format("Mamifero: %s, %s, %s", super.getId(), registro, Bipedo);
    }
}
