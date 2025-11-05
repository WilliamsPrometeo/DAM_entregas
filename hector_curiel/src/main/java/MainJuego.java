import java.util.InputMismatchException;
import java.util.Scanner;

public class MainJuego {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion = 0;


        do {
            System.out.println("\n **** GESTOR DE TIENDA DE VIDEOJUEGOS **** ");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Listar videojuegos");
            System.out.println("3. Eliminar videojuego por ID");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("Titulo del videojuegoc: ");
                            String titulo = sc.nextLine();

                            System.out.print("Precio (€): ");
                            double precio = sc.nextDouble();
                            sc.nextLine();

                            if (precio < 0) {
                                throw new PrecioNegativoException("El precio no puede ser negativo.");
                            }

                            Videojuego nuevo = new Videojuego(titulo, precio);
                            tienda.agregarVideojuego(nuevo);

                        } catch (InputMismatchException e) {
                            System.out.println("⚠️ Debes introducir un numero para el precio.");
                            sc.nextLine();
                        } catch (PrecioNegativoException e) {
                            System.out.println("❌  " + e.getMessage());
                        }
                        break;

                    case 2:
                        tienda.listarVideojuegos();
                        break;

                    case 3:
                        try {
                            System.out.print("ID del videojuego a eliminar: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            tienda.eliminarPorId(id);
                        } catch (InputMismatchException e) {
                            System.out.println("⚠️ Error: debe introducir un número para el ID.");
                            sc.nextLine();
                        }
                        break;

                    case 4:
                        System.out.println("👋 Saliendo del programa...");
                        break;

                    default:
                        System.out.println("⚠️ Por favor, elija una opción correcta (1-4).");
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠️ Por favor, elija una opción correcta (número entre 1 y 4).");
                sc.nextLine();
            }

        } while (opcion != 4);

        sc.close();
    }
}