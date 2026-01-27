package practica3;

import practica3.enums.Genero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class GestionPeliculas {

    static ArrayList<Pelicula> peliculas = new ArrayList<>();
    static Map<Pelicula, Integer> visualizaciones = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    verPelicula();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("❌ Esta opción no vale!");
                    break;
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("""
                ===== GESTIÓN DE PELÍCULAS =====
                1. Registrar película
                2. Mostrar películas
                3. Ver película
                4. Mostrar estadísticas de visualización
                5. Salir
                ================================
                Elige una opción del (1-5):
                """);
    }


    private static void registrarPelicula() {
        System.out.print("Código: ");
        String codigo = sc.nextLine().toUpperCase();

        if (!codigo.matches("^[A-Z]{3}[0-9]{3}$")) {
            System.out.println("❌ El código debe ser alfanumérico");
            return;
        }

        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("❌ La película ya existe");
                return;
            }
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Director: ");
        String director = sc.nextLine();

        System.out.println("Género: ");
        for (Genero g : Genero.values()) {
            System.out.println("- " + g);
        }
        Genero genero = Genero.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);
        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);

        System.out.println("✅ Película registrada correctamente");
    }


    private static void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas");
            return;
        }

        for (Pelicula p : peliculas) {
            System.out.println("""
                    -------------------------
                    Código: %s
                    Título: %s
                    Director: %s
                    Género: %s
                    Fecha estreno: %s
                    -------------------------
                    """
                    .formatted(
                    p.getCodigo(),
                    p.getTitulo(),
                    p.getDirector(),
                    p.getGenero(),
                    p.getFechaEstreno()
            ));
        }
    }


    private static void verPelicula() {
        System.out.print("Código de la película: ");
        String codigo = sc.nextLine().toUpperCase();

        Pelicula pelicula = buscarPelicula(codigo);

        if (pelicula == null) {
            System.out.println("❌ Película no encontrada");
            return;
        }

        visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
        registrarVisualizacionFichero(pelicula);

        System.out.println("Reproduciendo \"" + pelicula.getTitulo() + "\"...");
    }


    private static void mostrarEstadisticas() {
        visualizaciones.forEach((p, v) ->
                System.out.println(p.getTitulo() + " -> " + v + " visualizaciones")
        );
    }


    private static Pelicula buscarPelicula(String codigo) {
        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }


    private static void registrarVisualizacionFichero(Pelicula p) {
        String ruta = System.getProperty("user.home") +
                "/Desktop/DAM/Proyectos/Peliculas";

        File directorio = new File(ruta);
        directorio.mkdirs();

        File fichero = new File(directorio, "historial_peliculas.txt");

        try (FileWriter fw = new FileWriter(fichero, true)) {
            fw.write("""
                    ----- VISUALIZACIÓN -----
                    Fecha: %s
                    Código: %s
                    Título: %s
                    Director: %s
                    ------------------------
                    """.formatted(
                    LocalDate.now(),
                    p.getCodigo(),
                    p.getTitulo(),
                    p.getDirector()
            ));
        } catch (IOException e) {
            System.out.println("❌ Error escribiendo en el fichero");
        }
    }


    private static int leerEntero() {
        try {
            int num = Integer.parseInt(sc.nextLine());
            return num;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
