package proyecto2;

import clases.*;
import recursos.MyScanner;


public class Main {

    private static final MyScanner sc = new MyScanner();
    private static Taller Taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean correcto = false;
        do {
            System.out.println("==== TALLER PROMETEO ====");
            int opcion = sc.pedirNumero("1. Registrar Vehiculo" +
                    "\n2. Registrar Servicio" +
                    "\n3. Asignar Servicio" +
                    "\n4. Mostrar Vehiculos" +
                    "\n5. Mostrar Trabajos" +
                    "\n6. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    Taller.registrarVehiculo();
                    break;
                case 2:
                    Taller.registarServicio;
                    break;
                case 3:
                    System.out.println(Taller.AsignarVehiculo());
                    break;
                case 4:
                    Taller.mostarVehiculos();
                    break;
                case 5:
                    Taller.mostarTrabajos();
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

    private static class Taller {
    }
}
