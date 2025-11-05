package clases;

public class Videojuego {
    private static int contador = 1;
    private int id;
    private String titulo;
    private double precio;

    public Videojuego() { this.id = contador++; }


    public Videojuego(String titulo, double precio) {
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
        return String.format("Videojuego %d: %nTítulo: %10s, Precio: %.2f€\n", id, titulo, precio);
    }
}