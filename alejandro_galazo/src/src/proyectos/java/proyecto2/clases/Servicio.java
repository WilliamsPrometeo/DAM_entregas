package proyecto2.clases;

import proyecto2.enums.TipoServicio;

/**
 * Clase Servicio
 *
 * @author Alumno-Alejandro
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor heredado de la clase Persona
     * Inicializamos el atributo fecha_alta con la fecha del momento de la creación
     *
     * @param descripcion
     * @param mecanico
     * @param tipo
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;

    }
    /**
     * Getter del atributo Descripcion
     *
     * @return el texto de descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * setter del atributo Descripcion
     *
     * @param descripcion establece la descripcion del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Getter del atributo Mecanico
     *
     * @return el empleado asignado
     */
    public String getMecanico() {
        return mecanico;
    }
    /**
     * setter del atributo Num_Empleado
     *
     * @param mecanico establece el empleado asignado
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }
    /**
     * Getter del atributo Tipo
     *
     * @return el tipo de servicio a realizar
     */
    public TipoServicio getTipo() {
        return tipo;
    }
    /**
     * setter del atributo Tipo_Servicio
     *
     * @param tipo establece el tipo de servicio que se realiza
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo toString para mostrar los datos del servicio
     *
     * @return texto formateado con los datos del servicio
     */
    @Override
    public String toString() {
        return String.format("Descripcion: %nMecanico: %s%nTipo: %s%n", this.descripcion, this.mecanico, this.tipo);
    }

}
