package proyecto2.clases;

/**
 * Clase Servicio
 * Autor: Lobo
 * Version 1.0
 */

import recursos.TipoServicio;

public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio TipoServicio;

    public Servicio(String descripcion, String mecanico, TipoServicio tipoServicio) { //constructor
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.TipoServicio = tipoServicio;
    }

    //getters and setters
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
        return TipoServicio;
    }

    public void setTipoServicio(TipoServicio TipoServicio) {
        this.TipoServicio = TipoServicio;
    }

    @Override //override, declaramos el formato de la opcion mostrar trabajos
    public String toString() {
        return String.format(
                "Trabajo:\n\tDescripcion: %s\n\tMecanico: %s\n\tTipo: %s",
                this.descripcion, this.mecanico, this.TipoServicio);
    }
}
