package src;

public class Videojuego {
    private static int contadorId = 1;

    private int id;
    private String titulo;
    private double precio;

    public Videojuego( String titulo, double precio)
            throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("Es imposible");

        }
        this.titulo = titulo;
        this.precio = precio;
        this.id = contadorId++;
    }


    public Videojuego(double precio, String titulo) {
    }


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void getTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double calcularPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws
            PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio es imposible que sea negativo");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("ID:%d | Título: %-20s | Precio: $%.2f", id, titulo, precio);
    }
}