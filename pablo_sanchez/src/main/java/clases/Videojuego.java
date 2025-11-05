package clases;

import exception.PrecioInvalidoException;

public class Videojuego {

    private static int contadorid = 1;
    private int id;
    private String nombre;
    private double precio;
    private boolean disponible;

    public Videojuego (String nombre, double precio) throws PrecioInvalidoException{
        if (precio < 0){
            throw new PrecioInvalidoException("El precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = true;
        this.id = contadorid++;
    }

    public int getId(){
    return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public double getPrecio() {
        return this.precio;
    }
    public boolean isDisponible() {
        return this.disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-20s %-10.2f %-10s", id, nombre, precio, disponible ? "Si" : "N0");
    }
}

