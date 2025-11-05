package gestorTiendavideojuego;

public class Videojuego {
    private int id;
    private String titulo;
    private Double precio;

    public Videojuego() {}

    public Videojuego(int id, String titulo, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }


    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                '}';
    }

    public void mostrarInfoVideojuego() {
        System.out.println("Titulo: " + titulo + ", Precio: " + precio + ", ID: " + id);
    }
}
