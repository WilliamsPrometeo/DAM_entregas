package proyectos_gordos.tienda_videojuegos;

public class Videojuegos {

    private static int contador = 1;
    private int id;
    private String titulo;
    private double precio;

    public Videojuegos() {this.id = contador++;}

    public Videojuegos(int id, String titulo, double precio) {
        this.id = contador++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getId() {return id; }

    public void setId(int id) {this.id = id; }

    public String getTitulo() {return titulo; }

    public void setTitulo(String titulo) {this.titulo = titulo; }

    public double getPrecio() {return precio; }

    public void setPrecio(double precio) {this.precio = precio; }

    @Override
    public String toString() {
        return String.format("ID %d: Videojuego %s: Precio: %.2f €", id, titulo, precio); }
}
