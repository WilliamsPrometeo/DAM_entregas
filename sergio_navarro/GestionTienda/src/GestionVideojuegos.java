import clases.tiendavideojuegos.clases.MyScanner;
import clases.tiendavideojuegos.clases.Tienda;
import clases.tiendavideojuegos.clases.Videojuego;
import clases.tiendavideojuegos.exception.VideojuegoException;

public class GestionVideojuegos {
    private static final MyScanner sc =  new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        boolean exit = false;
        while(!exit){
            System.out.println("\n----- Tienda de Videojuegos -----");
            System.out.println("\t1. Registrar Videojuego");
            System.out.println("\t2. Listar Videojuegos");
            System.out.println("\t3. Eliminar Videojuego");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Seleccione una opcion: ");
            exit = acciones(opcion);
        }
    }

    public static boolean acciones(int opcion){
        switch(opcion){
            case 1:
                tienda.registrarVideojuegos(pedirVideojuego());
                break;
            case 2:
                tienda.listarVideojuegos();
                break;
            case 3:
                if (eliminarVideojuego()) {
                    System.out.println("El videojuego ha sido eliminado.");
                } else {
                    System.out.println("Error al eliminar el videojuego.");
                }
                break;
            case 0:
                System.out.println("Saliendo.........");
                return true;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        return false;
    }

    public static Videojuego pedirVideojuego(){
        String titulo = sc.pideTexto("Ingrese el titulo: ");
        double precio = sc.pedirDecimal("Ingrese el precio del videojuego: ");
        System.out.println("Has añadido: " + titulo + ", " + precio + "€");
        Videojuego videojuego = new Videojuego(titulo, precio);
        return videojuego;
    }

    public static boolean eliminarVideojuego(){
        tienda.listarVideojuegos();
        int id = sc.pedirNumero("Ingrese el id del videojuego: ");
        try {
            return tienda.eliminarPorId(id);
        } catch (VideojuegoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
