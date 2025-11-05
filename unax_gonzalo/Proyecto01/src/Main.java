import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Tienda tienda = new Tienda();

    //Logica del menu

    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        agregarVideojuego();
                        break;
                    case 2:
                        tienda.listar();
                        break;
                    case 3:
                        eliminarVideojuego();
                        break;
                    case 4:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingresa una opcion valida \n");
                sc.nextLine();
            }

            //Estetica del menu y bucle para que pregunte hasta una opcion correcta
        } while (opcion != 4);
    }
        private static void mostrarMenu(){
            System.out.println("====================");
            System.out.println("        Gestor      ");
            System.out.println("====================");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Listar videojuego");
            System.out.println("3. Eliminar videojuego");
            System.out.println("4. Salir");
            System.out.println("Elige una opcion:");
        }
        private static void agregarVideojuego() {
            try {
                System.out.println("Titulo: ");
                String titulo = sc.nextLine();

                System.out.println("Precio: ");
                double precio = sc.nextDouble();
                sc.nextLine();

                System.out.println("Año de lanzamiento: ");
                int lanzamiento = sc.nextInt();
                sc.nextLine();

                Videojuego juego = new Videojuego(titulo, precio, lanzamiento);
                tienda.agregar(juego);

            } catch (PrecioExcepcion e) {
                System.out.println(e.getMessage()  + "\n");
            }
            catch (LanzamientoExcepcion e){
                System.out.println("Error. Ingresa un año valido \n");
            }
        }
        private static void eliminarVideojuego() {
            try {
                System.out.println("Introduce el id a eliminar: ");
                int id = sc.nextInt();
                sc.nextLine();
                if (tienda.eliminarPorId(id)) {
                    System.out.println("Videojuego eliminado correctamente \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingresa una opcion valida \n");
                sc.nextLine();
            }
        }
    }