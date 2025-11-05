package gestion_tienda.logica;

import excepciones.VideojuegoExcepcion;

import java.util.ArrayList;

public class Tienda {
    ArrayList<Videojuego> videojuegos;

//    Contructores

    public Tienda() {
        this.videojuegos = new ArrayList<>();
    }

    public Tienda(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

//    Getter y setters

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

//    Metodos

    public void agregarVideojuego(Videojuego videojuego) {
        this.videojuegos.add(videojuego);
    }

    public void listarVideojuegos() {
        if (videojuegos.isEmpty()) {
            System.out.println("No videojuegos en el catálogo");
        } else {
            for (Videojuego videojuego : videojuegos) {
                System.out.println(videojuego + "\n");
            }
        }
    }

    public Videojuego buscarVideojuego(int id) {
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getId() == id) {
                return videojuego;
            }
        }
        return null;
    }

    public boolean eliminarVideojuego(int id) throws VideojuegoExcepcion {
        Videojuego videojuego =  buscarVideojuego(id);

        if (videojuego != null) {
            videojuegos.remove(videojuego);
        } else {
            throw new VideojuegoExcepcion("Videojuego no encontrado");
        }

        return true;
    }
}
