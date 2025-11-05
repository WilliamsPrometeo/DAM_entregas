import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Tienda tienda = new Tienda();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una de las siguientes opciones: ");

            switch (opcion) {
                case 1 -> agregarVideojuego();
                case 2 -> eliminarVideojuego();
                case 3 -> tienda.listar();
                case 4 -> System.out.println("👋 Saliendo del programa...");
                case 5 -> System.out.println("❌ Esa opción no es válida.");
            }

        } while (opcion != 4);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n***** 🎮GESTOR DE TIENDA DE VIDEOJUEGOS🎮 *****");
        System.out.println("1.▶️ Agregar videojuego");
        System.out.println("2.✖️ Eliminar videojuego por ID");
        System.out.println("3.📋 Listar videojuegos");
        System.out.println("4.🏃‍♂️ Salir");
        System.out.println("----------------------------------------");
    }

    private static void agregarVideojuego() {
        System.out.println("Título: ");
        String titulo = sc.nextLine();

        double precio = leerDouble("Precio: ");

        try{
            Videojuego juego = new Videojuego (titulo, precio);
            tienda.agregar(juego);
        } catch (PrecioInvalidoException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void eliminarVideojuego() {
        int id = leerEntero("Introduce el ID del videojuego que desee eliminar: ");

        Videojuego juego = tienda.buscarPorId(id);
        if (juego == null) {
            System.out.println("❌ No existe ningún videojuego con ese ID.");
            return;
        }

        System.out.printf("⚠️ ¿Seguro que quieres eliminar \"%s\" (ID: %d)? (S/N):", juego.getTitulo(), juego.getId());
        String confirmacion = sc.nextLine().trim().toLowerCase();
        if (confirmacion.equals("S")) {
            if (tienda.eliminarPorId(id)) {
               System.out.println("🗑️ Videojuego eliminado.");
            }
        }else {
            System.out.println("✔️ Eiminación cancelada, no se borró el videojuego.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes introducir un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
                System.out.println("❌ Debes introducir un número decimal válido");
            }
        }
    }
}

