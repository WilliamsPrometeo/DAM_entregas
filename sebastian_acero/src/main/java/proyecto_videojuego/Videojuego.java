package proyecto_videojuego;

public class Videojuego {
    private static int contador = 1;
    private int id;
    private String nombre;
    private int precio;

    public Videojuego() {this.id = contador++;}

    public Videojuego(String nombre, int precio) {
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Videojuego(String nombre, Double precio) {

    }

    public int getId() { return getId(); }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPrecio() { return precio; }

    public void setPrecio(int precio) { this.precio = precio;}

    @Override
    public String toString() {
        return String.format("Videojuego %d: %nombre: %10s, precio: %d", id, nombre, id, precio);
    }
}