package gestion_tienda.logica;

public class Videojuego {
    private static int contador = 1;
    private int id;
    private String titulo;
    private double precio;


    public Videojuego() {this.id = contador++;}

    public Videojuego(double precio, int id, String titulo) {
        this.precio = precio;
        this.id = contador++;
        this.titulo = titulo;
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
        return String.format("Video juego: %s, el precio es: %.2f y su ID es: %d", titulo, precio, id);
    }
}
