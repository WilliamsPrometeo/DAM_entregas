package Practica01.ejemplos_clase;

public class Videojuego {
    private static int contador = 1;
    private int id; //identificador videojuego
    private String titulo; // nombre del videojuego
    private double precio; //precio videojuego

    //Constructor/es

    public Videojuego() {
        this.id = contador++;
    }

    public Videojuego(int id, String titulo, double precio) throws TiendaExeception {
        if (precio < 0) throw new TiendaExeception("Precio negativo");
        this.id = contador++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public Videojuego(String titulo, double precio) {
        this.id = contador++;
        this.titulo = titulo;
        this.precio = precio;
    }

    //Getters y Setters

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Videojuego.contador = contador;
    }

    public int getId() {
        return this.id;
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

    public void setPrecio(double precio) throws TiendaExeception {
        if (precio < 0) throw new TiendaExeception("Precio negativo");
        this.precio = precio;
    }

    //Metodos

    @Override
    public String toString() {
        return String.format("Id: %d, %ntitulo: %2s, precio: %2f €", id, titulo, precio);
    }
}
