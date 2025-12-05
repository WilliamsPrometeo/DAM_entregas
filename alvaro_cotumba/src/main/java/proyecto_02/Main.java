package proyecto_02;

import proyecto_02.clases.Taller;
import recursos.MyScanner;

/**
 * Clase principal Main que contiene el punto de entrada del programa
 * Gestiona el menu principal de la libreria
 * @author  Alumno - Alvaro Cotumba
 * @version 1.0
 */
public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean correcto = false;
        do {
            System.out.println("==== TALLER ====");
            int opcion = sc.pedirNumero("1. Registrar vehiculo" +
                    "\n2. Registrar servicio" +
                    "\n3. Asignar servicio" +
                    "\n4. Mostrar vehiculos" +
                    "\n5. Mostrar trabajos" +
                    "\n6. Salir" +
                    "\nOpcion: ");
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
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6:
                    System.out.println("... Saliendo ...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (!correcto);
    }
}


