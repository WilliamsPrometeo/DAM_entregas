package practica02;

import clases.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();
    public static void main(String[] args) throws VehiculoNoEncontrado {
        menu();
    }

    public static void menu() throws VehiculoNoEncontrado {
        boolean correcto = false;
        do {
            System.out.println("==== TALLER PROMETEO ====");
            int opcion = sc.pedirNumero("1. Registrar Vehiculo" +
                    "\n2. Registrar servicio" +
                    "\n3. Asignar servicio" +
                    "\n4. Mostrar  Vehiculos" +
                    "\n5. Mostrar trabajos" +
                    "\n6. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    taller.registarVehiculo();
                    break;
                case 2:
                    taller.registarServicio();
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
