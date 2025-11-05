import java.util.ArrayList;

public class Tienda {

    private ArrayList<Videojuego> catalogo;

    public Tienda() {
        catalogo = new ArrayList<>();
    }

    public void agregar(Videojuego juego) {
        catalogo.add(juego);
        System.out.println("Videojuego agregado correctamente.✅");
    }

    public void listar() {
        if (catalogo.isEmpty()) {
            System.out.println("⚠️ No hay videojuegos disponibles en el catálogo!");
            return;

        }

        System.out.printf("%-5s %-25s %-10s\n", "ID", "Nombre", "Precio");
        System.out.println("----------------------------------------------");
        for (Videojuego v : catalogo) {
            System.out.println(v);
        }
    }

    public Videojuego buscarPorId(int id) {
        for (Videojuego v : catalogo) {
            if (v.getId() == id) return v;
        }
        return null;
    }

        public boolean eliminarPorId(int id){
        Videojuego encontrado = buscarPorId(id);
        if (encontrado != null) {
            catalogo.remove(encontrado);
            return true;

        }
        return false;
    }
}
