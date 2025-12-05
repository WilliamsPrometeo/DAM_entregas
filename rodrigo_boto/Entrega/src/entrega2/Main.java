package entrega2;

import entrega2.clases.Taller;
import entrega2.exception.VehiculoNoEncontrado;
import recursos.MyScanner;

/**
 * Clase Main del programa
 * @author Rodrigo Boto
 * @version 1.0
 */

public class Main {
    //Atributos privados
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) throws VehiculoNoEncontrado {
        menu();
    }

    public static void menu() throws VehiculoNoEncontrado {
        boolean correcto = false;
        do {
            System.out.println("==== TALLER ====");
            int opcion = sc.pedirNumero("1. Registrar vehículo" +
                    "\n2. Registrar servicio" +
                    "\n3. Asignar servicio" +
                    "\n4. Mostrar vehículos" +
                    "\n5. Mostrar trabajos" +
                    "\n6. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    break;
                case 2:
                    taller.registrarServicio();
                    break;
                case 3:
                    System.out.println(taller.asignarServicio());
                    break;
                case 4:
                    taller.mostrarVehiculo();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6:
                    System.out.println("... Saliendo ...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (!correcto);
    }
}
