import clases.MyScanner;
import clases.Taller;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean salir = false;
        do {
            System.out.println("---TALLER PROMETEO---");
            int opcion = sc.pedirNumero("1. Registrar vehiculo\n2. Registrar servicio\n3. Asignar servicio\n4. Mostrar vehiculos" +
                    "\n5. Mostrar trabajos\n6. Salir\nOpcion: ");
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
                    salir = true;
                    break;
                default:
                    System.out.println("Error: opcion invalida");
                    break;
            }
        } while (!salir);
    }
}