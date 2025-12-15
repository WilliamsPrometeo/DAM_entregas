package proyecto_02.clases;

import clases.proyecto_02.enums.TipoServicio;

/**
 * clase del Servicio
 * @author A4Alumno05 - Pedregosa
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor principal de la clase servicio
     * @param descripcion descripcion del servicio
     * @param mecanico quien realizo el servicio
     * @param tipo tipo de servicio realizado
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * getter del atributo Descripcion
     * @return la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * setter del atributo descripcion
     * @param descripcion establece la descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * getter delmetodo Mecanico
     * @return el mecanico
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * setter del metodo Mecanico
     * @param mecanico establece al mecanico
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * getter del atributo Tipo
     * @return el tipo del servicio
     */
    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * setter del atributo Tipo
     * @param tipo estabelce el tipo de servicio
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * metodo sobreescrito para mostrar los datos del servico
     * @return datos del servicio
     */
    @Override
    public String toString() {
        return String.format("Servicio: %nServicio: %s %nMecanico: %s %nTipo: %s", descripcion, mecanico, tipo);
    }
}
