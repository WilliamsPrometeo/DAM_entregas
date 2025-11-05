package Clases;

public class GestionVideojuegos {
    private static final MyScanner sc = new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        boolean exit = false;
        while(!exit){
            System.out.println("***** Tienda Menu *****");
            System.out.println("\t1. Agregar Videojuego");
            System.out.println("\t2. Listar Videojuego");
            System.out.println("\t3. Eliminar Videojuego");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero2("Ingrese una opcion: ");
            exit = acciones(opcion);
        }
    }

    public static boolean acciones(double opcion){
        switch((int) opcion){
            case 1: tienda.registrarVideojuegos(agregarVideojuegos()); break;
            case 2: tienda.listarVideojuegos(); break;
            case 3:
                if (eliminarVideojuegos()) {
                    System.out.println("El videojuego ha sido eliminado.");
                } else {
                    System.out.println("Fallo al eliminar videojuego.");
                }
            break;
            case 0:
                System.out.println("***** Saliendo *****");return true;
            default:
                System.out.println("Opcion no valida");break;
        }
        return false;
    }

    public static Videojuegos agregarVideojuegos(){
        String titulo = sc.pideTexto("Ingrese el titulo: ");
        double precio = sc.pedirNumero("Ingrese el precio: ");
        Videojuegos videojuego = new Videojuegos(titulo, precio);
        return videojuego;
    }

    public static boolean eliminarVideojuegos(){
        tienda.listarVideojuegos();
        int id = sc.pedirNumero2("Ingrese el Id del Videojuego: ");
        try{
            return tienda.eliminarPorId(id);
        } catch (Videojuegos_Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
