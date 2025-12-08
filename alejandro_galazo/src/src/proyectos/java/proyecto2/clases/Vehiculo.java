package proyecto2.clases;

import proyecto2.enums.TipoVehiculo;
import java.util.Map;
import java.util.HashMap;
/**
 * Clase Vehiculo
 *
 * @author Alumno-Alejandro
 * @version 1.0
 */

public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor principal de la clase Empleado
     * Inicializamos el atributo fecha_alta con la fecha del momento de la creación
     *
     * @param matricula
     * @param modelo
     * @param tipo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * Constructor vacio

     */
    public Vehiculo() {

    }

    /**
     * Getter del atributo Matricula
     *
     * @return el número identificativo de la matricula
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * setter del atributo Matricula
     *
     * @param matricula establece el número identificativo de la matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * Getter del atributo modelo
     *
     * @return el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * setter del atributo modelo
     *
     * @param modelo establece modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo Tipo
     *
     * @return el tipo de vehiculo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }
    /**
     * Setter del atributo Num_Empleado
     *
     * @param tipo establece el número identificativo del empleado
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo toString para mostrar los datos del vehiculo
     *
     * @return texto formateado con los datos del vehiculo
     */
    @Override
    public String toString() {
        return String.format("Vehiculo: %nMatricula: %s, %Marca: %s, Tipo: %s%n", this.matricula, this.modelo, this.tipo);
    }

    /*
     if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Producto producto = (Producto) o;

    return this.nombre != null ? this.nombre.equals(producto.nombre) : producto.nombre == null;
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;


        return this.getMatricula() != null ? this.getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;
    }

    /*
    return nombre ! = null ? nombre.hashCode
     */

    @Override
    public int hashCode() {return matricula != null ? matricula.hashCode() : 0;}

}

