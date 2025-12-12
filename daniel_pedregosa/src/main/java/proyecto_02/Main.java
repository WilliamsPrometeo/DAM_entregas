package proyecto_02;

import clases.proyecto_02.clases.Taller;
import clases.proyecto_02.exceptions.VehiculoNoEncontrado;
import recursos.*;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) throws VehiculoNoEncontrado {
        menu();
    }

    public static void menu() throws VehiculoNoEncontrado {
        boolean correcto = false;

        do {
            System.out.println("\ncompramostucoche.es");
            int opc = sc.pedirNumero("1. Registrar Vehiculo" +
                    "\n2. Registrar Servicio" +
                    "\n3. Asignar Servicio" +
                    "\n4. Mostrar Vehiculos" +
                    "\n5. Mostrar Trabajos" +
                    "\nElige: ");
            switch (opc) {
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
                default:
                    System.out.println("opcion incorrecta, anormaloide");
                    correcto = true;
                    break;
            }
        } while (!correcto);
    }
}
