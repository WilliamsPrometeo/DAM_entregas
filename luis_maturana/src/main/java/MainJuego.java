import java.util.InputMismatchException;
import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion = 0;
        do {
            try {
                System.out.println("---Gestor de Tienda de VideoJuegos---");
                System.out.println("1. Añadir Juego");
                System.out.println("2. Listar Videojuego");
                System.out.println("3. Eliminar Videojuego");
                System.out.println("4. Salir");
                System.out.println("Selecciona una opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        try {
                            System.out.println("Introduce el ID del Videojuego: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el nombre del Videojuego: ");
                            String nombre = sc.nextLine();
                            System.out.println("Introduce el precio del Videojuego: ");
                            float precio = sc.nextFloat();
                            sc.nextLine();
                            Videojuego videojuego = new Videojuego(id, nombre, precio);
                            tienda.agregarVideojuego(videojuego);
                            System.out.println("Videojuego agregado correctamente");
                        } catch (PrecioNegativoException e) {
                            System.out.println("Error!!!! Debes introducir un numerooooo");

                        } catch (Exception e) {
                            System.out.println("Error!!!! Debes introducir un numerooooo");
                            sc.nextLine();
                        }
                        break;

                    case 2:
                        tienda.listarVideojuegos();
                        break;

                    case 3:
                        try {
                            System.out.println("Ingrese el ID del videojuego a eliminar:");
                            int eliminarVideojuego = sc.nextInt();
                            if (tienda.eliminarVideojuego(eliminarVideojuego)) {
                                System.out.println("Videojuego eliminado correctamente");
                            } else {
                                System.out.println("No se encontro videojuego con ese ID");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error!!!! Debes introducir un numerooo");
                        }
                        break;

                    case 4:
                        System.out.println("VUELVE PRONTO!");
                        break;

                    default:
                        System.out.println("Selecciona una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error!!!! Debes introducir un numero");
                sc.nextLine();
            }

            }while (opcion != 4) ;
            sc.close();
        }
    }

