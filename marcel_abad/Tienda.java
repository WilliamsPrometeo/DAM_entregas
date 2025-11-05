package Clases;

import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuegos> listaVideojuegos;

    public Tienda() {listaVideojuegos = new ArrayList<>();}

    public ArrayList<Videojuegos> getListaVideojuegos() {return listaVideojuegos;}
    public void setListaVideojuegos(ArrayList<Videojuegos> listaVideojuegos) {this.listaVideojuegos = listaVideojuegos;}

    public void registrarVideojuegos(Videojuegos videojuego) {listaVideojuegos.add(videojuego);}

    public void listarVideojuegos() {
        if (listaVideojuegos.isEmpty()) {
            System.out.println("No hay videojuegos registrados");
        } else {
            for (Videojuegos videojuego : listaVideojuegos) {System.out.println(videojuego);}
        }
    }

    public Videojuegos buscarPorId(double id) throws Videojuegos_Exception {
        for (Videojuegos videojuego : listaVideojuegos) {
            if (videojuego.getId() == id){return videojuego;}
        }
        return null;
    }

    public boolean eliminarPorId(double id) throws Videojuegos_Exception {
        Videojuegos videojuego = buscarPorId(id);
        if (videojuego != null) {listaVideojuegos.remove(videojuego);}
        else {throw new Videojuegos_Exception("No existe el videojuego!!");}
        return true;
    }
}
