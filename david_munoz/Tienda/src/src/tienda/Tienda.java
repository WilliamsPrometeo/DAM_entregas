package src.tienda;

import java.util.ArrayList;

public class Tienda {

    private ArrayList<Videojuego> catalogo;


    public Tienda() {
        catalogo = new ArrayList<>();
    }


    public ArrayList<Videojuego> getCatalogo() {
        return catalogo;
    }



    /**
     * Agrega un videojuego al catálogo
     * @param v Videojuego
     */
    public void agregar(Videojuego v) {
        catalogo.add(v);
    }

    /**
     * Lista todos los videojuegos registrados
     */
    public void listar() {
        if (catalogo.isEmpty()) {
            System.out.println("\n📭 No hay videojuegos en el catálogo.");
        } else {
            System.out.println("\n🎮 LISTADO DE VIDEOJUEGOS:");
            System.out.printf("%-5s %-25s %-10s\n", "ID", "Título", "Precio (€)");
            System.out.println("---------------------------------------------");
            for (Videojuego v : catalogo) {
                System.out.printf("%-5d %-25s %-10.2f\n", v.getId(), v.getTitulo(), v.getPrecio());
            }
        }
    }

    /**
     * Busca un videojuego por su ID
     * @param id ID del videojuego
     * @return el objeto Videojuego si existe, null si no
     */
    public Videojuego buscarPorId(int id) {
        for (Videojuego v : catalogo) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Elimina un videojuego por su ID
     * @param id ID a eliminar
     * @return true si se elimina, false si no existe
     */
    public boolean eliminarPorId(int id) {
        Videojuego encontrado = buscarPorId(id);
        if (encontrado != null) {
            catalogo.remove(encontrado);
            return true;
        }
        return false;
    }
}
