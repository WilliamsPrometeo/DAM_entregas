package taller_mecanico.clases;

import taller_mecanico.enums.TipoServicio;

/**
 * Clase Servicio
 * @author Pablo Sanchez
 * @version 1.0
 */

public class Servicio {

    private String descripcion;
    private String mecanico;
    private TipoServicio tipoServicio;

    public Servicio(String descripcion, String mecanico, TipoServicio tipoServicio) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Getter del atributo Descripcion
     *
     * @return descripcion de vehiculos
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param descripcion que establece la descripcion del problema del vehiculo
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo Mecanico
     *
     * @return mecanicos
     */

    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param mecanico que establece los mecanicos
     */

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo TipoServicio
     *
     * @return servicios disponibles mediante un enum
     */

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param tipoServicio que establece los tipos de servicio que hay mediante un enum
     */

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Metodo toString
     * @return la información del servicio
     */

    @Override
    public String toString() {
        return String.format("Tipo de Servicio: %s, mecánico: %s, descripción de avería: %s", tipoServicio, this.mecanico, this.descripcion);
    }
}
