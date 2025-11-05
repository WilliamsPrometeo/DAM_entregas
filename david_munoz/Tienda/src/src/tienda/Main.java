package src.tienda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("  GESTOR DE TIENDA DE VIDEOJUEGOS");
            System.out.println("==============================");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Listar videojuegos");
            System.out.println("3. Eliminar videojuego por ID");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print(" Opción no válida. Introduce un número: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    try {
                        System.out.print("Introduce el título del videojuego: ");
                        String titulo = sc.nextLine();

                        System.out.print("Introduce el precio (€): ");
                        double precio = sc.nextDouble();

                        Videojuego v = new Videojuego(titulo, precio);
                        tienda.agregar(v);
                        System.out.println("Videojuego agregado correctamente.");
                    } catch (PrecioNegativoException e) {
                        System.out.println(" Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println(" Error inesperado: " + e.getMessage());
                    }
                }
                case 2 -> tienda.listar();

                case 3 -> {
                    System.out.print("Introduce el ID del videojuego a eliminar: ");
                    int idEliminar = sc.nextInt();
                    boolean eliminado = tienda.eliminarPorId(idEliminar);
                    System.out.println(eliminado ? "🗑️  Videojuego eliminado correctamente." : "❌ No se encontró el videojuego.");
                }
                case 4 -> System.out.println(" Saliendo del programa... ¡Hasta pronto!");
                default -> System.out.println(" Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
