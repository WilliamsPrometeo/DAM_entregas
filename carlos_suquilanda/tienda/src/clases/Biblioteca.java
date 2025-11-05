package clases;

import java.util.ArrayList;

//Aqui creamos los metodos que usaremos más tarde en el menú y el ArrayList que almacenara todos los videojuegos que añadamos.

public class Biblioteca {
    ArrayList<Videojuegos> ListaVideojuegos;
    public Biblioteca() {
        ListaVideojuegos = new ArrayList();
    }

    public ArrayList<Videojuegos> getListaVideojuegos() {
        return ListaVideojuegos;
    }

    public void setListaVideojuegos(ArrayList<Videojuegos> listaVideojuegos) {
        this.ListaVideojuegos = listaVideojuegos;
    }

    public void RegistrarVideojuego(Videojuegos videojuegos) {
        ListaVideojuegos.add(videojuegos);
    }

    public void MostrarVideojuegos() {
        if (ListaVideojuegos.isEmpty()) {
            System.out.println("No hay ningún videojuego que mostrar en estos momentos");
        }else {
            for (Videojuegos item : ListaVideojuegos) {
                System.out.println(item);
            }
        }
    }

    public Videojuegos BuscarVideojuego(int id) {
        for (Videojuegos item : ListaVideojuegos) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean EliminarVideojuego(int id) throws VideojuegoExeption {
        Videojuegos videojuegos = BuscarVideojuego(id);
        if (videojuegos != null) {
            ListaVideojuegos.remove(videojuegos);
        } else {
            throw new VideojuegoExeption("Ese videojuego no esta registrado ⛔");
        }
        return true;
    }
}
