package proyecto_02.clases;

import proyecto_02.enums.TipoServicio;
import proyecto_02.enums.TipoVehiculo;
/**
 *Clase servicio que representa un servicio en taller
 * @author ALUMNO -Alvaro Cotumba
 * @version 1.0
 */
public class Servicio {
    /**
     *
     * @param descripcion
     * @param mecanico
     * @param tipo
     */
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor principal de la clase servicio
     * Inicializa
     */
    public Servicio(){

    }

    /**
     *
     * @param descripcion
     * @param mecanico
     * @param tipo
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
    }

    /**
     * getter descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * setter descripcion
     * @param descripcion
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * getter Mecanico
     * @return mecanico
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * setter Mecanico
     * @param mecanico
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Metodo sobrescrito para cadena de texto
     * @return cadena formateada
     */
    @Override
    public String toString() {
        return String.format("Servicio: %descripcion: %s, mecanico: %s, Tipo Servicio: %s%n", this.descripcion, this.mecanico, this.tipo);
    }

}
