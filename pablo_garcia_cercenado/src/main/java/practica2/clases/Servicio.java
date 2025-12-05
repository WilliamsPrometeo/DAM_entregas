package practica2.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Clase Servicio
 *
 * @author : Pablo María García
 * @version : 1.0
 */
public class Servicio {
    private String descripcion;
    private String mecanico;
    private String tipoServicios;
    private LocalDateTime fecha_servicio;

    /**
     * constructor vacio para inicializar el LocalDateTime
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        fecha_servicio = LocalDateTime.now();
    }

    /**
     * constructor principal de la clase Servicio, inicializa los parámetros principales
     * @param descripcion
     * @param mecanico
     * @param tipoServicios
     */
    public Servicio(String descripcion, String mecanico, String tipoServicios) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoServicios = tipoServicios;
        fecha_servicio = LocalDateTime.now();
    }

    /**
     * getter de la clase Servicio, devuelve la descripcion de dicho servicio
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * setter de la clase Servicio, permite modificar la descripción del servicio
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * getter de la clase Servicio que devuelve el nombre del mecanico que prestó el servicio
     * @return mecanico
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * setter de la clase Servicio que permite decidir el nombre del mecanico que prestó el servicio
     * @param mecanico
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * getter de la clase Servicio que devuelve el tipo de servicio prestado de entre los presentes en la lista
     * @return tipoServicios
     */
    public String getTipoServicios() {
        return tipoServicios;
    }

    /**
     * setter de la clase Servicio que permite introducir en la lista un servicio que se va a prestar
     * @param tipoServicios
     */
    public void setTipoServicios(String tipoServicios) {
        this.tipoServicios = tipoServicios;
    }

    /**
     * getter de la clase Servicio que devuelve la fecha en la que se realizó dicho servicio
     * @return fecha_servicio
     */
    public LocalDateTime getFecha_servicio() {
        return fecha_servicio;
    }

    /**
     * setter de la clase Servicio que permite decidir la fecha en la que prestó el servicio
     * @param fecha_servicio
     */
    public void setFecha_servicio(LocalDateTime fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    /**
     * metodo toString que devuelve un String con todos los parámetros de la clase formateados
     * @return String
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_servicio().format(dtf);
        return String.format("Descripcion: %s, Mecanico: %s, TipoServicios: %s, Fecha Servicio: %s", descripcion, mecanico, tipoServicios, fecha_formateada);
    }

    /**
     * metodo equals, compara si el objeto introducido pertenece a la clase Servicio
     * @param o   the reference object with which to compare.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(descripcion, servicio.descripcion) && Objects.equals(mecanico, servicio.mecanico) && Objects.equals(tipoServicios, servicio.tipoServicios) && Objects.equals(fecha_servicio, servicio.fecha_servicio);
    }

    /**
     * metodo hashCode, devuelve el hashcode de todos los parametros de la clase Servicio
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(descripcion, mecanico, tipoServicios, fecha_servicio);
    }
}
