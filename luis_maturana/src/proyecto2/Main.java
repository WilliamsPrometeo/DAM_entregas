package proyecto2;

import proyecto2.clases.Vehiculo;
import proyecto2.enums.TipoVehiculo;
import proyecto2.myscanner.MyScanner;
import proyecto2.clases.Taller;

public class Main {
    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner();
        Taller taller = new Taller();
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = myScanner.pedirNumero("Bienvenido introduce una opcion valida para continuar \n 1. Registrar Vehiculo \n 2. Registrar Servicio \n 3. Asignar Servicio \n 4. Mostrar Vehiculos \n 5. Mostrar trabajos \n 6. Salir");

            switch (opcion_tipo) {
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
                    System.out.println("Saliendo");
                    correcto = false;
                    break;

                default:
                    System.out.println("Introduce una opcion valida");
                    break;
            }
        }while (correcto);

    }

    }


