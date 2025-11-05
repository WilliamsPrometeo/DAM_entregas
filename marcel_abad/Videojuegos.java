package Clases;

public class Videojuegos {
    private static int contador = 1;
    private int id;
    private String titulo;
    private double precio;

    public Videojuegos (){ this.id = contador++; }

    public Videojuegos(String titulo, double precio){
        this.titulo = titulo;
        this.precio = precio;
        this.id = contador++;
    }
    public int getId() {return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() {return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public double getPrecio() {return precio; }
    public void setPrecio(double precio) { this.precio = precio; }


    @Override
    public String toString(){
        return String.format("Videojuego %d: %nTitulo: %10s, Precio: %8s", id, titulo, precio);
    }
}
