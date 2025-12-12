package proyecto2.clases;

import enums.TipoServicio;
/**
 * Clase Servicio
 *
 * @author Alumno - Cristian Peña

 */

public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;
    /**
     * Constructor principal de la clase Servicio

     *
     * @param descripcion   Descripcion del servicio
     * @param mecanico nombre del mecanico
     * @param tipo     Tipo de servicio
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }
    /**
     * Getter del atributo Descripcion
     *
     * @return la descripcion del servicio
     */

    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Setter del atribtuo Descripcion
     *
     * @param descripcion estable la descripcion del servicio
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Getter del atributo Mecanico
     *
     * @return el mecanico del servicio
     */
    public String getMecanico() {
        return mecanico;
    }
    /**
     * Setter del atributo Mecanico
     *
     * @param mecanico establece el mecanico del servicio
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }
    /**
     * Getter del atributo tipo
     *
     * @return tipo de servicio
     */
    public TipoServicio getTipo() {
        return tipo;
    }
    /**
     * Setter del atributo tipo
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
        return String.format("Servicio: %ndescripcion: %s, mecanico: %s, tipo: %s%n", descripcion, mecanico, tipo);
    }
    /**
     * Metodo equals para mostrar los datos del servicio
     *
     * @return para buscar por matricula
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servicio servicio = (Servicio) o;

        return this.descripcion != null ? this.descripcion.equals(servicio.descripcion) : servicio.descripcion == null;
    }
}
