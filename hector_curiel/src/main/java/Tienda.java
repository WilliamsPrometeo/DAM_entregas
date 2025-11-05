import java.util.ArrayList;

public class Tienda {


     // Atributos

    private ArrayList<Videojuego> catalogo;


     // Constructor

    public Tienda() {
        catalogo = new ArrayList<>();
    }





    // Agregar videojuego
    public void agregarVideojuego(Videojuego v) {
        catalogo.add(v);
        System.out.println("✅ Videojuego agregado correctamente.");
    }

    // Listar videojuegos
    public void listarVideojuegos() {
        if (catalogo.isEmpty()) {
            System.out.println("📭 No hay videojuegos en el catálogo.");
        } else {
            System.out.println("📋 Lista de videojuegos:");
            for (Videojuego v : catalogo) {
                System.out.println(v);
            }
        }
    }

    // Buscar videojuego por ID
    public Videojuego buscarPorId(int id) {
        for (Videojuego v : catalogo) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    // Eliminar videojuego por ID
    public boolean eliminarPorId(int id) {
        Videojuego v = buscarPorId(id);
        if (v != null) {
            catalogo.remove(v);
            System.out.println("🗑️ Videojuego eliminado correctamente.");
            return true;
        } else {
            System.out.println("⚠️ No se encontró un videojuego con ese ID.");
            return false;
        }
    }
}