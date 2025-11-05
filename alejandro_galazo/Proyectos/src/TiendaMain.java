import java.util.ArrayList;

public class TiendaMain {
    public static void main(String[] args) {
        MyScanner teclado = new MyScanner();

        String nombreTienda = teclado.pideTexto("¿En que tienda vas a comprar?");
        Tienda tienda = new Tienda(1, nombreTienda);

        int nextId = 1;
        int opcion;

        //menú
        do{
            System.out.println("===== Menú de " + nombreTienda + " =====");
            System.out.println("1. Agregar Videojuego");
            System.out.println("2. Listar Videojuegos");
            System.out.println("3. Buscar Videojuego");
            System.out.println("4. Eliminar Videojuego");
            System.out.println("0. Salir");
            opcion = teclado.pedirNumero("Selecciona una opción");

            switch(opcion){
                case 1 -> {
                    agregarVideojuego(teclado, tienda, nextId);
                    nextId++;
                }
                case 2 -> {
                    listarVideojuegos(tienda);
                }
                case 3 -> {
                    comprarVideojuego(teclado, tienda);
                }
                case 4 -> {
                    eliminarVideojuego(teclado, tienda);
                }
                case 0 -> {
                    System.out.println("Salir");
                }
                default -> System.out.println("Opción no válida. Número del 0 al 5");
            }
        } while(opcion!=0);
    }

    // método agregar videojuego

    public static void agregarVideojuego(MyScanner teclado,Tienda tienda, int id){
        String titulo = teclado.pideTexto("Introduce la titulo del videojuego");
        String autor = teclado.pideTexto("¿Cual es su autor?");

        // try/catch para la excepción de precio negativo
            try {
                double precio = teclado.pedirNumero("¿Por cuanto lo quieres vender?");

                if (precio < 0) {
                    throw new PrecioNoValido("no puedes establecer un precio negativo");
                }
                System.out.println("juego puesto a la venta");
            } catch (PrecioNoValido e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("introduce el precio de nuevo");
            }


        Videojuego videojuego = new Videojuego(id,titulo,autor);
        tienda.addVideojuego(videojuego);

    }

    // método para listar videojuegos

    public static void listarVideojuegos(Tienda tienda){
        ArrayList<Videojuego> videojuegos = tienda.getVideojuegos();
        if (videojuegos.isEmpty()){
            System.out.println("videojuego no encontrado.");
            return;
        }

        System.out.println("\nListado de videojuegos en la tienda");
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.isDisponible()){
                System.out.println(
                        "\n Nombre del videojuego: " + videojuego.getNombre_videojuego() +
                        "\n Autor: " + videojuego.getAutor() +
                        "\n Precio" + videojuego.getPrecio() );
            }
        }
    }

    //método para buscar y comprar videojuego

    public static void comprarVideojuego(MyScanner teclado, Tienda tienda) {
        String Nombre_videojuego = teclado.pideTexto("Introduce el nombre del videojuego que quieres comprar:");
        Videojuego videojuego = buscarVideojegoPorNombre(tienda, Nombre_videojuego);

        if (videojuego == null) {
            System.out.println("No se encontró ningún juego con ese nombre.");
            return;
        }

        if (!videojuego.isDisponible()) {
            System.out.println("El juego no está disponible actualmente.");
            return;
        }

        char respuesta = teclado.pedirLetra("El juego está disponible, cuesta ¿Deseas adquirirlo? (s/n):");
        if (Character.toLowerCase(respuesta) == 's') {
            tienda.comprarVideojuego(videojuego);
            System.out.println("Has comprado el juego: " + videojuego.getNombre_videojuego());
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    // método para eliminar videojuego de la tienda

    public static void eliminarVideojuego(MyScanner teclado, Tienda tienda) {
        String titulo = teclado.pideTexto("Introduce el nombre del juego que deseas eliminar:");
        String autor = teclado.pedirSoloTexto("Introduce el autor del juego:");

        ArrayList<Videojuego> videojuegos = tienda.getVideojuegos();
        Videojuego videojuegoAEliminar = null;

        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getNombre_videojuego().equalsIgnoreCase(titulo)
                    && videojuego.getAutor().equalsIgnoreCase(autor)) {
                videojuegoAEliminar = videojuego;
                break;
            }
        }

        if (videojuegoAEliminar != null) {
            videojuegos.remove(videojuegoAEliminar);
            System.out.println("Libro eliminado" + videojuegoAEliminar.getNombre_videojuego());
        } else {
            System.out.println("No se encontró un videojuego con ese nombre y autor, comprueba que esté bien escrito, sino no lo tenemos");
        }
    }

    //método para buscar videojuego por su nombre
    public static Videojuego buscarVideojegoPorNombre(Tienda tienda, String nombre_videojuego) {
        for (Videojuego videojuego : tienda.getVideojuegos()) {
            if (nombre_videojuego.equalsIgnoreCase(videojuego.getNombre_videojuego())) {
                return videojuego;
            }
        }
        return null;
    }

}
