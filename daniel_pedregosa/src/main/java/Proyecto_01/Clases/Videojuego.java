package Proyecto_01.Clases;

import Clases.Proyecto_01.Exceptions.PrecioInvalidoException;

//metodo que contiene las variables/atributos de los Videojuegos
public class Videojuego {
    private static int contadorIDs = 1;
    private int id;
    private String Titulo;
    private double Precio;

    //los constructores necesarios para que funcione
    public Videojuego(){
        this.id = contadorIDs++;
    }

    public Videojuego(int id, String Titulo, double Precio) throws PrecioInvalidoException {
        if (Precio < 0) {
            throw new PrecioInvalidoException("melon, que quieres, que te demos dinero y un juego de gratis?");
        }
        this.id = contadorIDs++;
        this.Titulo = Titulo;
        this.Precio = Precio;
    }

    //los getters y setters de los atributos
    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if (precio < 0) throw new PrecioInvalidoException("si quieres negativos, vete a una convención de emos");
        Precio = precio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //para que pueda ser llamado y ser mostrado
    @Override
    public String toString() {
        return String.format("ID: %-3d | Titulo: %-25s | Precio: %.2f €", id, Titulo, Precio);
    }
}
