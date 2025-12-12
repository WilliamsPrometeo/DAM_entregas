package proyecto2;

import proyecto2.enums.TipoServicio;

/**
 * La clase Servicio es una libreria que gestiona los servicios dados por el taller.
 * @author Marcel Abad i Vilà
 * @version 1.0
 */
public class Servicio {

    private String descripcion;
    private String mecanico;
    private TipoServicio tipoServicio;

    /**
     * Constructor que inicializa un servicio con la descripcion, el mecanico y el tipoServicio.
     * @param descripcion descripcion del servicio
     * @param mecanico mecanico del servicio
     * @param tipoServicio tipoServicio de servicio.
     */

    public Servicio(String descripcion, String mecanico, TipoServicio tipoServicio) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Constructor vacio de servicio.
     */
    public Servicio() {
    }

    /**
     * Obtiene la descripcion del servicio
     * @return la descripcion del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Establece una nueva la descripcion del servicio
     * @param descripcion nueva descripcion a asignar
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Obtiene el mecanico del servicio
     * @return el mecanico del servicio
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * Establece un nuevo mecanico
     * @param mecanico nuevo mecanico
     */

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }
    /**
     * Obtiene el tipo de servicio
     * @return el tipo de servicio
     */

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Establece un nuevo servicio
     * @param tipoServicio nuevo tipo de servicio
     */

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    /**
     * Sobrescribe el método toString() de servicio para devolver
     * una descripción del servicio incluyendo su descripcion su mecanico y tipo de Servicio
     * @return texto con descripcion, mecanico y tipoServicio
     */
    @Override
    public String toString() {
        return String.format(
                "Servicio: %nDescripción: %s, Mecanico: %s, Tipo de servicio: %s%n",
                this.descripcion,
                this.mecanico,
                this.tipoServicio
        );
    }
}
