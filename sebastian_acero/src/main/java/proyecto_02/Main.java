package proyecto_02;

import ciudad.concesionario.MyScanner;
import proyecto_02.Clases.Servicio;
import proyecto_02.Clases.Vehiculo;

import static Simulacro.Main.menu;
import static ciudad.concesionario.Gestionconsesionario.sc;

public class Main {
    private static final MyScanner scanner = new MyScanner();
    private static Servicio servicio = new Servicio();

    public static void main(String[] args) {
        menu();

        public static void menu() {
            boolean correcto = false;
                do {
                    System.out.println("======= TALLER =======");
                    int opcion = sc.pedirNumero("1. Registrar vehiculo" +
                            "\n2. Registrar Servicio" +
                            "\n3. Asignar Servicio" +
                            "\n4. Mostrar vehiculos" +
                            "\n5. Mostrar trabajos" +
                            "\n6. Salir" +
                            "\nOpcion: ");

                    switch (opcion) {
                        case 1:
                            Vehiculo.registrarVehiculo();
                            break;
                        case 2:
                            Vehiculo.registrarServicio();
                            break;
                        case 3:
                            System.out.println(Vehiculo.Asignarservicio());
                            break;
                        case 4:
                            Vehiculo.MostrarVehiculo();
                            break;
                        case 5:
                            Vehiculo.mostrarTrabajos();
                            break;
                        case 6:
                            System.out.println("..... Saliendo .....");
                            correcto = true;
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                } while (!correcto);
            }
        }
    }

