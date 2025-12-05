package practica2.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Clase Vehiculo
 *
 * @author : Pablo María García
 * @version : 1.0
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private String tipo;
    private LocalDateTime fecha_vehiculo;
    /**
     * Constructor vacio para inicializar el LocalDateTime
     */
    public Vehiculo() {
        fecha_vehiculo = LocalDateTime.now();
    }

    /**
     * Constructor principal de la clase Vehiculo
     * @param matricula
     * @param modelo
     * @param tipo
     */
    public Vehiculo(String matricula, String modelo, String tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
        fecha_vehiculo = LocalDateTime.now();
    }

    /**
     * getter de la clase Vehiculo que devuelve la matricula del vehiculo en cuestion
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * setter de la clase Vehiculo que permite decidir la matricula del vehiculo en cuestion
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * getter de la clase vehiculo que devuelve el modelo del vehiculo
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * setter de la clase Vehiculo que permite decidir el modelo del vehiculo
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * getter del ArrayList TipoVehiculo, devuelve el elemento del mapa correspondiente al tipo de vehiculo
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * setter del ArrayList TipoVehiculo, permite introducir el tipo deseado dentro del Map
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * getter de la clase Vehiculo que devuelve la fecha en la que se reportó el vehiculo
     * @return fecha_vehiculo
     */
    public LocalDateTime getFecha_vehiculo() {
        return fecha_vehiculo;
    }

    /**
     * setter de la clase Vehiculo que permite decidir la fecha en la que se reportó el vehiculo
     * @param fecha_vehiculo
     */
    public void setFecha_vehiculo(LocalDateTime fecha_vehiculo) {
        this.fecha_vehiculo = fecha_vehiculo;
    }

    /**
     * metodo toString, formatea los datos introducidos y los devuelve en un formato adecuado
     * @return String
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_vehiculo().format(dtf);
        return String.format("Matricula: %s, Modelo: %s, Tipo: %s, Fecha formateada: %s", matricula, modelo, tipo,  fecha_formateada);
    }

    /** metodo equals, compara si el objeto introducido pertenece a la clase Vehiculo
     * @param o   the reference object with which to compare.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(tipo, vehiculo.tipo) && Objects.equals(fecha_vehiculo, vehiculo.fecha_vehiculo);
    }

    /**
     * metodo hashCode, devuelve el hashcode de todos los parametros de la clase Vehiculo
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricula, modelo, tipo, fecha_vehiculo);
    }

}