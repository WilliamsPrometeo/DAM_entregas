package ejemplos_clase;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Videojuego> catalogo;

    public Tienda() {
        catalogo = new ArrayList<>();
    }

    //metodo para añadir nuevos juegos, completado en el main.java
    public void agregar(Videojuego videojuego) {
        catalogo.add(videojuego);

        //texto de confirmación
        System.out.println("\nVideojuego añadido correctamente.\n");
    }

    //metodo para imprimir los juegos en catálogo
    public void listar() {
        if (catalogo.isEmpty()) {

            //si está vacío devuelve una excepción
            System.out.println("\nNo hay videojuegos en el catálogo.\n");
        } else {

            //si funciona correctamente imprime el catálogo entero
            System.out.println("\nCatálogo de videojuegos:\n");
            for (Videojuego videojuego : catalogo) {
                System.out.println(videojuego);
            }
            System.out.println();
        }
    }

    //el usuario busca un juego por su id
    public Videojuego buscarPorId(int id) {
        for (Videojuego videojuego : catalogo) {
            if (videojuego.getId() == id)
                return videojuego;
        }
        return null;
    }

    //el usua
    public boolean eliminarPorId(int id) {
        Videojuego v = buscarPorId(id);
        if (v != null) {
            catalogo.remove(v);
            System.out.println("\nVideojuego eliminado correctamente.\n");
            return true;
        } else {
            System.out.println("\nNo se encontró ningún videojuego con ese ID.\n");
            return false;
        }
    }
}
