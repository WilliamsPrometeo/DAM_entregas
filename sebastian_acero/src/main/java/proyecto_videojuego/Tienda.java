package proyecto_videojuego;

import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuego> ListaVideojuegos;

    public Tienda() {
        ListaVideojuegos = new ArrayList<>();
    }

    public ArrayList<Videojuego> getListaVideojuegos() {
        return ListaVideojuegos;
    }

    public void setListaVideojuegos(ArrayList<Videojuego> ListaVideojuegos) {
        this.ListaVideojuegos = ListaVideojuegos;
    }

    public void registrarVideojuego(Videojuego videojuego) {
        ListaVideojuegos.add(videojuego);
    }

    public void ListarVideojuegos() {
        if (ListaVideojuegos.isEmpty()) {
            System.out.println("No hay videojuegos que mostrar.");
        } else {
            for (Videojuego item : ListaVideojuegos) {
                System.out.println(item);
            }
        }
    }

    public Videojuego buscarPorId(double id) throws MyException {
        for (Videojuego item : ListaVideojuegos) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean eliminarPorid(double id) throws MyException {
        Videojuego videojuego = buscarPorId(id);
        if (videojuego != null) {
            ListaVideojuegos.remove(videojuego);
        } else {
            throw new MyException("No existe el videojuego.");
        }
        return true;
    }
}


