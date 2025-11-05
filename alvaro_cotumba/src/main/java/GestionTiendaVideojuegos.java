

public class GestionTiendaVideojuegos {
    private static final MyScanner sc =  new MyScanner();

    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        
        boolean exit = false;
        while (!exit) {
            System.out.println("***** Tienda Videojuego *****");
            System.out.println("\t1. Agregar Videjuego");
            System.out.println("\t2. Listar Videjuegos");
            System.out.println("\t3. Buscar Videjuego");
            System.out.println("\t4. Eliminar Videjuego");
            System.out.println("\"t0 Salir.");
            int opcion = sc.pedirNumero("Ingrese una opcion: ");
            exit = eleciones(opcion);
        }
    }

    public static boolean eleciones(int opcion) {
        switch (opcion) {
            case 1:
                tienda.agregarVidejuego(agregarVidejuegos());
                break;
                case 2:
                    tienda.listarVidejuego();
                    break;
                    case 3: //no hay nada, no dio tiempo
                        break;
                    case 4:
                        if (eliminarVidejuegos()){
                            System.out.println("Videjuego eliminado exitosamente");
                        }else {
                            System.out.println("Fallo, videjuego no eliminado");
                        }
                        break;
            case 0:
                System.out.println("***** saliendo *****");
                return true;
                default:
                    System.out.println("Opcion no valida.");
                    break;
        }
        return false;
    }

    public static Videojuego agregarVidejuegos() {
        String titulo = sc.pideTexto("Ingrese el titulo: ");
        double precio = sc.pedirSoloNumero ("Ingrese el precio: ");
        Videojuego videojuegos = new Videojuego(titulo, precio);
        return videojuegos;
    }

    public static boolean eliminarVidejuegos() {
        Tienda.listarVideojuego();
        int id = sc.pedirNumero("Ingrese el id del videojuego: ");
        try{
            return tienda.eliminarPorId(id);
        } catch (TiendaException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
