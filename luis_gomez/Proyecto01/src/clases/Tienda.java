package clases;

import exceptions.VideojuegoException;

import java.util.ArrayList;

// Clase que tiene un array de la clase videojuegos
public class Tienda {
    ArrayList<Videojuego> catalogo;

    public Tienda() {
        catalogo = new ArrayList<>();
    }

    public ArrayList<Videojuego> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Videojuego> catalogo) {
        this.catalogo = catalogo;
    }

    // Función que añade un videojuego que le pases por parámetro
    public void anyadirVideojuego(Videojuego videojuego) {
        catalogo.add(videojuego);
    }

    // Función que lista todos los videojuegos que hay en el catálogo, si no hay videojuegos no lista nada
    public void listarVideojuego() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay videojuegos que mostrar.");
        }else{
            for (Videojuego videojuego : catalogo) {
                System.out.println(videojuego.toString());
            }
        }
    }

    // Función que busca por un id que le pases por parámetro en el catálogo de videojuegos
    public Videojuego buscarPorId(int id){
        for (Videojuego videojuego : catalogo) {
            if(videojuego.getId() == id){
                return videojuego;
            }
        }
        return null;
    }

    // Función para eliminar por un id que le pases por parámetro, primero busca si existe el id, si es así lo borra, sino salta una excepción
    public boolean eliminarPorId(int id) throws VideojuegoException {
        Videojuego videojuego = buscarPorId(id);
        if (videojuego != null) {
            catalogo.remove(videojuego);
        }else{
            throw new VideojuegoException("No existe el videojuego con el id " + id);
        }
        return true;
    }
}
