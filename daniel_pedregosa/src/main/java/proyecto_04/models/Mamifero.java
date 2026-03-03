package proyecto_04.models;

import java.time.LocalDate;

/**
 * Clase que representa un mamífero en el zoológico.
 * Hereda de {@link Animal} y añade atributos específicos como color de pelaje
 * y número de patas.
 * Autor: A4Alumno05 - Pedregosa
 * Versión: 1.0
 */
public class Mamifero extends Animal {

    private static final long serialVersionUID = 2L;

    /** Color del pelaje del mamífero
    * Número de patas que tiene el mamífero
    */
    private String colorPelaje;
    private int num_patas;
    /** Indica si el mamífero puede volar */
    private boolean volador;

    /**
     * Constructor de Mamifero.
     * @param id identificador único
     * @param nombre nombre del mamífero
     * @param fechaRegistro fecha de registro
     * @param colorPelaje color del pelaje
     * @param num_patas número de patas
     */
    public Mamifero(String id, String nombre, LocalDate fechaRegistro, String colorPelaje, int num_patas, boolean volador) {
        super(id, nombre, fechaRegistro, volador);
        this.colorPelaje = colorPelaje;
        this.num_patas = num_patas;
        this.volador = volador;
    }

    /**
     * Devuelve el color del pelaje.
     * @return color del pelaje
     */
    public String getColorPelaje() {
        return colorPelaje;
    }

    /** Indica si el mamífero puede volar. */
    public boolean isVolador() {
        return volador;
    }

    /** Establece si el mamífero puede volar. */
    public void setVolador(boolean volador) {
        this.volador = volador;
    }

    /** Establece el color del pelaje. */
    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }

    /**
     * Devuelve el número de patas.
     * @return número de patas
     */
    public int getNum_patas() {
        return num_patas;
    }

    /** Establece el número de patas. */
    public void setNum_patas(int num_patas) {
        this.num_patas = num_patas;
    }

    /**
     * Tipo concreto del animal.
     * @return "Mamifero"
     */
    @Override
    public String getTipo() {
        return "Mamifero";
    }

    /**
     * Representación en texto con los datos del mamífero.
     * @return cadena formateada con nombre, id, fecha, color y número de patas
     */
    @Override
    public String toString() {
        return String.format("Mamifero de Nombre: %s - ID: %s - Fecha de Registro: %s - Color de Pelo: %s - Numero de Patas: %s - Volador: %s", getNombre(), getId(),  getFechaRegistro(),  getColorPelaje(),  getNum_patas(), isVolador());
    }
}
