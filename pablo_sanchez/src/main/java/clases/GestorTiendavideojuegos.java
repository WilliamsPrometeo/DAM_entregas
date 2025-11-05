package clases;

import exception.PrecioInvalidoException;

import java.util.Scanner;

public class GestorTiendavideojuegos {
    private TiendaVideojuegos tienda;
    private Scanner scanner;
    public GestorTiendavideojuegos() {
        tienda = new TiendaVideojuegos();
        scanner = new Scanner(System.in);
    }
    public void iniciar() {
        int opcion;
        do {
            mostrarMenu ();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:agregarVideojuego();
                case 2:tienda.listarVideojuego();
                case 3:venderVideojuego();
                case 4:alquilarVideojuego();
                case 5:devolverVideojuego();
                case 6:eliminarVideojuego();
                case 0:
                    System.out.println("Saliendo del programa...");
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion!=0);
    }
    private void mostrarMenu() {
        System.out.println("\n===== MENÚ TIENDA DE VIDEOJUEGOS =====");
        System.out.println("1. Agregar videojuego");
        System.out.println("2. Listar videojuego");
        System.out.println("3. Vender videojuego");
        System.out.println("4. Alquilar videojuego");
        System.out.println("5. Devolver videojuego");
        System.out.println("6. Eliminar videojuego");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion: ");
    }
    private void agregarVideojuego() {
        try{
            System.out.println("Ingrese el nombre del videojuego: ");
            String nombre = scanner.nextLine();
            System.out.println("Precio del videojuego: ");
            double precio = Double.parseDouble(scanner.nextLine());
            Videojuego vj = new Videojuego(nombre, precio);
            tienda.agregarVideojuego(vj);
            System.out.println("Videojuego agregado correctamente");
        }catch (PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println("Error precio inválido.");
        }
    }
    private void venderVideojuego() {
        System.out.println("Ingrese el ID del videojuego que desea comprar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Videojuego vj = tienda.buscarPorId(id);
        if (vj == null) {
            System.out.println("El videojuego con ese ID no se encontró");
            return;
        }
        if (!vj.isDisponible()) {
            System.out.println("El video no está disponible");
        }
        System.out.printf("El precio del videojuego es %.2f euros. ¿Desea comprar? (s/n): ", vj.getPrecio());
        String respuesta= scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            vj.setDisponible(false);
            System.out.println("Videojuego comprado correctamente, disfruta de él.");
        }else{
            System.out.println("Compra cancelada.");
        }
    }
    private void alquilarVideojuego() {
        System.out.println("Ingrese el ID del videojuego que desea alquilar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Videojuego vj = tienda.buscarPorId(id);
        if (vj == null) {
            System.out.println("Videojuego no encontrado");
            return;
        }
        if (!vj.isDisponible()) {
            System.out.println("El videojuego no está disponible");
            return;
        }
        double precioAlquiler = vj.getPrecio() * 0.25;
        System.out.printf("El precio del alquiler es %.2f euros. ¿Desea alquilar? (s/n); ", precioAlquiler);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            vj.setDisponible(false);
            System.out.println("Alquiler realizado correctamente.");
        } else {
            System.out.println("Alquiler cancelado.");
        }
    }
        private void devolverVideojuego () {
            System.out.println("Ingrese ID del videojuego que desea devolver: ");
            int id = Integer.parseInt(scanner.nextLine());
            Videojuego vj = tienda.buscarPorId(id);
            if (vj != null && !vj.isDisponible()) {
                vj.setDisponible(true);
                System.out.println("El videojuego ha sido devuelto correctamente");
            }else {
                System.out.println("Videojuego no encontrado");
            }
        }
        private void eliminarVideojuego () {
            System.out.println("Ingrese ID del videojuego a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean eliminado = tienda.eliminarPorId(id);
            if (eliminado) {
                System.out.println("Videojuego eliminado correctamente");
            } else {
                System.out.println("Videojuego no encontrado");
            }
        }
}
