
public class Main { //Se llama al Scanner y se crea una "tienda"
    private static final MyScanner sc = new MyScanner();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) throws precio {
        menu();
    }

    public static void menu() throws precio { //Menú con todas las opciones marcadas en el enunciado
        boolean exit = false;
        while (!exit) {
            System.out.println("-----Tienda videojuegos-----");
            System.out.println("\t1. Agregar videojuego");
            System.out.println("\t2. Listar videojuego");
            System.out.println("\t3. Eliminar videojuego");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Ingrese opción: ");
            exit = acciones(opcion);
        }
    }

    public static boolean acciones(int opcion) throws precio {
        switch (opcion) {

            case 1: // Agregar juego
                tienda.agregarVideojuego(pedirVideojuego());
            case 2: //mostrar juegos disponibles
                tienda.listarVideojuegos();
                break;

            case 3: //Eliminar juegos disponibles, si no hay no elimina nada
                if (eliminarVideojuego()) {
                    System.out.println("El videojuego ha sido eliminado exitosamente");
                } else {
                    System.out.println("Error al eliminar el juego");
                }
                break;

            case 0: // Salir del programa
                System.out.println("---Saliendo---");
                return true;

            default:
                System.out.println("Opción no valida");
        }
        return false;
    }

    public static Videojuego pedirVideojuego() { //Crea un nuevo juego y pide al usuario los valores de los atributos
        Videojuego videojuego = new Videojuego();
        String titulo = sc.pideTexto("Ingrese título: ");
        videojuego.setTitulo(titulo);
        double precio = sc.pedirDecimal("Ingrese precio: ");
        videojuego.setPrecio(precio);
        return videojuego;
    }

    public static boolean eliminarVideojuego() { //Elimina los juegos por ID, si se marca un Id erróneo no eliminará nada
        tienda.listarVideojuegos();
        int id = sc.pedirNumero("Ingrese el id del videojuego a eliminar: ");
        return tienda.eliminarporId(id);
        }
    }



