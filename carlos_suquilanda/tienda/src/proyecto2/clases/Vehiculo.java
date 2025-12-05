package proyecto2.clases;

import enums.TipoVehiculo;

import java.util.Objects;

/**
 * Aqui declaramos todas nuestras variables matricula, modelo y tipoVehiculo, creamos sus respectivos constructores
 * getters, setters, un to String con String.format para hacerlo mejor y mas profesionalmente. Finalmente usamos un
 * equals and HashCode solo en la matricula para evitar posibles errores en el futuro
 */

public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;


    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehiculo() {

    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     *  Usamos el String.format para que sea mas elegante y facil de leer.
     */


    @Override
    public String toString() {
        return String.format("Matricula: %s | Modelo: %s | Tipo de Vehículo: %s", this.matricula, this.modelo, tipoVehiculo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }
}