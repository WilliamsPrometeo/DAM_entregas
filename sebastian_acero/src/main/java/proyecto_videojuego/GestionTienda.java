package proyecto_videojuego;

public class GestionTienda {
    private static final MyScanner sc = new MyScanner();
    private static final Tienda tienda = new Tienda();
    private static boolean eliminarPorNombre;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("***** Menu de Videojuegos *****");
            System.out.println("\t1. Registrar nombre de Videojuego");
            System.out.println("\t2. Listar Videojuegos");
            System.out.println("\t3. Eliminar Videojuegos");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Ingrese una opcion");
            exit = acciones(opcion);
        }
    }

    public static boolean acciones(int opcion) {
        switch (opcion) {
            case 1:
                tienda.registrarVideojuego(pedirVideojuego());
                break;
            case 2:
                tienda.ListarVideojuegos();
                break;
            case 3:
                if (eliminarVideojuego()) {
                    System.out.println("Videojuego eliminado");
                } else {
                    System.out.println("Videojuego no pudo ser eliminado");
                }
                break;
            case 0:
                System.out.println("**** Saliendo ****");
                return true;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        return false;
    }


    public static Videojuego pedirVideojuego() {
        String nombre = sc.pideTexto("Ingrese el nombre del videojuego");
        Double precio = sc.pedirDecimal("Ingrese el precio del videojuego");
        Videojuego Videojuego = new Videojuego(nombre, precio);
        return Videojuego;
    }

    public static boolean eliminarVideojuego() {
        tienda.getListaVideojuegos();
        double id = sc.pedirDecimal("Ingrese el precio del videojuego");
        try {
            return tienda.eliminarPorid(id);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

