package proyecto_02.Clases;

import proyecto_02.enums.TipoServicio;

public class Servicio {
    String descripcion;
    String mecanico;
    TipoServicio tipo;

    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
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

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("Servicio: %nDescripcion: %s, Mecanico: %s, Tipo: %s", this.descripcion, this.mecanico, this.tipo );
    }
}
