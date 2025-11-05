package gestion_tienda;

import excepciones.VideojuegoExcepcion;
import logica.MyScanner;
import logica.Tienda;
import logica.Videojuego;

public class Main {
    private static final MyScanner sc =  new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean valido = true;

        while (valido) {
            int opcion = sc.pedirNumero("\n--- Bienvenido a la tienda, que deseas hacer: ---\n" +
                                            "1. --- Agregar un videojuego\n" +
                                            "2. --- Listar los videojuegos\n" +
                                            "3. --- Eliminar(por id) un videojuego\n" +
                                            "4. --- Salir de la tienda\n" );

            switch(opcion) {
                case 1:
                    tienda.agregarVideojuego(pedirVideojuego());
                    break;
                case 2:
                    tienda.listarVideojuegos();
                    break;
                case 3:
                    if (eliminarVideojuego()) {
                        System.out.println("El videojuego eliminado exitosamente, ya no lo jagarás más\n");
                    } else {
                        System.out.println("No se pudo eliminar el videojuego\n");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    valido = false;
                    break;
            }
        }
    }

    public static Videojuego pedirVideojuego() {
        Videojuego videojuego = new Videojuego();
        videojuego.setPrecio(sc.pedirDecimal("Dime el precio del videojuego: \n"));
        videojuego.setTitulo(sc.pideTexto("Dime el titulo del videojuego: \n"));

        return videojuego;
    }

    public static boolean eliminarVideojuego() {
        tienda.listarVideojuegos();
        int id = sc.pedirNumero("Dime el id del videojuego que quieres eliminar: ");

        try {
            return tienda.eliminarVideojuego(id);
        } catch (VideojuegoExcepcion e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
