package proyecto_02.Clases;

import proyecto_02.enums.TipoVehiculo;

public class Vehiculo {
    String matricula;
    String modelo;
    TipoVehiculo tipo;

    /**
     * Constructor con parámetros de la clase Persona
     *
     * @param matricula establece la matricula del vehiculo
     * @param modelo establece el modelo de la persona
     * @param tipo establece el tipo de vehiculo
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }


    public Vehiculo() {
    }

    /**
     * Getter del atributo setMatricula
     *
     * @param la matricula del vehiculo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter del atributo setMatricula
     *
     * @return la matricula del vehiculo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter del atributo getModelo
     *
     * @return el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo setModelo
     *
     * @return el modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo getTipo
     *
     * @return el tipo de vehiculo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Setter del atributo fecha_alta
     *
     * @param setTipo establece el tipo de vehiculo
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Método toString que muestra los datos del vehiculo
     *
     * @return una cadena con el nombre del vehiculo, descripcion y tipo de servicio
     */
    @Override
    public String toString() {
        return String.format("Vehiculo: %nDescripcion: %s, Mecanico: %s, Tipo: %s", getMatricula(), getModelo(), getTipo());
    }

    /**
     * Método equals sobreescrito para comparar vehiculos por la matricula
     *
     * @param o objeto con el que se compara
     * @return true si los datos de matricula coinciden, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getMatricula() != null ? getMatricula().equals(vehiculo.getMatricula()) : vehiculo.getMatricula() == null;

    }

    /**
     * Método hashCode sobreescrito
     *
     * @return el código hash basado en la matricula del vehiculo
     */
    @Override
    public int hashCode() {
            return getMatricula() == null ? getMatricula().hashCode() : 0;
        }
    }
