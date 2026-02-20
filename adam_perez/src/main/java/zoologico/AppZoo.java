package zoologico;

import ejercicioEvaluable.mvc.controller.ZooController;
import recursos.MyScanner;

public class AppZoo {
    private static final MyScanner sc = new MyScanner();
    private static final ZooController zoo = new ZooController();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit = false;
        int opcion;
        do {
            opcion = sc.pedirNumero("===== GESTION ZOOLOGICO =====" +
                    "\n1. Registrar animal" +
                    "\n2. Listar animales" +
                    "\n3. Buscar animal" +
                    "\n4. Eliminar animal" +
                    "\n5. Guardar datos" +
                    "\n6. Cargar datos" +
                    "\n0. Salir" +
                    "\nInserte la opcion que desee: ");
            switch (opcion) {
                case 1:
                    zoo.agregarAnimal();
                    break;
                case 2:
                    zoo.listarAnimales();
                    break;
                case 3:
                    zoo.buscarAnimal();
                    break;
                case 4:
                    zoo.elimarAnimal();
                    break;
                case 5:
                    zoo.guardar();
                    break;
                case 6:
                    zoo.cargar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }
}
