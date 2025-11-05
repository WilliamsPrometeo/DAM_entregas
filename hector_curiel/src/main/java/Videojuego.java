public class Videojuego {


    private static int contadorId = 1;
    private int id;
    private String titulo;
    private double precio;

    // Precio Y Titulo
    public Videojuego(String titulo, double precio) {
        this.id = contadorId;
        contadorId++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public Videojuego() {
        this("Sin título", 0.0);
    }


    public int getId() {
        return id;
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

    /*
     * Metodo toString
     */
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Precio: " + precio + " €";
    }
}
