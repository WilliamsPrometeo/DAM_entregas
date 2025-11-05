package Practica01.ejemplos_clase;

import Clases.MyScanner;

public class Main {

    private static final MyScanner scanner = new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) throws TiendaExeception {

        menu();

    }

    public static void menu() throws TiendaExeception {

            boolean exit = false;
            while (!exit) {
                System.out.println("**** Tienda Menu ****");
                System.out.println("\n1. Lista videojuegos");
                System.out.println("\n2. Agregar videojuego");
                System.out.println("\n3. Eliminar videojuego");
                System.out.println("\n0. Salir");
                int opcion = scanner.pedirNumero("Introduce el opcion: ");
                exit = acciones(opcion);
            }

    }

    public static boolean acciones(int opcion) throws TiendaExeception {

        MyScanner scanner = new MyScanner();

            switch (opcion) {
                case 1:
                    tienda.listarVideojuegos();
                break;
                case 2:
                    String titulo = scanner.pedirSoloTexto("Introduce titulo: ");
                    double precio = scanner.pedirNumero("Introduce precio: ");
                    Videojuego videojuego = new Videojuego(titulo, precio);
                    tienda.agregarVideojuegos(videojuego);

                break;
                case 3:
                    int id = scanner.pedirNumero("Introduce el Id del videojuego: ");
                    tienda.eliminarporId(id);
                break;
                case 0:
                    System.out.println("Salir");
                    return true;
                default:
                    System.out.println("Opcion no valida");
                break;
            }

            return false;

    }
}
