public class Videojuego {

    private int id;
    private String nombre_videojuego;
    private String autor;
    private double precio;
    private boolean disponible;

    public Videojuego(int id, String nombre_videojuego, String autor, double precio) {
        this.disponible = true;

    }

    public Videojuego(int id, String nombre_videojuego, String autor) {
        this.id = id;
        this.nombre_videojuego = nombre_videojuego;
        this.autor = autor;
        this.precio = precio;

        this.disponible = true;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_videojuego() {
        return nombre_videojuego;
    }

    public void setNombre_videojuego(String nombre_videojuego) {
        this.nombre_videojuego = nombre_videojuego;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", nombre='" + nombre_videojuego + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible +
                ", precio=" + precio +
                '}';
    }
}
