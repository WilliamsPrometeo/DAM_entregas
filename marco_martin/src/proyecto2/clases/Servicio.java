package proyecto2.clases;

import enums.TipoServicio;

/**
 * Clase Servicio
 * @author Alumno-Marco Martín
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipoServicio;


    /**
     * Constructor principal de la clase Servicio
     * @param descripcion
     * @param mecanico
     * @param tipoServicio
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipoServicio) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Getter de la descripcion del servicio
     * @return la descripcion del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Setter de la descripcion del servicio
     * @return la descripcion del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Getter del mecanico del servicio
     * @return el mecanico del servicio
     */
    public String getMecanico() {
        return mecanico;
    }
    /**
     * Setter del mecanico del servicio
     * @return el mecanico del servicio
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }
    /**
     * Getter del tipo de servicio
     * @see TipoServicio
     * @return el tipo de servicio
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
    /**
     * Setter del tipo de servicio
     * @see TipoServicio
     * @return el tipo de servicio
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Metodo toString de la clase
     * @return la informacion del servicio
     */
    @Override
    public String toString() {
        return String.format("Servicio: %s, Descripción del servicio: %s, Mecánico: %s \n", tipoServicio, descripcion, mecanico);
    }
}
