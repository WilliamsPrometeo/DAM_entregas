

/**
 * La clase servicio contiene descripción, mecanico y tipo de servicio.
 * @author Pablo Sosa
 * @version 1.0
 **/


package clases;

import enums.TipoServicio;

public class Servicio {
    private static String descripcion;
    private static String mecanico;
    private static TipoServicio tipo;

    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Getters y setters
     */

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /* Metodo toString para mostrar los datos del vehiculo*/
    /* @return texto formateado con los datos del vehiculo*/
    @Override
    public String toString() {
        return String.format("Datos del servicio: %s, %s, %d", this.descripcion, this.mecanico, this.tipo);
    }
}
