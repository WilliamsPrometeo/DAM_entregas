public class VideoJuego {
    private static int contadorId = 1;
    private int id;
    private String titulo;
    private double precio;


    public VideoJuego(int id, String titulo, double precio) throws  Exception {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio negativo");
        }
        this.id = contadorId++;
        this.titulo = titulo;
        this.precio = precio;
    }
    public VideoJuego(String titulo, double precio) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        VideoJuego.contadorId = contadorId;
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

    public int getId() {
        return id;
    }
    public String toString(){
        return String.format("Id %d , Titulo: %s, Precio: %.2f", id, titulo, precio);
    }
}
