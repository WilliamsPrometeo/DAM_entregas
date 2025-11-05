import gestorTiendavideojuego.Tienda;
import gestorTiendavideojuego.Videojuego;

import java.util.Scanner;

public class Main_Videojuego {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n ===== Tienda de Videojuegos =====");
            System.out.println("1. Añadir Videojuego");
            System.out.println("2. Listar Videojuegos");
            System.out.println("3. Eliminar Videojuego por ID");
            System.out.println("4. Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el ID del Videojuego");
                    int id = sc.nextInt();
                    System.out.println("Ingresa el precio del Videojuego");
                    Double precio = sc.nextDouble();
                    System.out.println("Ingresa el Titulo del Videojuego");
                    String titulo = sc.next();
                    sc.nextLine();
                    tienda.añadirVideojuego(new Videojuego(id, titulo, precio));
                    break;
                case 2:
                    tienda.mostrarVideojuegos();
                    break;
                case 3:
                    System.out.print("Ingresa el ID del videojuego a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    try {
                        tienda.eliminarVideojuegoPorId(idEliminar);
                    } catch (Exception e) {
                        System.out.println("No se pudo eliminar videojuego");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo de la tienda");
                    break;
                default:
                    System.out.println("Ópcion no valida. Intentalo de nuevo");
            }

        } while (opcion != 4);
        sc.close();

    }
}