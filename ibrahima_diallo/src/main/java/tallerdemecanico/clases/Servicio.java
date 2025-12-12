package tallerdemecanico.clases;

import tallerdemecanico.enums.TipoServicio;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Clase Servicio
 *
 * @author Alumno - Ibra
 * @version 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private Map<String, TipoServicio> tipo = new LinkedHashMap<>();

    /**
     *
     * @param descripcion  atributo heredado
     * @param mecanico  heredado
     * @param tipo heredado
     * @see
     */
    public Servicio(String descripcion, String mecanico, Map<String, TipoServicio> tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Hago los metodos con el getter y setter
     */
    public Servicio() {

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

    public Map<String, TipoServicio> getTipo() {
        return tipo;
    }

    public void setTipo(Map<String, TipoServicio> tipo) {
        this.tipo = tipo;
    }

    /**
     * Muestro el formato con el override
     * @return
     */
    @Override
    public String toString() {
        return String.format("Descripcion: %s, Mecanico: %s, Tipo: %s", this.descripcion, this.mecanico, this.tipo);
    }
}
