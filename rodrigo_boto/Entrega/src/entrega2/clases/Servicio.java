package entrega2.clases;

import entrega2.enums.TipoServicio;


/**
 * Clase Servicio
 * @author Rodrigo Boto
 * @version 1.0
 */

public class Servicio{
    //Atributos privados
    private String descripcion;
    private String mecanico;
    TipoServicio tipo;

    //Constructores

    /**
     * Constructor principal y vacío de la clase servicio
     *
     * @param descripcion establece la descripción del servicio
     * @param mecanico establece el mecánico del servicio
     * @param tipo establece el tipo de servicio realizado
     */

    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    public Servicio() {
    }

    //Getters y Setters

    /**
     * Getter del atributo descripción
     *
     * @return el la descripción del servicio
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atributo descripcion
     *
     * @param descripcion establece la descripcion del servicio
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo mecanico
     *
     * @return el mecanico asignado
     */

    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atributo mecanico
     *
     * @param mecanico establece el mecanico del servicio
     */

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo tipo
     *
     * @return el tipo de servicio
     */

    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo tipo
     *
     * @param tipo establece el tipo de servicio hecho (de la enumeración)
     */

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para mostrar los datos de el servicio
     *
     * @return texto formateado con los datos del servicio
     */

    @Override
    public String toString() {
        return String.format("Descripción: %s, Mecánico: %s, Tipo de servicio: %s%n", this.descripcion, this.mecanico, this.tipo);
    }
}
//