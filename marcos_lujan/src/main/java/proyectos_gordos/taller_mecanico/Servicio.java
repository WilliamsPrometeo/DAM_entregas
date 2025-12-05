package proyectos_gordos.taller_mecanico;

import proyectos_gordos.enums.TipoServicio;

/**
 * Clase Servicio
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor Servicio
     *
     * @param descripcion atributo de la clase servicio
     * @param mecanico atributo de la clase servicio
     * @param tipo atributo de la clase servicio que contiene los enums del tipo de servicio
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Getter del atributo descripcion
     * @return la descripcion del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atributo descripcion
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo mecanico
     * @return el nombre del mecanico del taller
     */

    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atributo mecanico
     * @param mecanico
     */

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo tipo
     * @return el tipo del servicio
     */
    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     * @param tipo
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString para mostrar los datos del servicio
     * @return texto formateado con los datos del servicio
     */
    @Override
    public String toString() {
        return String.format("Descripcion: %s%nMecanico: %s, Tipo: %s%n", this.descripcion, this.mecanico, this.tipo);
    }
}
