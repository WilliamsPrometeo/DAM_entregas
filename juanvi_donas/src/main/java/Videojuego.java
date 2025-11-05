public class Videojuego {
    private static int contadorId = 1;

    private int id;
    private String nombre;
    private String genero;
    private double precio;

    public Videojuego(String nombre, String genero, double precio) throws PrecioNegativoException {
        if (precio < 0) {
            throw new PrecioNegativoException ("El precio no puede ser negativo: " + precio);
        }
        this.id = contadorId++;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public double getPrecio() { return precio; }

    public void setPrecio(double precio) throws PrecioNegativoException {
        if (precio < 0) throw new PrecioNegativoException ("El precio no puede ser negativo: " + precio);
        this.precio = precio;
    }

    public String toString() {
        return String.format ("%-4d %-20s %-15s %8.2f €", id, nombre, genero, precio);
    }
}
