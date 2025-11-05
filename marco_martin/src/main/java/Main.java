public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Parking parking = new Parking();
    public static void main(String[] args) throws Excepcion {
        Menu();
    }

    public static void Menu() throws Excepcion {
        boolean exit = false;
        while(!exit) {
            int opcion = sc.pedirNumero("BIENVENIDO\n" +
                    "-----1. Registrar vehiculo-----\n" +
                    "-----2. Listar vehiculo-----\n" +
                    "-----3. eliminar vehiculo-----\n" +
                    "-----4. salir del menu-----\n" +
                    "\t INGRESE UNA OPCION: ");
            exit = acciones(opcion);
        }
    }
    public static boolean acciones(int opcion) throws Excepcion {
            switch (opcion) {
                case 1:
                    parking.registrarVehiculo(pedirVehiculo());
                    break;
                case 2:
                    parking.listarVehiculos();
                    break;
                case 3:
                    parking.listarVehiculos();
                    int idVehiculo = 0;
                    boolean existeVehiculo;


                    parking.eliminarVehiculo(idVehiculo);

                    break;
                case 4:
                    System.out.println("SALIENDO...");
                    return true;
                default:
                    System.out.println("OPCION NO VALIDA!!!");
                    break;
            }
            return false;
        }
    public static Vehiculo pedirVehiculo(){
        Vehiculo vehiculo = new Vehiculo();
        String matricula= sc.pideTexto("MATRICULA:  ");
        vehiculo.setMatricula(matricula);
        String marca = sc.pideTexto("MARCA:    ");
        vehiculo.setMarca(marca);
        return vehiculo;
    }

}