import java.util.ArrayList;

public class Parking {
    /*
        Atributos:
            listaVehiculos - Lista de Vehículos
    */
    ArrayList<Vehiculo> listavehiculos;


    // Constructor vacío donde inicializamos la lista
    public Parking() {
        listavehiculos = new ArrayList<>();
    }
    // Getters y Setters

    public ArrayList<Vehiculo> getListavehiculos() {
        return listavehiculos;
    }

    public void setListavehiculos(ArrayList<Vehiculo> listavehiculos) {
        this.listavehiculos = listavehiculos;
    }

    // Métodos
    /*
        registrarVehiculo
            - Añade un vehículo
        @params Vehiculo
     */
    public void registrarVehiculo(Vehiculo item){
        listavehiculos.add(item);
    }

    /*
        listarVehiculo
            - Muestra la lista de vehículos
     */

    public void listarVehiculos(){
        if(listavehiculos.isEmpty()){
            System.out.println("No hay vehiculos que mostrar");

        }else{
            for (Vehiculo item : listavehiculos) {
                System.out.println(item+"\n");
            }
        }
    }
    /*
        buscarPorId
            - Busca un vehículo por ID
        @params id
        @return Vehiculo
     */
    public Vehiculo buscarVehiculo(int id){
     Vehiculo vehiculo = null;
        for (Vehiculo item : listavehiculos) {
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }
    /*
        eliminarPorId
            - Elimina un vehículo por ID
        @params id
        @return boolean
     */
    public boolean eliminarVehiculo(int id){

        for (Vehiculo item : listavehiculos) {
            if(item.getId()==id){
                listavehiculos.remove(item);
                System.out.println("Vehiculo eliminado");
                return true;
            }
        }
        return false;
    }
}