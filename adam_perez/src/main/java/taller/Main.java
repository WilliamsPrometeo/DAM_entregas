import clases.Taller;
import recursos.MyScanner;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    /**
     * Metodo main para iniciar el programa
     */

    static void main(String[] args) {
        menu();
    }

    /**
     * Metodo menu para ejecutar la logica
     */

    public static void menu() {
        System.out.println("=== Bienvenido al taller ===");
        boolean correcto = false;
        do {
            int opcion = sc.pedirNumero("1. Registrar vehiculo\n" +
                    "2. Registrar servicio\n" +
                    "3. Asignar servicio\n" +
                    "4. Mostrar vehiculos\n" +
                    "5. Mostrar trabajos\n" +
                    "6. Salir\n" +
                    "Opcion: ");

            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    break;
                case 2:
                    taller.registrarServicio();
                    break;
                case 3:
                    taller.asignarSevicio();
                    break;
                case 4:
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarServicios();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!correcto);

    }
}
