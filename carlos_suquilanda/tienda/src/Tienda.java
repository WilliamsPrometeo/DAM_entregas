import clases.Biblioteca;
import clases.MyScanner;
import clases.VideojuegoExeption;
import clases.Videojuegos;

public class Tienda {
    private static final MyScanner myScanner = new MyScanner();
    private static final Biblioteca biblioteca = new Biblioteca();

// Aqui creo un solo metodo que ejecuta el menú. Para no tener que repetirlo siempre

    public static void main(String[] args) {
        menu();
    }
// Este es el menu del usuario que define todas las acciones posibles
    public static void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("");
            System.out.println("---------- 🕹️ TIENDA ONLINE DE VIDEOJUEGOS 🕹️ ----------\n");
            System.out.println("\t1. AGREGAR VIDEOJUEGOS AL CATÁLOGO 🎮");
            System.out.println("\t2. MOSTRAR VIDEOJUEGOS DISPONIBLES 👁️");
            System.out.println("\t3. BUSCAR VIDEOJUEGO POR ID 🔎");
            System.out.println("\t4. ELIMINAR VIDEOJUEGO 🗑️");
            System.out.println("\t0. SALIR");
            int opcion = MyScanner.pedirNumero("\n👉 OPCIÓN: ");
            exit = acciones(opcion);
        }
    }
// Este swict hace que cada opcion se vincule con una acción
    public static boolean acciones(int opcion) {
        switch (opcion) {
            case 1:
                biblioteca.RegistrarVideojuego(pedirVideojuego());
                break;

            case 2:
                biblioteca.MostrarVideojuegos();
                break;

            case 3:
                BuscarVideojuego();
                break;

            case 4:
                EliminarVideojuego();
                break;

            case 0:
                System.out.println("Saliendo ...");
                return true;

            default:
                System.out.println("Opción no válida");
                break;
        }
        return false;
    }
// Para añadir un videojuego a la lista hace falta pedir al usuario que digite los datos del
// videojuego, el usuario solo tiene que pone rel titulo y precio ya que el id se pone automaticamente

    public static Videojuegos pedirVideojuego() {
        String titulo = myScanner.pideTexto("Título: ");
        double precio = (double) MyScanner.pedirNumero("Precio: ");

            if (precio>0) {
                Videojuegos videojuego = new Videojuegos(titulo, precio);
                return videojuego;
            } else  {
                System.out.println("El precio no puede ser negativo");
                return null;
            }
    }

//Aquí se hace lo mismo solo que aqui muestra la lista de libros disponibles y te pide el id para eliminarlo y en caso de que no exista te sale la exepción personalizada

    public static void EliminarVideojuego() {
        biblioteca.MostrarVideojuegos();
        int id = MyScanner.pedirNumero("ID del videojuego a eliminar: ");
        try {
            if (biblioteca.EliminarVideojuego(id)) {
                System.out.println("✅ El videojuego ha sido eliminado correctamente.");
            }
        } catch (VideojuegoExeption e) {
            System.out.println(e.getMessage());
        }
    }
//Aqui se pide al usuario que ingrese el id del videojuego que quiera buscar. El programa recorre la lista hasta encontrar tal id y lo muestra en pantalla.
    public static void BuscarVideojuego() {
        int idBuscar = MyScanner.pedirNumero("Ingrese el ID del videojuego a buscar: ");
        Videojuegos encontrado = biblioteca.BuscarVideojuego(idBuscar);
        if (encontrado != null) {
            System.out.println("Videojuego encontrado 🎮:\n" + encontrado);
        } else {
            System.out.println("No se encontró ningún videojuego con ese ID ⚠️");
        }
    }
}
