package segunda_evaluacion.prueba4;

import segunda_evaluacion.prueba4.controller.ZooController;
import segunda_evaluacion.recursos.MyScanner;
import segunda_evaluacion.simulacro2.controller.ReservaController;

public class AppZoo {

    private static final MyScanner sc = new MyScanner();
    private static final ZooController controller = new ZooController();

    public static void main(String[] args) {
        menu();
    }

    private static void menu(){

        boolean correcto;
        int opcion;
        do {

            correcto = false;
            opcion = sc.pedirNumero2(
                    "********GESTION DEL ZOO******** \n" +
                            "1.Registar animal \n" +
                            "2.Listar animal\n" +
                            "3.Buscar animal\n" +
                            "4.Eliminar animal\n" +
                            "5.Guardar datos\n" +
                            "6.Cargar datos\n" +
                            "0.Salir\n" +
                            "Opcion: "
            );

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
                    System.out.println("Salir");
                    correcto = true;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!correcto);
    }
}
