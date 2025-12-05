package proyecto2;


import proyecto2.clases.Taller;
import recursos.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit = false;
        do {
            int opcion = sc.pedirNumero("====TALLER PROMETEO====\n" +
                    "1. Registrar vehiculo\n" +
                    "2. Registrar servicio\n" +
                    "3. Asignar servicio\n" +
                    "4. Mostrar vehículos\n" +
                    "5. Mostrar trabajos\n" +
                    "6. Salir\n"+
                    "7. SORPRESA\n");
            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    break;
                case 2:
                    taller.registrarServicio();
                    break;
                case 3:
                    System.out.println(taller.asignarServicio());
                    break;
                case 4:
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6:
                    System.out.println("ADIOS!!!!");
                    exit = true;
                    break;
                case 7:

                    boolean correcto;
                    do {
                        int hola= sc.pedirNumero("ME VAS A PONER BUENA NOTA??\n"+"1. SI\n"+"2. NO\n");
                        switch (hola) {
                            case 1:
                                System.out.println("Buena eleccion, te dejo salir");
                                correcto = true;
                                break;
                                case 2:
                                    System.out.println("Te lo vuelvo a preguntar por si acaso");
                                    correcto = false;
                                    break;
                            default:
                                correcto = false;
                                System.out.println("no te libras");
                                break;
                        }
                    }while (!correcto);
                default:
                    System.out.println("Opción no válida");
                    break;

            }

        } while (!exit);
    }
}

