import java.util.ArrayList;

public class Tienda {
    private ArrayList<Videojuego>
    catalogo;
    public Tienda() {
        catalogo = new ArrayList<Videojuego>();
    }
    public void agregarVideojuego(Videojuego videojuego) {catalogo.add(videojuego);
    }
    public void listarVideojuegos() {
        if (catalogo.isEmpty()) {
            System.out.println("No se encontro el videojuego");
        }else {
            System.out.println("---Catalogo de videojuegos---");
            for (Videojuego videojuego : catalogo) {
                System.out.println(videojuego);
            }
        }
    }
    public Videojuego BuscarVideojuego(int id) {
        for (Videojuego videojuego : catalogo) {
            if(videojuego.getId() == id){return videojuego;}
        }return null;
    }
    public boolean eliminarVideojuego(int id) {
        Videojuego videojuego = BuscarVideojuego(id);
        if (videojuego != null) {
            catalogo.remove(videojuego);
            return true;
        }
        return false;

    }
}

