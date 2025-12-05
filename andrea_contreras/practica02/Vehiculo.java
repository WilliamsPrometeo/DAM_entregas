package practica02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Vehiculo
 *
 * @author Alumna - Andrea
 * @version 1.0
 */

public class Vehiculo {

    private String matricula;
    private String modelo;
    private String tipoVehiculo;
    private String tipos;
    private LocalDateTime fecha_alta;

    /**
     * Contructor vacio
     */
    public Vehiculo() {
    }

    /**
     * Constructor principal de la clase Vehículo
     * @param tipoVehiculo Enumeracion de los tipos de Vehiculo
     * @param modelo Modelo del Vehiculo
     * @param matricula Matricula del Vehiculo
     */

    public Vehiculo(String tipoVehiculo, String modelo, String matricula) {
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fecha_alta = LocalDateTime.now();
    }

    /**
     * Getter del atributo Matricula
     * @return Matricula
     */

    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atributo Matricula
     * @param matricula
     */

    public void setMatricula(String matricula) {

        this.matricula = matricula;
    }

    /**
     * Getter del atributo Modelo
     * @return modelo
     */

    public String getModelo() {

        return modelo;
    }

    /**
     * Setter del atributo Modelo
     * @param modelo
     */

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    /**
     * Getter del atributo TipoVehiculo
     * @return TipoVehivulo
     */

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Setter del atributo TipoVehiculo
     * @param tipoVehiculo Enumeracion para establecer el tipo de vehiculo
     */

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Getter del atributo TipoVehiculo
     * @return tipos
     */

    public String getTipos() {
        return tipos;
    }

    /**
     * Setter del atributo TipoVehiculo
     * @param tipos
     */

    public void setTipos(String tipos) {
        this.tipos = tipos;
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
     * Metodo formateado para mostrar los datos del Vehiculo
     *
     * @return datos del vehiculo
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Vehiculo: %s, Matricula: %s, Modelo: %s", matricula, modelo, tipoVehiculo, fecha_formateada);
    }

    /**

     *Compara este objeto con otro.*
     *@param "Object" objeto a comparar con este.
     *@return true si las matriculas tienen los mismos valores y false en caso contrario.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        return getMatricula() != null ?getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;
    }

    /**
     *Devuelve el código hash de la matricula
     *@return retorna la matricula
     */

    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode() : 0;
    }
}
