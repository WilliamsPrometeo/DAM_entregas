import java.util.ArrayList;

public class Tienda {

    private int id;
    private String nombre;
    private ArrayList<Videojuego> videojuegos;

    public Tienda() {this.videojuegos = new ArrayList<>();}

    public Tienda(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.videojuegos = new ArrayList<>();
    }

    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public void addVideojuego(Videojuego videojuego) {
        this.videojuegos.add(videojuego);
    }

    public void comprarVideojuego(Videojuego videojuego) {
        videojuego.setDisponible(false);
    }

    @Override
    public String toString() {
        return "Tienda{" + "id=" + id +
                ", nombre=" + nombre +
                ", videojuegos=" + videojuegos +
                '}';
    }



}