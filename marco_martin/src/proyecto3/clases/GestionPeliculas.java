package proyecto3.clases;

import proyecto3.enums.Genero;
import proyecto3.recursos.MyScanner;
import proyecto3.recursos.Utilidades;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {
    static final MyScanner sc = new MyScanner();
    static ArrayList<Pelicula> peliculas = new ArrayList<>();
    static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION DE PELÍCULAS =====" +
                    "\n1. Registrar película" +
                    "\n2. Mostrar películas" +
                    "\n3. Ver película" +
                    "\n4. Mostrar estadísticas de visualización" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");
            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    verPeliculas();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo ....🥲");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!😤");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigoPelicula;
        do {
            codigoPelicula = sc.pideTexto("Introduce el código identificador de la película: (3 Letras y 3 Números)").toUpperCase();
            for (Pelicula p : peliculas) {
                if (codigoPelicula.equals(p.getCodigo())) {
                    System.out.println("Ese código ya existe en otra película!! Eso significa que tienes que introducir un código distinto. ");
                    return;
                }
            }
        } while (!validarCodigoPelicula(codigoPelicula));
        String nombrePelicula = sc.pideTexto("Cuál es el título de la película que desea agregar?: ");
        String director = sc.pideTexto("Cuál es el director de la película que desea agregar?: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Cuál es el género de la película que desea agregar?: ");
        String fechaPublicacion = sc.pideTexto("Cuál es la fecha de estreno de la película que desea agregar?: (YYYY-MM-DD) ");
        LocalDate fecha = LocalDate.parse(fechaPublicacion);

        Pelicula pelicula = new Pelicula(codigoPelicula, nombrePelicula, director, genero, fecha);

        peliculas.add(pelicula);
        System.out.println("La película que has añadido se agregó correctamente.✅ \n");

        int numVisualizaciones = 0;
        visualizaciones.put(pelicula, numVisualizaciones);
    }

    public static boolean validarCodigoPelicula(String codigoPelicula) {
        String validadores = "^[A-Z]{3}[0-9]{3}$";

        if (!codigoPelicula.matches(validadores)) {
            System.out.println("❌Estupido, mira que era fácil poner 3 letras y 3 números, vuelve a intentarlo. Ejemplo válido: ABC123.\n");
            return false;
        }
        for (Pelicula p :peliculas){
            if (p.getCodigo().equals(codigoPelicula)) {
                return false;
            }
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No hay películas que mostrar. Por favor, agregue una primero antes de volverle a dar a esta opción porque vamos a estar así todo el día y están muriendo árboles cada vez que lo haces😒. \n");

        }
    }

    public static void verPeliculas() {

        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas que puedas ver. Registra una primero o espera a que alguien lo añada.");
            return;
        }
        mostrarPeliculas();
        String codigoPelicula = sc.pideTexto("Introduce el código de la película que quieres ver. Recuerda, 3 letras y 3 números.\n").toUpperCase();
        Pelicula pelicula = getPelicula(codigoPelicula);



        if (pelicula != null) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
            System.out.println("Espero que hayas disfrutado de la peli. Eso si, la proxima vez no guarrees con tu novia que hay cámaras.🤢");

            String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
            if (comprobarDirectorio(ruta)) {

                File archivo = new File(ruta + "historial_peliculas.txt");

                try (FileWriter fw = new FileWriter(archivo, true)) {

                    fw.write("----- VISUALIZACIÓN -----\n");
                    fw.write("\tFecha: " + LocalDate.now() + "\n");
                    fw.write("\tPelicula:\n");
                    fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                    fw.write("\tTítulo: " + pelicula.getTitulo() + "\n");
                    fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                    fw.write("-----------------------");

                } catch (IOException e) {
                    System.out.println("Error al registrar la visualización.😪 " + e.getMessage());
                }
            } else {
                System.out.println("Algo ha fallado!!!😮");
            }
        } else {
            System.out.println("❌No existe una película con ese código\n");

        }
    }

    public static Pelicula getPelicula(String codigoPelicula) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equals(codigoPelicula)) {
                return pelicula;
            }
        }
        return null;
    }

    public static void mostrarEstadisticas() {
        if (!peliculas.isEmpty()) {
            for (Map.Entry<Pelicula, Integer> e : visualizaciones.entrySet()) {
                Pelicula p = e.getKey();
                Integer i = e.getValue();
                System.out.printf("%s → Número de visualizaciones %s %n", p, i);
            }
        }else {
            System.out.println("No hay ninguna visualización registrada.\n");
        }
    }

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existeDirectorio(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}
