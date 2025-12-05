package proyecto2.clases;

import recursos.TipoVehiculo;
//En esta clase se registran los enums de Tipo vehiculo
public class Vehiculo<Matricula> {
    private String matricula;
    private String modelo;
    TipoVehiculo tipo;

    public Vehiculo(String marca, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }
    public String getmatricula() {
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
        return String.format("Marca: %s, Modelo: %s, Tipo: %s", matricula, modelo, tipo);
    }

}