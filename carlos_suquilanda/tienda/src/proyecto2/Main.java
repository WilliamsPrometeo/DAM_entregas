package proyecto2;

import clases.MyScanner;
import clases.Taller;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    /**
     * Aqui solamengte hacemos un menu con cada una de las opciones del programa. Laa opciones las llamameos desde
     * "Taller" y se ejecutan de`pendiendo d elo que el usuario pida
     */

    private static void menu() {
        boolean correcto = false;
        do {
            System.out.println("---------- TALLER MECÁNICO ----------");
            int opcion = sc.pedirNumero("1. Registrar Vehiculo" +
                    "\n2. Registrar Servicio" +
                    "\n3. Asignar Servicio" +
                    "\n4. Mostrar Vehículos" +
                    "\n5. Mostrar Trabajos" +
                    "\n6. Buscar Vehículos" +
                    "\n7. Buscar Servicio" +
                    "\n8. Salir" +
                    "\n OPCION ---> ");
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
                    taller.buscarVehiculo();
                    break;
                case 7:
                    taller.buscarServicio();
                    break;
                case 8:
                    System.out.println("... Saliendo ...");
                    correcto = true;
                    break;
            }
        } while (!correcto);
    }
}
