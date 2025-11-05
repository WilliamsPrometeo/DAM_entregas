package src.tienda;

public class Videojuego {

    private static int contador = 0;
    private int id;
    private String titulo;
    private double precio;


    public Videojuego(String titulo, double precio) throws PrecioNegativoException {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.id = ++contador;
        this.titulo = titulo;
        this.precio = precio;
    }


    public Videojuego(int id, String titulo, double precio) throws PrecioNegativoException {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
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

    public void setPrecio(double precio) throws PrecioNegativoException {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }


    @Override
    public String toString() {
        return String.format("ID: %d | Título: %-20s | Precio: %.2f €", id, titulo, precio);
    }
}
