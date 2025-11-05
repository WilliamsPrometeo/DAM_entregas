import java.util.ArrayList;

public class Tienda {
    // Catálogo de videojuegos
    private ArrayList<Videojuegos> catalogo;

    public Tienda() {
        catalogo = new ArrayList<>();
    }

    // Agregar videojuego
    public void agregar(Videojuegos v) {
        catalogo.add(v);
    }

    // Listar todos los videojuegos
    public void listar() {
        if (catalogo.isEmpty()) {
            System.out.println("\nNo hay videojuegos en el catálogo.");
        } else {
            System.out.println("\n--- LISTA DE VIDEOJUEGOS ---");
            for (Videojuegos v : catalogo) {
                System.out.println(v);
            }
        }
    }

    // Buscar por ID
    public Videojuegos   buscarPorId(int id) {
        for (Videojuegos v : catalogo) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    // Eliminar por ID
    public boolean eliminarPorId(int id) {
        Videojuegos v = buscarPorId(id);
        if (v != null) {
            catalogo.remove(v);
            return true;
        }
        return false;
    }
}
