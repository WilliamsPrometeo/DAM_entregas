package proyecto2;

import clases.*;
import clases.Taller;
import recursos.*;
import recursos.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) throws VehiculoNoEncontrado {
        menu();
    }

    public static void menu() throws VehiculoNoEncontrado {
        boolean correcto = false;
        do {
            System.out.println("============ Taller ===========");
            int opcion = sc.pedirNumero("1. Registrar vehiculo" +
                    "\n2. Registrar servicio" +
                    "\n3. Asignar servicio" +
                    "\n4. Mostrar Trabajos" +
                    "\n5. Mostrar Vehiculos" +
                    "\n6. Salir" +
                    "\n. Opcion: ");
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
                    taller.mostrarTrabajos();
                    break;
                case 5:
                    taller.MostrarVehiculos();
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