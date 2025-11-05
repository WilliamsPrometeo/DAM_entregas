package gestorTiendavideojuego;
import java.util.ArrayList;

public class Tienda {
    private ArrayList<Videojuego>Videojuegos;
    public Tienda() {
        this.Videojuegos = new ArrayList<>();
        Videojuego videojuego1 = new Videojuego(1, "Red Dead Redemption 2", 19.99);
        this.Videojuegos.add(videojuego1);
        Videojuego videojuego2 = new Videojuego(2, "Bloodborne", 29.99);
        this.Videojuegos.add(videojuego2);
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return Videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.Videojuegos = videojuegos;
    }
    public void añadirVideojuego(Videojuego videojuego) {
        Videojuegos.add(videojuego);
        System.out.println("El Videojuego se ha añadido correctamente.");
    }
    public boolean eliminarVideojuegoPorId(int id) throws gestorTiendavideojuego.VideojuegoNoEncontradoException {
        for (int i = 0; i < Videojuegos.size(); i++) {
            if (Videojuegos.get(i).getId() == id) {
                Videojuegos.remove(i);
                System.out.println("Videojuego con ID " + id + " eliminado correctamente.");
                return true;
            } else {
                throw new gestorTiendavideojuego.VideojuegoNoEncontradoException("El Videojuego con ID " + id + " no existe.");
            }
        }
        System.out.println("No se encontró ningún videojuego con este ID: " + id);
        return false;
    }

    public void mostrarVideojuegos() {
        if (Videojuegos.isEmpty()) {
            System.out.println("No videojuegos encontrados");
        } else  {
            for (Videojuego videojuego : Videojuegos) {
                System.out.println(videojuego);
            }
        }
    }
}
