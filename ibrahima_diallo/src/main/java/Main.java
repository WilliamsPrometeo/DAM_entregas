import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion = 0;

        do {
            System.out.println("\n===== GESTOR DE TIENDA DE VIDEOJUEGOS =====");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Listar videojuegos");
            System.out.println("3. Buscar videojuego por ID");
            System.out.println("4. Eliminar videojuego por ID");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el título: ");
                        String titulo = sc.nextLine();

                        double precio = 0;
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.print("Ingrese el precio: ");
                                precio = sc.nextDouble();
                                sc.nextLine();
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese un número válido.");
                                sc.nextLine();
                            }
                        }

                        Videojuegos v = new Videojuegos (titulo, precio);
                        tienda.agregar(v);
                        System.out.println("Videojuego agregado correctamente:");
                        System.out.println(v);
                    }

                    case 2 -> tienda.listar();

                    case 3 -> {
                        System.out.print("Ingrese el ID a buscar: ");
                        int idBuscar = sc.nextInt();
                        sc.nextLine();
                        Videojuegos encontrado = tienda.buscarPorId(idBuscar);
                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("No se encontró ningún videojuego con ese ID.");
                        }
                    }

                    case 4 -> {
                        System.out.print("Ingrese el ID a eliminar: ");
                        int idEliminar = sc.nextInt();
                        sc.nextLine();
                        if (tienda.eliminarPorId(idEliminar)) {
                            System.out.println("Videojuego eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún videojuego con ese ID.");
                        }
                    }

                    case 5 -> System.out.println("Saliendo del programa...");

                    default -> System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número.");
                sc.nextLine();
            } catch (Precioincorrecto e) {
                        throw new RuntimeException(e);
            }

        } while (opcion != 5);

        sc.close();
    }
}
