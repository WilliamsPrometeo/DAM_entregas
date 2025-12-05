public class FuncTienda {
    private static final MyScanner sc= new MyScanner();
    private static Tienda tienda = new Tienda();


    public static void menu (){
        boolean exit=false;
        while(!exit){
            int opcion= sc.pedirNumero("BIENVENIDO\n" +
                    "-----1. Registrar videojuego-----\n" +
                    "-----2. Listar videojuegos-----\n" +
                    "-----3. eliminar videojuego-----\n" +
                    "-----4. salir del menu-----\n" +
                    "\t INGRESE UNA OPCION: ");
            exit= accionesTienda(opcion);
        }
    }
    public static boolean accionesTienda(int opcion){
        switch(opcion){
            case 1:
                tienda.añadirVideojuego(pedirVideojuego());
                break;
            case 2:
                tienda.listarVideojuegos();
                break;
            case 3:
                if (eliminarVideojuego()){
                    System.out.println("Videojuego eliminado exitosamente\n");
                } else {
                    System.out.println("Videojuego no eliminado, proceso erróneo\n");
                }
                break;
            case 4:
                System.out.println("\tSaliendo del menu...");
                return true;
            default:
                System.out.println("La opción que has introducido no es válida");
                break;

        }
        return false;
    }
    public static Videojuego pedirVideojuego(){
        Videojuego videojuego=new Videojuego();
        String titulo= sc.pideTexto("\tIngrese el titulo del videojuego: \n");
        videojuego.setTitulo(titulo);
        double precio= sc.pedirPrecio("\tPrecio del videojuego: ");
        videojuego.setPrecio(precio);
        return videojuego;
    }
    public static boolean eliminarVideojuego()  {
        tienda.listarVideojuegos();
        int id=sc.pedirNumero("ID del videojuego: ");
        try {
            return tienda.eliminarVideojuegoPorID(id);
        } catch(EliminarJuego e) {
            System.out.println(e.getMessage());
            return false;

        }
    }
}
