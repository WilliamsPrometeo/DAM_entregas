package proyecto2.clases;

import proyecto2.enums.TipoServicio;
/**
 * Autor: Luis Gabriel Maturana
 *
 * Esta clase sirve para las arraylist y que cuando el cliente quiera registrar un servicio
 * podamos guardarlo
 *
 *
 */

/***
 *Aqui tenemos los atributos de esta entidad
 **/

public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoServicio tipoServi;
    /***
     *Un constructor vacio
     **/

    public Servicio() {
    }
    /***
     *Constructor principal de la clase Servicio
     *descripcion
     * mecanico
     * y el tipo de servicio
     **/
    public Servicio(String descripcion, String mecanico, TipoServicio tipoServi) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoServi = tipoServi;
    }
    /***
     *Getter de descripcion
     * @return la descripcion del servicio
     **/

    public String getDescripcion() {
        return descripcion;
    }
    /***
     *Setter de descripcion
     * @param descripcion Descripcion del servicio
     **/

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /***
     *Getter de Mecanico
     * @return El nombre del mecanico
     **/
    public String getMecanico() {
        return mecanico;
    }
    /***
     *Setter de Mecanico
     * @param mecanico Para asignar el nombre del mecanico
     **/
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }
    /***
     *Getter de tipo servicio
     * @return El tipo de servicio que elige el cliente
     **/
    public TipoServicio getTipoServi() {
        return tipoServi;
    }
    /***
     *Setter de tipo servicio
     * @param tipoServi para asignar el tipo de servicio
     **/

    public void setTipoServi(TipoServicio tipoServi) {
        this.tipoServi = tipoServi;
    }
    /***
     *Metodo sobreescrito para mostrar los datos de servicio
     * @return datos del servicio
     *
     **/
    @Override
    public String toString() {
        return "Servicio{" +
                "descripcion='" + descripcion + '\'' +
                ", mecanico='" + mecanico + '\'' +
                ", tipoServi=" + tipoServi +
                '}';
    }
}
