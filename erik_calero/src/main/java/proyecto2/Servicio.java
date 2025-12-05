package proyecto2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Servicio {
    private String  mecanico;
    private String  descripcion;
    private ArrayList<Tiposervicio> tiposervicios = new ArrayList<>();
    private LocalDateTime fecha_vehiculo;

    /**
     * aplico un construcctor vacio para inicalizar el LocalDateTime
     */
    public Servicio(){
        fecha_vehiculo = LocalDateTime.now();
    }

    /**
     * realizo el constructor con los atributos marcados por el clase sericio

     * @param mecanico
     * @param descripcion
     * @param tiposervicios
     */
    public Servicio(String mecanico, String descripcion, ArrayList<Tiposervicio> tiposervicios) {
        this.mecanico = mecanico;
        this.descripcion = descripcion;
        this.tiposervicios = tiposervicios;
        fecha_vehiculo = LocalDateTime.now();
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFecha_vehiculo() {
        return fecha_vehiculo;
    }

    public void setFecha_vehiculo(LocalDateTime fecha_vehiculo) {
        this.fecha_vehiculo = fecha_vehiculo;
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

    public ArrayList<Tiposervicio> getTiposervicios() {
        return tiposervicios;
    }

    public void setTiposervicios(ArrayList<Tiposervicio> tiposervicios) {
        this.tiposervicios = tiposervicios;
    }
    @Override public   String toString(){
        DateTimeFormatter o = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fecha_formateada = getFecha_vehiculo().format(o);
        return  String.format("Descripcion %s: ,mecanico %s,tipo servicios %s fecha vehiculo %s",descripcion,mecanico,tiposervicios,fecha_formateada);

    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(mecanico, servicio.mecanico) && Objects.equals(descripcion, servicio.descripcion) && Objects.equals(tiposervicios, servicio.tiposervicios) && Objects.equals(fecha_vehiculo, servicio.fecha_vehiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mecanico, descripcion, tiposervicios, fecha_vehiculo);
    }
}

