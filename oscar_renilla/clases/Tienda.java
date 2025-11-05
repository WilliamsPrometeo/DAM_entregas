package clases;

import exceptions.TiendaVideojuegos;
import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuegos> listaVideojuegos;

    public Tienda() {
        listaVideojuegos = new ArrayList<>();
    }

    public ArrayList<Videojuegos> getListaVideojuegos() {
        return listaVideojuegos;
    }

    public void setListaVideojuegos(ArrayList<Videojuegos> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }

    public void registrarVideojuegos(Videojuegos videojuego){
            listaVideojuegos.add(videojuego);
        }

    public void listarVideojuego(){
        if (listaVideojuegos.isEmpty()){
            System.out.println("No hay Videojuegos que mostrar.");
        } else {
            for(Videojuegos item : listaVideojuegos){
                System.out.println(item);
            }
        }
    }

    public Videojuegos buscarPorId (int id){
        for(Videojuegos item : listaVideojuegos){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean eliminarPorId (int id) throws TiendaVideojuegos {
        Videojuegos videojuego = buscarPorId(id);
        if(videojuego != null){
            listaVideojuegos.remove(videojuego);
        } else {
            throw new TiendaVideojuegos("No existe ese videojuego!");
        }
        return true;
    }
}



