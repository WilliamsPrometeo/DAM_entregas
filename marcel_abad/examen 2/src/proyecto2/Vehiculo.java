package proyecto2;

/**
 * La clase Vehiculo es una libreria que gestiona los Vehiculos,
 * @author Marcel Abad i Vilà
 * @version 1.0
 */

import proyecto2.enums.TipoVehiculo;


public class Vehiculo {

    //private static final MyScanner sc = new MyScanner();

    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;

    /**
     * Constructor que inicializa un libro con su matricula, modelo y tipoVehiculo.
     */

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehiculo() {

    }

    /**
     * Obtiene la matricula del vehiculo
     * @return matricula del Vehiculos
     */

    public String getMatricula() {
        return matricula;
    }

    /**
     * Modifica la matricula del vehiculo.
     * @param matricula nueva matricula
     */

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el modelo del vehiculo
     * @return el modelo del Vehiculos
     */

    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del vehiculo.
     * @param modelo nuevo modelo
     */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el tipoVehiculo de vehiculo
     * @return el tipoVehiculo del Vehiculos
     */

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Modifica el tipoVehiculo de vehiculo
     * @param tipoVehiculo nuevo tipoVehiculo de vehiculo
     */

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Sobrescribe el método toString() de Vehiculo para devolver
     * una descripción del vehiculo incluyendo su matricula su model y tipoVehiculo
     * @return texto con matricula, modelo y tipoVehiculo
     */

    @Override
    public String toString() {
        return String.format(
                "Vehiculo: %nMatricula: %s, Modelo: %s, Tipo:%s%n",
                this.matricula,
                this.modelo,
                this.tipoVehiculo
        );
    }

    /**
     * Compara dos vehciulos desde su matricula.
     * Si la matricula coincide, se considera el mismo vehiculo.
     * @param o objeto con el que comparar
     * @return true si las matriculas son iguales, false en caso contrario
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        return getMatricula () != null ?
                getMatricula().equals(vehiculo.getMatricula()) :
                vehiculo.getMatricula() == null;
    }

    /**
     * Genera el código hash del vehiculo basándose únicamente en su matricula.
     * @return hash calculado a partir de la matricula
     */

    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode () : 0;
    }
}
