package clases;

import proyecto02.clases.enums.TipoServicio;

public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    public Servicio() {
    }

    public static void add(Servicio servicio) {
    }

    /**
     * Añado los getters and setters de la clase Servicio
     *
     *
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
}