public class Videojuego {

    private static int contadorID = 1;

    private int id;
    private String titulo;
    private double precio;

    public Videojuego(String titulo, double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo: " + precio);
        }
        this.id = contadorID++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public Videojuego(int id, String titulo, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getId() {return id; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo: " + precio);
        }
        this.precio = precio;
    }
    @Override
    public String toString() {
        return String.format("%-5d %-25s %.2f €", id, titulo, precio);
    }
}
