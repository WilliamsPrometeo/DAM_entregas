package clases;

import recursos.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class GestionPelicula {

    private static final MyScanner sc = new MyScanner();
    private static final ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static final Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    public static void menu() {
        boolean exit = false;
        do {
            int opcion = sc.pedirNumero(
                    "===== GESTIÓN DE PELÍCULAS =====\n" +
                            "1. Registrar película\n" +
                            "2. Mostrar películas\n" +
                            "3. Ver película\n" +
                            "4. Mostrar estadísticas de visualización\n" +
                            "5. Salir\n" +
                            "Inserte la opción que desee: "
            );
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
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (!exit);
    }


    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código (3 letras y 3 números, ej. ABC123): ").toUpperCase();
            if (existeCodigo(codigo)) {
                System.out.println("ERROR: Ya existe una película con ese código.");
                return;
            }
        } while (!validarCodigo(codigo));

        String titulo = sc.pideTexto("Introduce el título: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el género: ");
        String fechaEstrenoStr = sc.pideTexto("Introduce la fecha de estreno (YYYY-MM-DD): ");
        LocalDate fechaEstreno = LocalDate.parse(fechaEstrenoStr);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fechaEstreno);
        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0); // Inicializa visualizaciones en 0

        System.out.println("Película agregada correctamente.");
    }

    public static boolean existeCodigo(String codigo) {
        for (Pelicula peli : peliculas) {
            if (peli.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarCodigo(String codigo) {
        if (codigo == null || !codigo.matches("^[A-Z]{3}\\d{3}$")) {
            System.out.println("Código incorrecto. Ejemplo válido: AB123");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        for (Pelicula peli : peliculas) {
            System.out.println(peli);
            System.out.println("------------------------");
        }
    }


    public static void verPelicula() {
        String codigo = sc.pideTexto("Introduce el código de la película: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);

        if (pelicula != null) {
            // Incrementar visualizaciones
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
            // Registrar en fichero
            registrarVisualizacion(pelicula);
            System.out.println("Película vista. Visualización registrada.");
        } else {
            System.out.println("La película con el código '" + codigo + "' no existe.");
        }
    }

    public static Pelicula getPelicula(String codigo) {
        for (Pelicula peli : peliculas) {
            if (peli.getCodigo().equals(codigo)) {
                return peli;
            }
        }
        return null;
    }

    public static void mostrarEstadisticas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        System.out.println("===== ESTADÍSTICAS DE VISUALIZACIÓN =====");
        for (Pelicula peli : peliculas) {
            System.out.println(peli.getTitulo() + " (" + peli.getCodigo() + "): "
                    + visualizaciones.get(peli) + " visualizaciones");
        }
    }

    public static void registrarVisualizacion(Pelicula pelicula) {
        String rutaBase = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(rutaBase)) {
            File archivo = new File(rutaBase + "historial_peliculas.txt");
            try (FileWriter fw = new FileWriter(archivo, true)) {
                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("Código: " + pelicula.getCodigo() + "\n");
                fw.write("Título: " + pelicula.getTitulo() + "\n");
                fw.write("Director: " + pelicula.getDirector() + "\n");
                fw.write("------------------------\n\n");
            } catch (IOException e) {
                System.out.println("Error al registrar la visualización: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo crear el directorio para el historial.");
        }
    }

    public static boolean comprobarDirectorio(String rutaBase) {
        if (Utilidades.existDirectory(rutaBase)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(rutaBase);
        }
    }
}


