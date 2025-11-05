package Proyecto_01.Clases;

import Clases.Proyecto_01.Exceptions.PrecioInvalidoException;

import java.util.ArrayList;

//se crea la tienda
public class Tienda {
    ArrayList<Videojuego> listaVideojuegos;

    //metodo que inicia la lista/ArrayList
    public Tienda(){

        listaVideojuegos = new ArrayList<>();
    }

    //los getters y setters lista de Videojuegos
    public ArrayList<Videojuego> getListaVideojuegos(){

        return listaVideojuegos;
    }

    public void setListaVehiculos(ArrayList<Videojuego> listaVideojuegos){

        this.listaVideojuegos = listaVideojuegos;
    }

    //metodo para agregar videojuegos a la lista
    public void agregarVideojuego(Videojuego videojuego){

        listaVideojuegos.add(videojuego);
    }

    //metodo para mostrar la lista de juegos
    public void listarVideojuegos(){

        //si la lista esta vacia, muestra esto
        if (listaVideojuegos.isEmpty()){
            System.out.println("No videojuegos encontrados... o nos los han robado");
        } else {

            for (Videojuego juego : listaVideojuegos) {
                System.out.println(juego);
            }
        }
    }

    //metodo para buscar los juegos por ID
    public Videojuego buscarVideojuegoPorID(int id){

        for (Videojuego juego : listaVideojuegos) {
            if(juego.getId() == id){
                return juego;
            }
        }

        return null;
    }

    //metodo para eliminar los juegos por ID
    public boolean eliminarVideojuegoPorID(int id) throws PrecioInvalidoException{

        Videojuego videojuego = buscarVideojuegoPorID(id);
        if (videojuego != null){
            listaVideojuegos.remove(videojuego);
        } else {
            throw new RuntimeException("El juego es tan malo, que ni lo tenemos, imaginate lo malo que es.");
        }

        return true;
    }
}
