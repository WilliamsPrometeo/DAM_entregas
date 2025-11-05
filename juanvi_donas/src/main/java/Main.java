import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Videojuego> videojuegos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    agregarVideojuego();
                    break;
                case 2:
                    listarVideojuegos();
                    break;
                case 3:
                    eliminarVideojuego();
                    break;
                case 4:
                    System.out.println("Has salido del programa.");
                    break;
                default:
                    System.out.println("Elige bien chiquitín.");
                    break;
            }
        } while (opcion != 4);
    }

        private static void mostrarMenu () {
            System.out.println("\n=== MENÚ VIDEOJUEGOS ===");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Listar videojuegos");
            System.out.println("3. Eliminar videojuego por ID");
            System.out.println("4. Salir del programa");
        }

        private static void agregarVideojuego () {
            System.out.println("\n=== AGREGAR VIDEOJUEGO ===");
            System.out.println("Nombre del videojuego: ");
            String nombre = sc.nextLine();
            System.out.println("Genero del videojuego: ");
            String genero = sc.nextLine();
            double precio = leerDouble("Precio (€): ");

            try {
                Videojuego vj = new Videojuego(nombre, genero, precio);
                videojuegos.add(vj);
                System.out.println("El videojuego se ha añadido correctamente.");
            } catch (PrecioNegativoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        private static void listarVideojuegos () {
            System.out.println("\n=== LISTAR VIDEOJUEGOS ===");
            if (videojuegos.isEmpty()) {
                System.out.println("No hay ningún videojuego. ");
                return;
            }

            System.out.printf("%-4s %-20s %-15s %-10s%n", "ID", "Nombre", "Genero", "Precio");
            System.out.println("-----------------------------");
            for (Videojuego vj : videojuegos) {
                System.out.println(vj.toString());
            }
        }

        private static void eliminarVideojuego () {
            System.out.println("\n=== ELIMINAR VIDEOJUEGO ===");
            int id = leerEntero("Introduce el ID del videojuego que quieres eliminar: ");

            boolean eliminado = videojuegos.removeIf(vj -> vj.getId() == id);

            if (eliminado)
                System.out.println("El videojuego se ha eliminado correctamente.");
            else
                System.out.println("No se elimino el videojuego porque no se ha encontrado uno con ese ID.");
        }

        private static int leerEntero (String mensaje){
            int numero = -1;
            while (true) {
                try {
                    System.out.print(mensaje);
                    numero = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número que sea válido.");
                }
            }
            return numero;
        }
        private static double leerDouble (String mensaje){
            double numero = 0;
            while (true) {
                try {
                    System.out.print(mensaje);
                    numero = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número decimal que sea válido.");
                }
            }
            return numero;
        }
    }
