package proyecto2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
*Clases vehiculo
*realizo los getters and setters de la clases con lops diversos atributos de este
 */

public class Vehiculo {
        private String matricula;
        private String modelo;
        private String tipoVehiculo ;
        private LocalDateTime fecha_vehiculo;

    public Vehiculo() {
        this.matricula = matricula;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        fecha_vehiculo = LocalDateTime.now();
    }


    public Vehiculo(LocalDateTime fecha_vehiculo) {
        this.fecha_vehiculo = fecha_vehiculo;
    }

    /**
    *CONTINUO CON LOS GETERS AND SETTERS DE LOS PARAMETROS MODELO , MATRICULA Y TIPO
     */
    public String getMatricula() {
        return matricula;
    }
/**
*EL SETTER DE LA CLASE VEHICULO DEVUELVE EL ATRIBUTO MATRICULA
 */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
/** LO MISMO CON LOS DEMAS ATRIBUTOS DE LA CLASE VEHICULO
 */
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoVehiculo() {
        return  tipoVehiculo;
    }

    public void setTipoVehiculo(String ingreseTipoDeVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * EN ESTE CASO EL METODO TO STRING REALIZA EL FORMATEO DE LOS DATOS INTRODUCIDOS Y LOS DEVUELVE EN UN RETURN
     * @return
     */
    @Override
    public String toString() {
        DateTimeFormatter o = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada=o.format(fecha_vehiculo);
        return String.format("matricula %s modelo %s Tipo %s ", matricula, modelo, tipoVehiculo);
    }

}


