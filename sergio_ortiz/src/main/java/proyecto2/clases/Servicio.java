package proyecto2.clases;

import recursos.TipoVehiculo;
//se meten los enum dentro de las clases
public class Servicio {
    private String descripcion;
    private String mecanico;
    private TipoVehiculo tipoVehiculo;

    //Aqui ponemos que la clase servicio contenga los enums de Tipo Servicio
    public Servicio (String descripcion, String mecanico, TipoVehiculo tipoVehiculo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipoVehiculo = tipoVehiculo;
}
        public String getDescripcion() {
        return descripcion;
    }
        public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        }
        public String getMecanico() {
        return mecanico;
        }
        public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
        }
        public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
        }
        public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        }

}