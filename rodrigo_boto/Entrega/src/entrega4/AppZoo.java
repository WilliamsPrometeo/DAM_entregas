package entrega4;

import entrega4.controller.ZooController;
import recursos.MyScanner;


public class AppZoo {

    private static final ZooController controller = new ZooController();
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        menu();
    }

    private static void menu(){
        boolean correcto = false;
        int opcion;
        do{
            opcion = sc.pedirNumero("====== GESTIÓN ZOO ======" +
                    "\n1. Registrar animal" +
                    "\n2. Listar animales" +
                    "\n3. Buscar animal" +
                    "\n4. Eliminar animal" +
                    "\n5. Guardar datos" +
                    "\n6. Cargar datos" +
                    "\n0. Salir" +
                    "\nOpción: ");
            switch(opcion){
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
                    System.out.println("Saliendo...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!correcto);
    }
}
