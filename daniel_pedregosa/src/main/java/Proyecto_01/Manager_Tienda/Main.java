package Proyecto_01.Manager_Tienda;

// se importan las clases que se necesitan llamar para el programa
import Clases.Proyecto_01.Clases.Tienda;
import Clases.Proyecto_01.Clases.Videojuego;
import Clases.Proyecto_01.Exceptions.PrecioInvalidoException;
import Clases.Scanners.MyScanner;

//creamos el metodo principal del programa
public class Main {
    //creamos el scanner y la tienda
    private static final MyScanner sc = new MyScanner();
    private static final Tienda tienda = new Tienda();

    //clase main que llamara solo al menu
    public static void main(String[] args) throws PrecioInvalidoException {

        menu();
    }

    //creamos el metodo del menu, con un booleano para poder mostrarlo
    public static void menu() throws PrecioInvalidoException {
        boolean exit = false;
        while(!exit){

            System.out.println("Menu de la Tienda");
            System.out.println("\t1. Registrar Videojuego");
            System.out.println("\t2. Listar los Videojuegos");
            System.out.println("\t3. Eliminar Videojuego (por ID)");
            System.out.println("\t0. Salir de la Tienda");
            int opc = sc.pedirNumero("Elige: ");
            exit = acciones(opc);
        }
    }

    //metodo que permita introducir que opcion elegir
    public static boolean acciones(int opc) throws PrecioInvalidoException {
        switch(opc){

            case 1:
                tienda.agregarVideojuego(pedirVideojuego());
                break;
            case 2:
                tienda.listarVideojuegos();
                break;
            case 3:
                if(eliminarVideojuego()){
                    System.out.println("El jueguito eliminado exitosamente");
                }else{
                    System.out.println("Error al eliminar el jueguito");
                }
                break;
            case 0:
                System.out.println("Salido...");
                return true;
            default:
                System.out.println("No me vale...");
                break;
        }

        return false;
    }

    //metodo que, si es llamado, pedira los datos del videojuegoal usuario
    public static Videojuego pedirVideojuego() throws PrecioInvalidoException {
        Videojuego videojuego = new Videojuego();

        //pide el titulo y el precio
        String Titulo = sc.pideTexto("Como se llama el juego a agregar?: ");
        videojuego.setTitulo(Titulo);
        double precio = sc.pedirDecimal("ahora, cual es el precio del jueguito?: ");
        videojuego.setPrecio(precio);

        return videojuego;
    }

    //metodo para eliminar el juego, segun su ID
    public static boolean eliminarVideojuego(){

        //pide el ID del juego a eliminar
        tienda.listarVideojuegos();
        int id = sc.pedirNumero("Cual es el ID del juego a eliminar?");

        try{
            return tienda.eliminarVideojuegoPorID(id);
        } catch (PrecioInvalidoException e){
            System.out.println(e.getMessage());
        }

        return false;
    }


























}
