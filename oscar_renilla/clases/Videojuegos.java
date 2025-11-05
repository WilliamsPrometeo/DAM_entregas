package clases;

public class Videojuegos {
    private static int contador = 1;
    private int id;
    private String titulo;
    private double precio;

    public void Videojuegos() {
        this.id = contador++;
    }

    public Videojuegos(String titulo, double precio) {
        this.id = contador++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Videojuegos.contador = contador;
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
        return String.format("Videojuego %d: %nTitulo: %10s, Precio: %.2f€", id, titulo, precio);
    }
}


