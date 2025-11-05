package clases;

import clases.tiendavideojuegos.exception.VideojuegoException;

import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuego> listaVideojuegos;

    public Tienda() {
        listaVideojuegos = new ArrayList<>();
    }

    public ArrayList<Videojuego> getListaVidejuegos() {
        return listaVideojuegos;
    }

    public void setListaVideojuegos(ArrayList<Videojuego> listaVehiculos) {
        this.listaVideojuegos = listaVehiculos;
    }

    public void registrarVideojuegos(Videojuego videojuego) {
        listaVideojuegos.add(videojuego);
    }

    public void listarVideojuegos() {
        if (listaVideojuegos.isEmpty()){
            System.out.println("No hay videojuegos.");
        } else {
            for(Videojuego item : listaVideojuegos){
                System.out.println(item.toString());
            }
        }
    }

    public Videojuego buscarPorId (int id){

        for(Videojuego item : listaVideojuegos){
            if(item.getId() == id){
                return item;
            }
        }

        return null;
    }

    public boolean eliminarPorId (int id) throws VideojuegoException {

        Videojuego videojuego = buscarPorId(id);
        if(videojuego != null){
            listaVideojuegos.remove(videojuego);
        } else {
            throw new VideojuegoException("No existe ese videojuego!");
        }

        return true;
    }
}