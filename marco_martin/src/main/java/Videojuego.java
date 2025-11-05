public class Videojuego {
    private static int contador = 0;
    private int id;
    private String titulo;
    private double precio;

    public Videojuego() {
        id++;
    }

    public Videojuego(int id, String titulo, double precio) {
        this.id = contador++;
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
        return System.out.printf("Videojuego: %d %n con Título %s, cuesta %.2f", id, titulo, precio).toString();
    }
}
