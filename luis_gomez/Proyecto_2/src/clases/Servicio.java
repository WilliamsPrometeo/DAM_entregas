package clases;

import enums.TipoServicio;

/**
 * Clase servicio
 *
 * @author Alumno - Luis
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor vacio de la clase Servicio
     */
    public Servicio() {
    }

    /**
     * Constructor principal de la clase Servicio
     *
     * @param descripcion la descripcion del servicio
     * @param mecanico el nombre del mecanico del servicio
     * @param tipo enumeracion para establecer el tipo de servicio
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Getter del atributo descripcion
     *
     * @return la descripcion del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atributo descricion
     *
     * @param descripcion establece la descripcion del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo mecanico
     *
     * @return el nombre del mecanico del servicio
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atributo mecanico
     *
     * @param mecanico establece el nombre del mecanico del servicio
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo tipo
     *
     * @return el tipo de servicio
     */
    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo servicio
     *
     * @param tipo establece el tipo de servicio
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString para mostrar los datos del servicio
     *
     * @return texto formateado con los datos del servicio
     */
    @Override
    public String toString() {
        return String.format("Servicio: %s, mecanico: %s, tipo: %s", this.descripcion, this.mecanico, this.tipo);
    }
}
