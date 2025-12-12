package proyecto_02.clases;

import proyecto_02.enums.TipoServicio;
/**
 * Clase que representa servicios dentro del sistema del taller
 * Contiene información básica: Matrícula, Modelo y Tipo de vehículo
 * @author Alumno - Sergio Navarro
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipoServicio;

    /**
     * Constructor con paramertros para crear una clase libro completa
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
     * Getter del atributo Descripcion
     * @return Devuelve la descripción del coche
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la Descripción, asigna una descripción a un coche
     * @param descripcion Establece una descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo Mecanico
     * @return Devuelve el mecánico del coche
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del Mécanico, asigna un Mecánico a un coche
     * @param mecanico Establece un mecánico
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo TipoServicio
     * @return Devuelve el tipo de servio
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Setter del tipo de servicio, asigna un servicio a un coche
     * @param tipoServicio Establece un servicio
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Metodo para mostrar los datos del servicio
     * @return datos del servicio
     */
    @Override
    public String toString() {
        return String.format("Descripción: %s, Mécanico: %s, TipoServicio: %s", this.descripcion, this.mecanico, this.tipoServicio);
    }
}
