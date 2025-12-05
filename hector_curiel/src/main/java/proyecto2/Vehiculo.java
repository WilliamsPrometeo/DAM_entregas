package proyecto2;

import enums.TipoVehiculo;

import java.util.Objects;

/**
 * Representa un vehículo del taller.
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }


    public Vehiculo() {}

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

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("Vehículo → Matrícula: %s | Modelo: %s | Tipo: %s",
                matricula, modelo, tipo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(getMatricula(), vehiculo.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }
}

