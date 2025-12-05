package clases;

import enums.TipoVehiculo;

import java.util.Objects;

/**
 * Clase que representa un vehículo registrado en el taller.
 */
public class Vehiculo {

    private String matricula;
    private static String modelo;
    private TipoVehiculo tipo;

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public static String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public TipoVehiculo getTipoVehiculo() { return tipo; }
    public void setTipo(TipoVehiculo tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Vehiculo{matricula='%s', modelo='%s', tipo=%s}".formatted(
                matricula, modelo, tipo
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo v = (Vehiculo) o;
        return Objects.equals(this.matricula, v.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
