package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();

        int opcion;
        do {
            System.out.println("=== MENÚ ===");
            System.out.println("1. Añadir Videojuego");
            System.out.println("2. Listar Videojuegos");
            System.out.println("3. Eliminar Videojuego por ID");
            System.out.println("4. Buscar Videojuego por ID");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Introduce el nombre del Videojuego: ");
                        String titulo = sc.nextLine();
                        System.out.print("Introduce el precio del Videojuego: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        Videojuego nuevo = new Videojuego(titulo, precio);
                        tienda.anadir(nuevo);
                        System.out.println("Videojuego agregado correctamente.\n");
                    } catch (PrecioInvalidoException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error al añadir el videojuego: " + e.getMessage());
                    }
                    break;

                case 2:
                    tienda.listar();
                    break;

                case 3:
                    System.out.print("Introduce el ID que deseas eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    if (tienda.eliminarPorId(idEliminar)) {
                        System.out.println("Videojuego con ID " + idEliminar + " eliminado correctamente.\n");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el ID que deseas buscar: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();
                    Videojuego encontrado = tienda.buscarPorId(idBuscar);
                    if (encontrado != null) {
                        System.out.println("Videojuego encontrado:");
                        System.out.println(encontrado + "\n");
                    } else {
                        System.out.println("No se encontró un videojuego con el ID " + idBuscar + ".\n");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Por favor, elige un número del 1 al 5.\n");
            }
        } while (opcion != 5);

        sc.close();
    }
}
