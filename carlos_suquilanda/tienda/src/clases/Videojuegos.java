package clases;

public class Videojuegos {
    private static int contador = 0;
    private int id;
    private String titulo;
    private double precio;

    public Videojuegos() {}

    // Aqui se ejecutan todos los constructores getters and setters y él toString que lo modificamos para usar el String.format

    public Videojuegos(String titulo, double precio) {
        this.id = ++contador; // genera ID automático
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("📚 | ID: %d | TÍTULO: %s | PRECIO: %.2f", id, titulo, precio);
    }
}
