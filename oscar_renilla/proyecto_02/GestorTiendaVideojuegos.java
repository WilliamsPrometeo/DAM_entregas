package Programacion;

import clases.MyScanner;
import clases.Tienda;
import clases.Videojuegos;
import exceptions.TiendaVideojuegos;

public class GestorTiendaVideojuegos {
    private static final MyScanner sc = new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("====== Tienda Menu ======");
            System.out.println("\t1. Agregar Videojuego");
            System.out.println("\t2. Listar Videojuegos");
            System.out.println("\t3. Eliminar Videojuegos");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Ingrese una opcion: ");
            exit = acciones(opcion);
        }
    }

    public static boolean acciones(int opcion) {
        switch (opcion) {
            case 1:
                tienda.registrarVideojuegos(pedirVideojuego());
                break;
            case 2:
                tienda.listarVideojuego();
                break;
            case 3:
                if (eliminarVideojuego()) {
                    System.out.println("El videojuego ha sido eliminado.");
                } else {
                    System.out.println("Fallo al eliminar el videojuego.");
                }
                break;
            case 0:
                System.out.println("====== Saliendo ======");
                return true;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        return false;
    }

    public static Videojuegos pedirVideojuego() {
        String titulo = sc.pedirSoloTexto("Ingrese el título: ");
        double precio = sc.pedirDecimal("Ingrese el precio: ");
        Videojuegos videojuego = new Videojuegos(titulo, precio);
        return videojuego;
    }

    public static boolean eliminarVideojuego() {
        tienda.listarVideojuego();
        int id = sc.pedirNumero("Ingrese el id del videojuego que quiere eliminar: ");
        try {
            return tienda.eliminarPorId(id);
        } catch (TiendaVideojuegos e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}


