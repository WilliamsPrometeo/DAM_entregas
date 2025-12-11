package entrega1;

import java.util.ArrayList;
public class Tienda {
//GETTER Y SHETTERS
    ArrayList<Videojuego> lista_catalogos;

    public Tienda() {
        lista_catalogos = new ArrayList();
    }

    public ArrayList<Videojuego> getLista_catalogos() {
        return lista_catalogos;
    }

    public void setLista_catalogos(ArrayList<Videojuego> lista_catalogos) {
        this.lista_catalogos = lista_catalogos;
    }
//Clase agregar con la excepción por si pone un valor negativo
    public void agregarVideojuego(Videojuego videojuego) throws precio {
        if (videojuego.getPrecio() < 0) {
            System.out.println("Error: Precio no puede ser negativo");
        } else {
            lista_catalogos.add(videojuego);
        }
    }
//Clase listar que muestra si hay o no videojuegos disponibles
    public void listarVideojuegos() {
        if (lista_catalogos.isEmpty()) {
            System.out.println("No hay videojuegos registrados");
        } else {
            for (Videojuego videojuego : lista_catalogos) {
                System.out.println(videojuego);
            }
        }
    }
// Clase buscar que comprueba si el id coincide
    public Videojuego buscarporId(int id) {
        for (Videojuego item : lista_catalogos) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
//Clase eliminar que busca por Id y si coincide eliminar, sino no hace nada
    public boolean eliminarporId(int id) {
        Videojuego videojuego = buscarporId(id);
        if (videojuego != null) {
            lista_catalogos.remove(videojuego);
        }
        return false;
    }
}