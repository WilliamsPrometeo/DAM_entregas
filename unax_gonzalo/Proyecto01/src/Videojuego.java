public class Videojuego {
    private static int contadorId = 1; //ID autoincrementable (practicta anterior)
    private int id;
    private String titulo;
    private double precio;
    private int lanzamiento;

    //constructor
    public Videojuego(String titulo, double precio, int lanzamiento) throws PrecioExcepcion, LanzamientoExcepcion {
        if (precio < 0) {
            throw new PrecioExcepcion("Precio invalido");
        }
        if (lanzamiento < 1900 || lanzamiento > 2030) {
            throw new LanzamientoExcepcion("Año de lanzamiento invalido");
        }
        this.id = contadorId++; //aumenta el valor para evitar IDs repetidos
        this.titulo = titulo;
        this.precio = precio;
        this.lanzamiento = lanzamiento;
    }

    //getters & sstters
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

    public int getLanzamiento() {
        return lanzamiento;
    }

    //Evita valores negativos
    public void setPrecio(double precio) throws PrecioExcepcion {
        if (precio < 0) {
            throw new PrecioExcepcion("Precio invalido");
        }
        this.precio = precio;
    }

    public void setLanzamiento(int lanzamiento) throws PrecioExcepcion {
        if (lanzamiento < 0) {
            throw new PrecioExcepcion("Año invalido");
        }
    }

    //override
    @Override
    public String toString() {
        return titulo + " | ID: " + id + " | Precio: " + precio + "€" + " | Año de lanzamiento: " + lanzamiento;
    }
}