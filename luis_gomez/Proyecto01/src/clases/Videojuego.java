package clases;

//Clase que tiene id unico, id, nombre y precio
public class Videojuego {
    private static int contador = 1;
    private int id;
    private String nombre;
    private double precio;

    public Videojuego() {
        this.id=contador++;
    }

    public Videojuego(double precio, String nombre) {
        this.id = contador++;
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Función que saca por consola id, nombre y precio de un Videojuego
    @Override
    public String toString() {
        return String.format("Juego %d: nombre: %s precio: %.2f",id, nombre, precio);
    }
}
