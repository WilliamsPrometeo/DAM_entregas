package proyecto2;

import clases.MyScanner;
import clases.Servicio;
import clases.Taller;
import clases.Vehiculo;


public class Main {

    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean correcto = false;

        do {
            System.out.println("==== TALLER MECANICO ====");
            int opcion = sc.pedirNumero("1. Registrar vehiculo" +
                    "\n2. Registrar Servicio" +
                    "\n3. Asignar Servicio " +
                    "\n4. Mostrar Vehiculos" +
                    "\n5. Mostrar Trabajos" +
                    "\n6. Buscar Servicio" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    Vehiculo.Registrarvehiculo();

                    System.out.println("Matricula");
                    System.out.println("Modelo");
                    System.out.println("Tipo Vehiculo");
                    break;
                case 2:
                    Servicio.registrarservicio();

                    System.out.println("Descripción");
                    System.out.println("Nombre del Mecanico");
                    break;
                case 3:
                    System.out.println(Taller.asignarServicio());

                    System.out.println("Matricula");
                    System.out.println("Descripción de Servicio");
                    break;
                case 4:
                    Taller.mostrarVehiculos();
                    break;
                case 5:
                    Taller.mostrarTrabajos();

                    System.out.println("Contenido del Map");
                    break;
                case 6:
                    Taller.buscarServicio();

                    System.out.println("Mantenimiento");
                    System.out.println("Cambio de Aceite");
                    System.out.println("Pintura");
                    System.out.println("Frenos");
                    System.out.println("Electricidad");
                    break;


                case 7:
                    System.out.println("... Saliendo ...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (!correcto); //*@Parameter --> Bucle.
    }
}
