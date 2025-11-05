// ===============================================
//  Proyecto: Gestor de Tienda de Videojuegos
//  Autor: [Sergio]
//  Fecha: 05/11/2025
// ===============================================

import java.util.InputMismatchException;
import java.util.Scanner;

// =======================
// 🧠 Clase Principal
// =======================
public class GestorTienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion = 0;

        do {
            System.out.println("\n===== 🕹️ MENÚ TIENDA DE VIDEOJUEGOS =====");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Listar videojuegos");
            System.out.println("3. Eliminar videojuego por ID");
            System.out.println("4. Salir");
            System.out.print("👉 Elige una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Precio (€): ");
                        double precio = sc.nextDouble();

                        Videojuego nuevo = new Videojuego(titulo, precio);
                        tienda.agregar(nuevo);
                        break;

                    case 2:
                        tienda.listar();
                        break;

                    case 3:
                        System.out.print("Introduce el ID del videojuego a eliminar: ");
                        int id = sc.nextInt();
                        tienda.eliminarPorId(id);
                        break;

                    case 4:
                        System.out.println("👋 ¡Gracias por usar el gestor de la tienda!");
                        break;

                    default:
                        System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada no válida. Usa números para las opciones.");
                sc.nextLine(); // limpiar buffer
                opcion = 0;
            } catch (PrecioNegativoException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }

        } while (opcion != 4);

        sc.close();
    }
}

