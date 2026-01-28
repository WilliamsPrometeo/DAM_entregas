import clases.Pelicula;
import clases.enums.Genero;
import clases.recursos.MyScanner;
import clases.recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            int opcion = sc.pedirNumero("===== GESTION PELICULAS =====" +
                    "\n1. Registrar Pelicula" +
                    "\n2. Mostrar Peliculas" +
                    "\n3. Ver Película" +
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
                    verPelicula();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }
    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Digite el codigo(6 numeros y 2 letras): ").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fechaEstreno =  sc.pideTexto("Introduce la fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);
        peliculas.add(pelicula);
        System.out.println("✅ La pelicula ha sido agregado exitosamente!");



    }
    public static boolean validarCodigo(String codigo) {

        String validadores = "^[A-Z]{6}[0-9]{2}$";

        if (!codigo.matches(validadores)) {
            System.out.println("❌ Codigo incorrecto. Ejemplo válido: ABCDEF12");
            return false;
        }
        return true;
    }
    public static void mostrarPeliculas() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println("------------------");
            }
        } else {
            System.out.println("No hay peliculas que mostrar.");
        }
    }
    public static Pelicula getPelicula(String codigo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                return pelicula;
            }
        }
        return null;
    }

    public static void verPelicula() {
        String codigo = sc.pideTexto("Introduce codigo: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            visualizaciones.put(pelicula, + 1);
            registrarVisualizacion(pelicula);
            System.out.println("✅ Pelicula vista exitosamente!");
        } else {
            System.out.println("❌La pelicula no existe con el código dado!");
        }
    }
    public static void mostrarEstadisticas() {
        System.out.println("---Trabajos realizados---");
        for (Pelicula pelicula : visualizaciones.keySet()) {
            System.out.printf("Visualizaciones:%n %s %n a la pelicula: %s%n", visualizaciones.get(pelicula),
                    pelicula);
        }
        }

    public static void crearArchivoVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            LocalDateTime fecha =  LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmm");
            String fecha_formateada = formatter.format(fecha);
            File archivo = new File(ruta + pelicula.getCodigo() + "-" + fecha_formateada + ".txt");

            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Pelicula:\n");
                fw.write("Fecha de visualización: " + formatter2.format(fecha) + "\n");
                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de visualización!" + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }
    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Libro:\n");
                fw.write("Fecha de visualizacion: " + LocalDate.now() + "\n");
                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tAutor: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------");

            } catch (IOException e) {
                System.out.println("Error al registrar la visualizacion. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }
    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }


}
