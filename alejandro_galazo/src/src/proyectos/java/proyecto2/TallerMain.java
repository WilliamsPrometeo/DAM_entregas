package proyecto2;

import proyecto2.clases.Taller;
import proyecto2.exception.VehiculoNoEncontrado;
import proyecto2.recursos.MyScanner;

public class TallerMain {

    private static final MyScanner sc = new MyScanner();
    private static Taller taller= new Taller();

    public static void main(String[] args) throws VehiculoNoEncontrado {
        menu();

    }

    public static void menu() throws VehiculoNoEncontrado {
        boolean correcto = false;
        do{
            System.out.println("=====LIBRERIA=====");
            int opcion = sc.pedirNumero("1. registrar vehiculo"+
                    "\n 2.registrar servicio"+
                    "\n 3.prestar asignar servicio"+
                    "\n 4.mostrar vehiculos"+
                    "\n 5.mostrar trabajos"+
                    "\n 6.salir"+
                    "\nopcion" );
            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    correcto = true;
                    break;
                case 2:
                    taller.registrarServicio();
                    correcto = true;
                    break;
                case 3:
                    taller.asignarServicio();
                    correcto = true;
                    break;
                case 4:
                    taller.mostrarVehiculos();
                    correcto = true;
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    correcto = true;
                    break;
                case 6:
                    System.out.println("saliendo..." );
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida" );
                    break;
            }
        } while (!correcto);
    }
}