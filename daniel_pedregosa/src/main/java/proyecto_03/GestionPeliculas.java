package proyecto_03;

import Proyecto_01.Scanner.MyScanner;
import proyecto_03.clases.Pelicula;
import proyecto_03.enums.Genero;
import proyecto_03.utilidades.Utilidades;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {
    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opc = sc.pedirNumero("Gestion de Películas" +
                    "\n1. Registrar Película" +
                    "\n2. Mostrar Películas" +
                    "\n3. Ver Película" +
                    "\n4. Mostrar Estadísticas de Visualización" +
                    "\n0. Salir" +
                    "\nInserte opcion: ");
            switch (opc) {
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
                case 0:
                    System.out.println("Salido 🥒💦");
                    exit = true;
                    break;
                default:
                    System.out.println("opcion invalida ♿");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el codigo de la peli (letras y numeros, sin caracteres especiales, Y EN MAYUSCULAS):").toUpperCase();
        } while (!validarCodigo(codigo));

        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fechaEstreno = sc.pideTexto("Introduce la fecha de estreno (yyyy-mm-dd): ");

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaEstreno);
        } catch (Exception e) {
            System.out.println("Fecha invalida ♿. Operación cancelada 💀.");
            return;
        }

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if (peliculas.contains(pelicula) || visualizaciones.containsKey(pelicula)) {
            System.out.println("Pelicula ya existente, cara nalga. Engañarme es mas complicado de lo que te crees");
            return;
        }

        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);
        System.out.println("Pelicula agregada correctamente.");
    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^(?=.*[A-Z])(?=.*\\d)[A-Z\\d]+$";

        if (!codigo.matches(validadores)) {
            System.out.println("Error: codigo invalido ♿... Debe contener letras y numeros, sin caracteres especiales.");
            return false;
        }
        return true;
    }

    private static void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas, que quieres ver, la nada?, por que si quieres, puedes.");
            return;
        }
        System.out.println("\nListado de películas:");
        for (Pelicula pelis : peliculas) {
            System.out.printf("%s\n\n", pelis.toString());
        }
    }

    private static void verPelicula() {
        String codigo = sc.pideTexto("Introduce el codigo de la pelicula que desees ver: ").toUpperCase();
        Pelicula pelis = getCodigoPelicula(codigo);
        if (pelis == null) {
            System.out.println("Pelicula no encontrada.");
            return;
        }

        int actuales = visualizaciones.getOrDefault(pelis, 0);
        visualizaciones.put(pelis, actuales + 1);
        System.out.println("Visualización registrada. \n Total de visualizaciones: " + (actuales + 1));

        registrarVisualizacion(pelis);
    }

    private static void mostrarEstadisticas() {
        if (visualizaciones.isEmpty()) {
            System.out.println("La/s película/s son tan mala/s, pero tan tan MALA/S, que no hay visaulizaciones disponibles.");
            return;
        }
        System.out.println("\nEstadísticas de visualización:");
        for (Map.Entry<Pelicula, Integer> entry : visualizaciones.entrySet()) {
            System.out.printf("Código: %s | Título: %s | Visualizaciones: %d%n", entry.getKey().getCodigo(), entry.getKey().getTitulo(), entry.getValue());
        }
    }

    private static Pelicula getCodigoPelicula(String codigo) {
        for (Pelicula pelis : peliculas) {
            if (pelis.getCodigo().equalsIgnoreCase(codigo)) {
                return pelis;
            }
        }
        return null;
    }

    private static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home");
        String directorio = ruta + File.separator + "Desktop" + File.separator + "DAM" + File.separator + "Proyectos" + File.separator + "Peliculas" + File.separator;

        if (!Utilidades.existDirectorio(directorio)) {
            if (!Utilidades.crearDirectorio(directorio)) {
                System.out.println("No se pudo crear el directorio para los ficheros de historial.");
                return;
            }
        }

        String ficheroPath = directorio + "historial_peliculas.txt";

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String fecha = LocalDate.now().format(formatter);

        StringBuilder sb = new StringBuilder();
        sb.append("----- VISUALIZACIÓN -----\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Código: ").append(pelicula.getCodigo()).append("\n");
        sb.append("Título: ").append(pelicula.getTitulo()).append("\n");
        sb.append("Director: ").append(pelicula.getDirector()).append("\n");
        sb.append("------------------------\n");

        boolean escrito = Utilidades.appendTextoArchivo(ficheroPath, sb.toString());
        if (!escrito) {
            System.out.println("Error al escribir el fichero, tu visualizacion no sera contada, por listo.");
        }
    }
}