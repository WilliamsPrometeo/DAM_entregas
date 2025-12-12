package proyecto2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final MyScanner sc = new MyScanner();
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    /**
     * aplico el menu principla con loas diferenctes opciones
     */
    public static void menu() {

        int opcion;
        do {
            System.out.println("""
                    -------- MENÚ PRINCIPAL --------
                    1. Registar vehiculo 
                    2. Registrar servicio 
                    3. Asignar servicio 
                    4. Mostrar vehiculo
                    5. Mostrar trabajos
                    6. Salir
                    """);
            opcion = MyScanner.pedirNumero("ingrese opcion: ");
            /**
             * aplico el switch con las opciones con los vehiculos
             */
            switch (opcion) {
                case 1 -> taller.registrarVehiculo();
                case 2 -> taller.registrarServicio();
                case 3 -> taller.asignarServicio();
                case 4 -> taller.mostrarVehiculos();
                case 5 -> taller.mostrarTrabajos();
                case 6-> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 6);
    }
}

