package clases;

import recursos.TipoServicio;

/**
 * Clase Servicio
 * @author Adam Perez -Alumno
 * @version 1.0
 */

public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * COnstructor principal de la clase servicio
     * @param descripcion String con la descripcion del servicio
     * @param mecanico String con el mecanicpo del servicio
     * @param tipo Enum con el tipo de servicio
     */

    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Getter del atributo descripcion
     * @return descripcion del servicio
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atributo descripcion
     * @param descripcion String con la descripcion del servicio
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo mecanico
     * @return String con el mecanico del servicio
     */

    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atributo mecanico
     * @param mecanico String con el mecanico del servicio
     */

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo tipo
     * @return Enum con el tipo de servicicio
     */

    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     * @param tipo El tipo de servicio realizado
     */

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString de la clase
     * @return Texto formateado con la informacion del servicio
     */

    @Override
    public String toString() {
        return String.format("Mecanico: %s%nTipo de servicio: %s%nDescripcion: %s%n", this.mecanico, this.tipo, this.descripcion);
    }
}
