package practica3.src.clases;

import clases.Pelicula;
import enums.Genero;
import recursos.MyScanner;
import recursos.exceptions.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Esto es el main del Gestor de peliculas.
 * @author David Muñoz Martín
 * @version 1.0
 */
public class GestionPeliculas {

    static ArrayList<Pelicula> peliculas = new ArrayList<>();
    static Map<Pelicula, Integer> visualizaciones = new HashMap<>();
    static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.pedirNumero("Elige una opción:");

            switch (opcion) {
                case 1 -> registrarPelicula();
                case 2 -> mostrarPeliculas();
                case 3 -> verPelicula();
                case 4 -> mostrarEstadisticas();
                case 5 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opcion != 5);
    }

    /**
     * Se Muestra el menú principal.
     */
    public static void mostrarMenu() {
        System.out.println("\n===== GESTIÓN DE PELÍCULAS =====");
        System.out.println("1. Registrar película");
        System.out.println("2. Mostrar películas");
        System.out.println("3. Ver película");
        System.out.println("4. Mostrar estadísticas");
        System.out.println("5. Salir");
    }

    /**
     * Aque registramos una película nueva.
     */
    public static void registrarPelicula() {

        String codigo = sc.pideTexto("Código de la película:").toUpperCase();

        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("La película ya existe.");
                return;
            }
        }

        String titulo = sc.pideTexto("Título:");
        String director = sc.pedirSoloTexto("Director:");

        Genero genero = Utilidades.pedirEnum(
                Genero.class,
                "Selecciona género:"
        );

        String fechaTexto = sc.pideTexto("Fecha estreno (YYYY-MM-DD):");
        LocalDate fechaEstreno = LocalDate.parse(fechaTexto);

        Pelicula pelicula = new Pelicula(
                codigo, titulo, director, genero, fechaEstreno
        );

        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);

        System.out.println("Película registrada correctamente.");
    }

    /**
     * Muestra todas las películas registradas.
     */
    public static void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            for (Pelicula p : peliculas) {
                System.out.println(p + " | Visualizaciones: " + visualizaciones.get(p));
            }
        }
    }


    public static void verPelicula() {
        String codigo = sc.pideTexto("Código de la película:").toUpperCase();

        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                visualizaciones.put(p, visualizaciones.get(p) + 1);
                escribirFichero(p);
                System.out.println("Visualización registrada.");
                return;
            }
        }

        System.out.println("Película no encontrada.");
    }


    public static void mostrarEstadisticas() {
        Utilidades.imprimirMap(visualizaciones);
    }


    public static void escribirFichero(Pelicula p) {

        String ruta = System.getProperty("user.home")
                + "/Desktop/DAM/Proyectos/Peliculas/";

        Utilidades.crearDirectorio(ruta);

        File fichero = new File(ruta, "historial_peliculas.txt");

        try (FileWriter fw = new FileWriter(fichero, true)) {
            fw.write("----- VISUALIZACIÓN -----\n");
            fw.write("Fecha: " + LocalDate.now() + "\n");
            fw.write("Código: " + p.getCodigo() + "\n");
            fw.write("Título: " + p.getTitulo() + "\n");
            fw.write("Director: " + p.getDirector() + "\n");
            fw.write("------------------------\n");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
        }
    }
}