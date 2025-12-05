package proyecto2;

import clases.MyScanner;
import clases.Taller;
import exeptions.VehiculoNoEncontrado;

/**
 * Menú principal del taller.
 */
public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean salir = false;

        do {
            int opcion = sc.pedirNumero("""
                    ===== Taller Mecánico =====
                    1. Registrar vehículo
                    2. Registrar servicio
                    3. Asignar servicio
                    4. Mostrar vehículos
                    5. Mostrar trabajos
                    6. Salir
                    Opción: """);

            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    break;

                case 2:
                    taller.registrarServicio();
                    break;

                case 3: {
                    try {
                        taller.asignarServicio();
                    } catch (VehiculoNoEncontrado e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4:
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6: {
                    System.out.println("Saliendo...");
                    salir = true;
                }
            }
        } while (!salir);
    }
}


