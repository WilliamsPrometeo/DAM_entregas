public class Videojuegos {
    // Atributos
    private static int contadorId = 1; // ID autoincremental
    private int id;
    private String titulo;
    private double precio;

    // Constructor con validación de precio
    public Videojuegos(String titulo, double precio) throws Precioincorrecto {
        if (precio < 0) {
            throw new Precioincorrecto("El precio no puede ser negativo.");
        }
        this.id = contadorId++;
        this.titulo = titulo;
        this.precio = precio;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Mostrar información formateada
    @Override
    public String toString() {
        return String.format("ID: %d | Título: %-20s | Precio: %.2f €", id, titulo, precio);
    }
}
