package proyectos_gordos;

import proyectos_gordos.recursos.MyScanner;
import proyectos_gordos.exceptions.MyExceptionVG;
import proyectos_gordos.tienda_videojuegos.TiendaVideojuegos;
import proyectos_gordos.tienda_videojuegos.Videojuegos;

public class GestionTiendaVG {
    public static final MyScanner sc = new MyScanner();
    public static TiendaVideojuegos TVG  = new TiendaVideojuegos();
    public static Videojuegos VG = new Videojuegos();

    public static void main(String[] args) {menuTienda();}

    public static void menuTienda(){

        boolean exit = false;
        while(!exit){
            System.out.println("######### 🕹️🕹️ GESTOR DE VIDEOJUEGOS 🕹️🕹️ ##########");
            System.out.println("\t1. Registrar Videojuego");
            System.out.println("\t2. Listar Videojuegos");
            System.out.println("\t3. Eliminar Videojuego");
            System.out.println("\t0. Salir");
            int option =sc.pedirNumero("Seleccione la opción que desea.");
            switch (option){
                case 1:
                    TVG.registrarVideojuegos(pedirVideojuegos());
                    break;
                case 2:
                    TVG.listar();
                    break;
                case 3:
                    if (eliminarVideojuego() ) {
                        System.out.println("Videojuego en proceso de eliminación");
                    }else {
                        System.out.println("Ha habido un problema al eliminar el videojuego");
                    }
                    break;
                case 0:
                    System.out.println("Esta usted saliendo de este nuestro gestor de videojuegos." + "\nQue tenga un buen día");
                    exit = true;
                    break;
                default:
                    System.out.println("¡¡¡¡ERROR ❌❌!!!! Opción no valida, por favor intentelo de nuevo.");
                    break;
            }
        }
    }
    public static Videojuegos pedirVideojuegos(){
        Videojuegos videojuego = new Videojuegos();
        String titulo = sc.pideTexto("Ingrese el titulo del videojuego que busca: ");
        videojuego.setTitulo(titulo);
        double precio = sc.pedirDecimal("Ingrese el precio del videojuego: ");
        videojuego.setPrecio(precio);
        return videojuego;
    }

    public static boolean eliminarVideojuego(){
        TVG.listar();
        int id = sc.pedirNumero("Por favor ingrese el ID de la videojuego que desea que sea engullido por Galactus: ");
        try{
            return TVG.eliminarByID(id);
        }catch(MyExceptionVG e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
