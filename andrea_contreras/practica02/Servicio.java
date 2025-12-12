package practica02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Servicio
 *
 * @author Alumna - Andrea
 * @version 1.0
 */

public class Servicio {

    private String descripcion;
    private String mecanico;
    private TipoServicio tipoServicio;
    private LocalDateTime fecha_alta;

    /**
     * Constructor principal de la clase Servicio
     * @param descripcion descripcion del servicio
     * @param mecanico mecanico que realiza el servicio
     * @param tipoServicio Enumeracion de los servicios
     */

    public Servicio(String descripcion, String mecanico, TipoServicio tipoServicio) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoServicio = tipoServicio;
        this.fecha_alta = LocalDateTime.now();
    }

    /**
     * Getter del atributo Descripcion
     * @return descripcion
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter del atributo descripcion
     * @param descripcion descripcion del servicio
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del atributo Mecanico
     * @return mecanico
     */

    public String getMecanico() {
        return mecanico;
    }

    /**
     * Setter del atributo mecanico
     * @param mecanico mecanico que realiza cada servicio
     */

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter del atributo TipoServicio
     * @return tipoServicio
     */

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Setter del atributo TipoServicio
     * @param tipoServicio los servicios que se ofrecen
     */

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Getter del atributo fecha_alta
     * @return fecha_alta
     */

    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    /**
     * Setter del atributo fecha_alta
     * @param fecha_alta fecha alta
     */

    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /**
     * Metodo formateado para mostrar los datos del Servicio
     *
     * @return datos del servicio
     */

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Servicio: %s,Fecha alta: %s,  Descripción: %s, Tipo Servicio: %s", descripcion, mecanico, tipoServicio, fecha_formateada);
    }
}
