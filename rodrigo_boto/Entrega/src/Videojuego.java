public class Videojuego { //Inicialización de las variables
    private static int contador = 0;
    private int id;
    private String titulo;
    private double precio;

    public Videojuego() {
        this.id = ++contador;
    }

    public Videojuego(String titulo, double precio) {
        this.id = ++contador;
        this.titulo = titulo;
        this.precio = precio;
    }
//TODOS LOS GETTER Y SHETTER
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
// TEXTO FORMATEADO
    @Override
    public String toString() {
        return String.format("ID: %d: %nTítulo: %3s, precio: %3s€", id, titulo, precio);
    }
}