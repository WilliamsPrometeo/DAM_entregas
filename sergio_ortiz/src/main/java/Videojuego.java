// ===============================================
//  Proyecto: Gestor de Tienda de Videojuegos
//  Autor: [Sergio]
//  Fecha: 05/11/2025
// ===============================================

// =======================
//  Clase Videojuego
// =======================
class Videojuego {
    private static int contadorId = 1; // ID autoincremental
    private int id;
    private String titulo;
    private double precio;

    // Constructor
    public Videojuego(String titulo, double precio) throws PrecioNegativoException {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo.");
        }
        this.id = contadorId++;
        this.titulo = titulo;
        this.precio = precio;
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }

    // Setters
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setPrecio(double precio) throws PrecioNegativoException {
        if (precio < 0) throw new PrecioNegativoException("El precio no puede ser negativo.");
        this.precio = precio;
    }

    // toString formateado
    @Override
    public String toString() {
        return String.format("ID: %d | Título: %-20s | Precio: %.2f €", id, titulo, precio);
    }
}

