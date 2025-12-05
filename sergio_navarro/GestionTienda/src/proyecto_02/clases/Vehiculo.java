package proyecto_02.clases;

import proyecto_02.enums.TipoVehiculo;

/**
 * Clase que representa un vehículo dentro del sistema del taller
 * Contiene información básica: Matrícula, Modelo y Tipo de vehículo
 * @author Alumno - Sergio Navarro
 * @version 1.0
 */
public class Vehiculo {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;

    /**
     * Constructor con paramertros para crear una clase libro completa
     * @param matricula
     * @param modelo
     * @param tipoVehiculo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Constructor de vehiculo vacio
     */
    public Vehiculo() {

    }

    /**
     * Getter del atributo Matricula
     * @return Devuelve la matrícula del coche
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter de la Matricula, asigna una matrícula a un coche
     * @param matricula Establece una matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo Modelo
     * @return Devuelve la modelo del coche
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del Modelo, asigna un Modelo a un coche
     * @param modelo Establece una matricula
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Setter del TipoVehiculo, asigna un tipo de vehículo a un coche
     * @param tipoVehiculo Establece un tipo de vehículo
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Metodo sobreescrito de la clase para mostrar los datos del coche
     * @return datos del coche
     */
    @Override
    public String toString() {
        return String.format("Matrícula: %s, Modelo: %s, Tipo: %s", this.matricula, this.modelo, this.tipoVehiculo);
    }

    /**
     * Determina si dos vehículos son iguales comparando su Matrícula
     * @param o Objeto a comparar
     * @return true si la Matricula coincide, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        return getMatricula() != null ? getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;
    }

    /**
     * Calcula el hashCode usando la Matrícula
     * Si equals compara matrículas, hashCode debe hacerse también con la matrícula
     * @return hash basado en la matrícula
     */
    @Override
    public int hashCode() {
        return getMatricula() != null ? getMatricula().hashCode() : 0;
    }
}
