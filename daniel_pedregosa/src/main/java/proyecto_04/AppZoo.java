package proyecto_04;

import proyecto_04.controller.ZooController;

import java.util.Scanner;

public class AppZoo {
    private static final Scanner sc = new Scanner(System.in);
    private static final ZooController controller = new ZooController();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean salir = false;
        int opc;

        do {
            System.out.println("\n--- Gestión del Focking Zoo ---");
            System.out.println("1. Registrar Animal");
            System.out.println("2. Listar Animales");
            System.out.println("3. Buscar Animal");
            System.out.println("4. Eliminar Animal");
            System.out.println("5. Guardar datos");
            System.out.println("6. Cargar datos");
            System.out.println("0. Salir");
            System.out.print("Elige: ");

            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida");
                continue;
            }

            switch (opc) {
                case 1:
                    controller.addAnimal();
                    break;
                case 2:
                    controller.listarAnimales();
                    break;
                case 3:
                    controller.getAnimal();
                    break;
                case 4:
                    controller.eliminarAnimal();
                    break;
                case 5:
                    controller.guardar();
                    break;
                case 6:
                    controller.cargar();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!salir);
    }
}
