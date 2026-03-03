package zoo;

import controller.ZooController;
import recursos.MyScanner;

public class AppZoo {

    private static final MyScanner sc = new MyScanner();
    private static final ZooController controller = new ZooController();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean correcto = false;
        int opcion;
        do {
            opcion = sc.pedirNumero(" ------------------ Gestion Zoológico  ------------------\n" +
                    "1. Registrar Animal\n" +
                    "2.Listar Animales\n" +
                    "3.Buscar Animales\n" +
                    "4.Eliminar Animal\n" +
                    "5.Guardar Datos\n" +
                    "6.Cargar Datos\n" +
                    "0.Salir\n" +
                    "OPCIÓN: ");
            switch (opcion) {
                case 1:
                    controller.addAnimal();
                    break;
                case 2:
                    controller.listarReservas();
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
                    System.out.println("Opción no valida");
                    break;
            }
        } while (!correcto);
    }
}
