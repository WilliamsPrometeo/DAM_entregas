package clases;

import proyecto02.clases.enums.TipoServicio;
import proyecto02.clases.enums.TipoVehiculo;

import java.util.ArrayList;

public class Vehiculo {
    public static TipoVehiculo getTipo;
    private String matricula;
    private String modelo;
    private TipoServicio tipo;

    MyScanner scanner = new MyScanner();

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String modelo, TipoServicio tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public static void put(String vehiculo, ArrayList<Servicio> catalogoServicios) {
    }

    /**
     * Añado los getters and setters de la clase Vehículos.
     * @return
     */

    public String getMatricula() {
        return null;
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

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public void setScanner(MyScanner scanner) {
        this.scanner = scanner;
    }
}


