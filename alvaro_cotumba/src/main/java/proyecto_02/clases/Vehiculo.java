package proyecto_02.clases;

import proyecto_02.enums.TipoServicio;
import proyecto_02.enums.TipoVehiculo;

import java.time.LocalDateTime;

/**
 *Clase Vehiculo que representa un vehiculo en taller
 * @author ALUMNO -Alvaro Cotumba
 * @version 1.0
 */
public class Vehiculo extends Servicio {


    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor principal de la clase vehiculo
     * Inicializa
     */
    public Vehiculo(){
    }

    /**
     *
     * @param matricula
     * @param modelo
     * @param tipo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    /**
     *
     * @param matricula
     * @param tipoServicio
     */
    public Vehiculo(String matricula, TipoServicio tipoServicio) {
    }

    /**
     *getter matricula
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *setter matricula
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *getter modelo
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *setter modelo
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * getter TipoVehiculo
     * @return TipoVehiculo
     */
    public TipoVehiculo geTipoVehiculo() {
        return tipo;
    }

    /**
     *setter  tipo
     * @param tipo
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo sobrescrito para cadena de texto
     * @return cadena formateada
     */
    @Override
    public String toString() {
        return String.format("Vehiculo: %Matricula: %s, Modelo: %s, Tipo Vehiuclo: %s%n", this.matricula, this.modelo, this.tipo);
    }
}
