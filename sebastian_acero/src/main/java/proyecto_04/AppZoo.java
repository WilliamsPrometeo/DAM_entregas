package proyecto_04;

import ciudad.concesionario.MyScanner;
import proyecto_04.controller.Zoocontroller;

public class AppZoo {

    private static final MyScanner sc =  new MyScanner();
    private static final Zoocontroller controller = new Zoocontroller();

    public static void main(String[] args) { menu(); }

    private static void menu() {
        boolean correcto = false;
        int opcion;
        do {
            opcion = sc.pedirNumero("======== GESTION ZOO ========\n" +
                    "1. addAnimal\n" +
                    "2. Listar Animal\n" +
                    "3. Eliminar Animal\n" +
                    "4. Guardar datos\n" +
                    "5. Cargar datos\n" +
                    "6. patas\n" +
                    "7. getidAnimal\n" +
                    "Opcion: ");
            switch (opcion) {
                case 1:
                    controller.addAnimal();
                    break;
                case 2:
                    controller.ListarAnimal();
                    break;
                case 3:
                    controller.eliminarAnimal();
                    break;
                case 5:
                    controller.guardar();
                    break;
                case 6:
                    controller.cargar();
                    break;
                case 7:
                    controller.patas();
                    break;
                case 8:
                    controller.getAnimal();
                case 0:
                    System.out.println("saliendo. . .");
                    correcto = true;
                    break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);
    }
}
