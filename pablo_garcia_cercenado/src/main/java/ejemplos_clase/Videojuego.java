package ejemplos_clase;

import Practica1.ejemplos_clase.excepciones.ExcepcionID;

public class Videojuego {
    private static int contador = 1;
    private int id;
    private String titulo;
    private double precio;

    public Videojuego() {
    }

    //control de excepciones
    public Videojuego(String titulo, double precio) throws ExcepcionID {
        if (precio < 0) throw new ExcepcionID("El precio no puede ser negativo");
        this.id = contador++;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //control de excepciones
    public void setPrecio(double precio) throws ExcepcionID {
        if (precio < 0) throw new ExcepcionID("El precio no puede ser negativo");
        this.precio = precio;
    }

    //texto formateado
    @Override
    public String toString() {
        return String.format("ID: %d | Título: %-20s | Precio: %.2f €", id, titulo, precio);
    }
}
