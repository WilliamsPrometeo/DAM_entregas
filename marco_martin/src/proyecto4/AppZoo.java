package proyecto4;

import proyecto4.controller.ZooController;
import recursos.MyScanner;

public class AppZoo {
    private static final MyScanner sc = new MyScanner();
    private static final ZooController controller = new ZooController();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean correcto = false;
        int opcion;

        do {
            opcion = sc.pedirNumero("=====GESTION ZOO=====\n" +
                    "\n 1. Registrar animal" +
                    "\n 2. Listar animales" +
                    "\n 3. Buscar animal" +
                    "\n 4. Eliminar animal" +
                    "\n 5. Guardar datos" +
                    "\n 6. Cargar datos" +
                    "\n 0. Salir");

            switch (opcion) {
                case 1:
                    controller.addAnimal();
                    break;
                case 2:
                    controller.listAnimales();
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
                    System.out.println("Saliendo...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a intentarlo, Williams te quiero");
                    break;
            }
        } while (!correcto);

    }
}
