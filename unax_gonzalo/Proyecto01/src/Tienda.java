import java.util.ArrayList;
public class Tienda {
    private ArrayList<Videojuego> catalogo;

    public Tienda() {
        this.catalogo = new ArrayList<>();
    }

    //agregar
    public void agregar(Videojuego juego) {
        catalogo.add(juego);
        System.out.println("Videojuego agregado correctamente \n");
    }

    //Listar
    public void listar() {
        if (catalogo.isEmpty()) {
            System.out.println("EL catalogo esta vacío, contacte con soporte si cree que es un error");
            return;
        }
        System.out.println("Catalogo");
        System.out.println("========================================");
        for (Videojuego juego : catalogo) {
            System.out.println(juego.getTitulo() + " | ID: " + juego.getId() + " | " + juego.getPrecio() + "€" + "|" + juego.getLanzamiento());
        }
        System.out.println("======================================== \n");

    }
    //Busqueda por ID
    public Videojuego buscarPorId(int id) {
        for (Videojuego juego : catalogo) {
            if (juego.getId() == id) {
                return juego;
            }
    }
        return null;
}
    //eliminar por ID
    public boolean eliminarPorId(int id) {
    Videojuego juego = buscarPorId(id);
        if (juego != null) {
            catalogo.remove(juego);
            return true;
        }
        return false;
    }
}

