package proyecto2.clases;

import enums.TipoServicio;

/**
 * Por este lado declaramos descripcion mecanico y tipoServicio, y los acompañamos con sus
 * respectivos constructores, getters, setters y el toString
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

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return String.format("Descripcion: %s | Mecanico: %s | Tipo de Servicio: %s", this.descripcion, this.mecanico, this.tipoServicio);
    }
}
