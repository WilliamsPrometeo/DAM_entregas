import Clases.MyScanner;
import Clases.Tienda;
import Clases.Videojuego;
import Exceptions.VideojuegoException;

public class Main {

    // Inicio dos clases que voy a usar a lo largo del programa para no tener que iniciarlas en cada función que haga
    private static final MyScanner sc = new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) {
        menu();
    }

    // Menu de tienda que recoge la opcion que quieres hacer, despues llama a la funcion acciones
    public static void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("--------Menu tienda--------\n1- Registrar videojuego\n2- Listar videojuegos\n3- Eliminar videojuego\n4- Salir");
            int opcion = sc.pedirNumero("Introduzca una opción: ");
            exit = acciones(opcion);
        }
    }

    // Funcion que realiza las acciones de una opción pasada por parámetro
    public static boolean acciones (int opcion){
        switch (opcion) {
            case 1:
                tienda.anyadirVideojuego(pedirVideojuego());
            break;
            case 2:
                tienda.listarVideojuego();
            break;
            case 3:
                if(tienda.getCatalogo().isEmpty()){
                    System.out.println("No hay videojuegos registrados");
                }else {
                    if (eliminarVideojuego()) {
                        System.out.println("Videojuego eliminado exitosamente");
                    } else {
                        System.out.println("Error: Fallo al eliminar videojuego");
                    }
                }
            break;
            case 4:
                System.out.println("Saliendo...");
                return true;
            default:
                System.out.println("Error: Opcion incorrecta");
            break;
        }
        return false;
    }

    // Función que pide que introduzcas los datos de un videojuego, devuelve el mismo
    public static Videojuego pedirVideojuego(){
        String nombre = sc.pedirSoloTexto("Introduzca el nombre: ");
        Double precio = sc.pedirDoublePositivo("Introduzca el precio: ");
        Videojuego videojuego = new Videojuego(precio, nombre);
        return videojuego;
    }

    // Función que elimina un videojuego llamando a la función eliminar por id, deuelve true o false si se ha podido borrar o no
    public static boolean eliminarVideojuego(){
        tienda.listarVideojuego();
        int id = sc.pedirNumero("Introduzca el id del videojuego que quiere eliminar: ");
        try {
            return tienda.eliminarPorId(id);
        } catch (VideojuegoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}