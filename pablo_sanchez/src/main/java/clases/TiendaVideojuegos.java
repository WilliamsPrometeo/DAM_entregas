package clases;

import java.util.ArrayList;

public class TiendaVideojuegos {
    private ArrayList<Videojuego> catalogo = new ArrayList<>();
    public void agregarVideojuego(Videojuego vj) {
        catalogo.add(vj);
    }
    public ArrayList<Videojuego> getCatalogo() {
        return catalogo;
    }
    public Videojuego buscarPorId(int id) {
        for (Videojuego vj : catalogo) {
            if (vj.getId() == id) return vj;
        }
        return null;
    }
    public boolean eliminarPorId(int id) {

            Videojuego vj = buscarPorId(id);
            if (vj != null) {
            catalogo.remove(vj);
            return true;
            }
            return false;
    }
    public void listarVideojuego() {
        System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "Nombre", "Precio", "Disponible");
        System.out.println("----------------------------------------------------");
        for (Videojuego vj : catalogo) {
            System.out.println(vj);
        }
    }
}
