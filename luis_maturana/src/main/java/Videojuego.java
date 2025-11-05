public class Videojuego {

    private static int contadorID;
    private int id;
    private String titulo;
    private float precio;

    public Videojuego() {
    }
    public Videojuego(int id, String titulo, float precio) throws PrecioNegativoException{
        if(precio<0){
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.id = id;
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

    public void setPrecio(float precio) throws PrecioNegativoException {
        if(precio<0){
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }
    @Override
    public String toString() {
        return String.format("ID: %d | Titulo: %-20s | Precio: %.2f", id, titulo, precio);
    }
}
