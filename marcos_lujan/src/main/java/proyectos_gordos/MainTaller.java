package proyectos_gordos;

import proyectos_gordos.recursos.MyScanner;
import proyectos_gordos.taller_mecanico.Taller;

/**
 * Clase MainTaller
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public class MainTaller {

    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    /**
     * Metodo menu, tiene el menu principal del taller con todas las opciones
     */
    public static void menu() {
        boolean correcto = false;
        do {
            System.out.println("==== TALLER PROMESA DE UNA PRINCESA ====");
            int opcion = sc.pedirNumero("1. Registrar vehiculo" +
                    "\n2. Registrar servicio" +
                    "\n3. Asignar servicio" +
                    "\n4. Mostrar vehículos" +
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
                    taller.asignarServicio();
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
