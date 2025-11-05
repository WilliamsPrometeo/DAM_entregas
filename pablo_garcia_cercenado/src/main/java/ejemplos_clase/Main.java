package ejemplos_clase;

import Practica1.ejemplos_clase.excepciones.ExcepcionID;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Menú de opciones
                    1. Agregar videojuego
                    2. Listar videojuegos
                    3. Buscar videojuego por ID
                    4. Eliminar videojuego por ID
                    5. Salir
                    """);
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    try {
                        Videojuego videojuego = new Videojuego(titulo, precio);
                        tienda.agregar(videojuego);
                    } catch (ExcepcionID e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    tienda.listar();
                    break;

                case 3:
                {
                    System.out.print("Introduce el ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Videojuego v = tienda.buscarPorId(id);
                    if (v != null) System.out.println("\n" + v + "\n");
                    else System.out.println("\nNo se encontró el videojuego.\n");
                    break;
                }

                case 4: {
                    System.out.print("Introduce el ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    tienda.eliminarPorId(id);
                    break;
                }

                default:
                    System.out.println("\nOpción no válida.\n");
                    flag = false;
                    break;
            }
        }
    }
}
