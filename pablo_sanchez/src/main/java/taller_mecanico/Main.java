package taller_mecanico;

import taller_mecanico.clases.Taller;
import taller_mecanico.recursos.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    /**
     * Metodo Menu
     *
     * @return Menu principal que te da opcion a elegir y llevarte a realizar esas acciones de: registrarUsuario, registrarLibro, prestarLibro, mostrarLibros, mostrarPrestamos y salir.
     */

    public static void menu() {
        boolean correcto = false;
        do {
            System.out.println("******LIBRERIA💩💩💩PROMETEO******");
            int opcion = sc.pedirNumero("1. Registrar Vehiculo😎" +
                    "\n2. Registrar Servicio😒" +
                    "\n3. Asignar servicio😍" +
                    "\n4. Mostrar vehiculos🤦‍♂️" +
                    "\n5. Mostrar trabajos😱👅" +
                    "\n6. Salir😈" +
                    "\nSeleccione su opción: ");
            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    break;
                case 2:
                    taller.registrarServicio();
                    break;
                case 3:
                    taller.asignarServicios();
                    break;
                case 4:
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    correcto = true;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while (!correcto);
    }
}
