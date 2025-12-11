package practica2;

import practica2.clases.Taller;
import practica2.excepcion.VehiculoNoEncontrado;
import recursos.Miscanner;

public class Main {

    private static final Miscanner sc = new Miscanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) throws VehiculoNoEncontrado {
        menu();
    }

    public static void menu() throws VehiculoNoEncontrado {
        boolean correcto = false;
        do {
            System.out.println("Bienvenido al Taller");
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
                    taller.asignarServicio();
                    break;
                case 4:
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (!correcto);
    }
}