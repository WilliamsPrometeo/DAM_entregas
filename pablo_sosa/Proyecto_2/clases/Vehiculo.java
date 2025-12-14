/**
 * La clase vehiculo contiene matricula, modelo y tipo.
 * @author Pablo Sosa
 * @version 1.0
 **/

package clases;

import enums.TipoVehiculo;

public class Vehiculo {
  private static String matricula;
  private static String modelo;
  private static TipoVehiculo tipo;

    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
      this.matricula = matricula;
      this.modelo = modelo;
      this.tipo = tipo;


  }
/**
 * Getters y setters
 */
      public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = tipo;
    }

    /**
     * Metodo toString para mostrar los datos del vehiculo
     *
     * @return texto formateado con los datos del vehiculo
     */
    @Override
    public String toString() {
        return "Vehiculo:\n" +
                "\tMatricula: '" + matricula + "'\n" +
                "\tModelo: '" + modelo + "'\n" +
                "\tTipo: " + tipo;
        }
}
