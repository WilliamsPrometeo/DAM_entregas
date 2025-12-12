package simulacro2; // Indica el paquete donde se encuentra la clase Main

import simulacro2.MyScanner;

/**
 * La clase Main contiene el método principal del programa y gestiona
 * el menú principal de la aplicación de la librería.
 * Desde aquí se llaman las funciones de la clase Libreria.
 *
 * @author Tu Nombre
 * @version 1.1
 */
public class Main {

    /** Scanner personalizado para pedir datos de forma segura y validada */
    private static final MyScanner sc = new MyScanner();

    /** Instancia principal de la librería que gestiona usuarios, libros y préstamos */
    private static Libreria libreria = new Libreria();

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args argumentos desde la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        menu(); // Llama al método que muestra el menú principal
    }

    /**
     * Muestra el menú principal y permite al usuario interactuar con la aplicación.
     * El menú se repite hasta que el usuario selecciona la opción de salir.
     */
    public static void menu() {

        boolean correcto = false; // Controla cuándo debe finalizar el menú

        // Bucle que mantiene activo el menú hasta que se elija la opción salir
        do {
            System.out.println("-----LIBRERIA PROMETEO------");

            // Se pide una opción al usuario mostrando todas las alternativas del menú
            int opcion = sc.pedirNumero2(
                    "1. Registrar usuario" +
                            "\n2. Registrar libro" +
                            "\n3. Prestar libro" +
                            "\n4. Mostrar libros disponibles" +
                            "\n5. Mostrar préstamos" +
                            "\n6. Salir" +
                            "\nOpción: "
            );

            // Se ejecuta una acción según la opción elegida por el usuario
            switch (opcion) {

                case 1:
                    libreria.registrarUsuario(); // Registra un nuevo usuario en la librería
                    break;

                case 2:
                    libreria.registarLibro(); // Registra un nuevo libro
                    break;

                case 3:
                    System.out.println(libreria.prestarLibro()); // Presta un libro y muestra el resultado
                    break;

                case 4:
                    libreria.mostrarLibros(); // Muestra todos los libros disponibles
                    break;

                case 5:
                    libreria.mostrarPrestamos(); // Muestra todos los préstamos realizados
                    break;

                case 6:
                    System.out.println("Saliendo..."); // Mensaje de despedida
                    correcto = true; // Se cambia a true para salir del bucle
                    break;

                default:
                    System.out.println("Opción incorrecta"); // Manejo de opciones no válidas
                    break;
            }

        } while (!correcto); // Repite el menú mientras no se elija la opción salir
    }
}
