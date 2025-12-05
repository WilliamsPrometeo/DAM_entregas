package proyecto_02;

import ciudad.recursos.MyScanner;
import proyecto_02.clases.Taller;

public class Main {

    private static final MyScanner sc = new MyScanner();

    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        boolean correcto = false;
        do {
            System.out.println("====== 🛠️TALLER PROMETEO🛠️ ======");
            int opcion = sc.pedirNumero("1. Registrar vehículo" +
                    "\n2. Registrar servicio" +
                    "\n3. Asignar servicio" +
                    "\n4. Mostrar vehículos" +
                    "\n5. Mostrar trabajos" +
                    "\n6. Salir" +
                    "\nOpción: ");
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
                    System.out.println("Saliendo......");
                    System.out.println("\n******* 👋 ADIÓS 👋 *******");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (!correcto);

    }
}
