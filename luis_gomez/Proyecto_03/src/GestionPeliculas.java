import clases.MyScanner;
import clases.Pelicula;
import clases.Utilidades;
import clases.enums.Genero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionPeliculas {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTIÓN DE PELÍCULAS =====\n" +
                    "1. Registrar película\n" +
                    "2. Mostrar películas\n" +
                    "3. Ver película\n" +
                    "4. Mostrar estadísticas de visualización\n" +
                    "5. Salir\n" +
                    "Inserte la opcion que desee: ");
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
                    estadisticasVisualizacion();
                    break;
                case 5:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida !!!");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el codigo (3 letras y 3 números): ".toUpperCase());
        } while (!validarCodigo(codigo));

        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("Una pelicula con ese codigo ya existe");
                return;
            }
        }

        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fecha_estreno = sc.pideTexto("Introduce el fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fecha_estreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        peliculas.add(pelicula);
        System.out.println("La pelicula se ha registrado exitosamente");

        visualizaciones.put(pelicula, 0);
    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^[A-Z]{3}[0-9]{3}$";

        if (!codigo.matches(validadores)) {
            System.out.println("El codigo introducido no es valido. Ejemplo valido: ABC123");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay peliculas registradas actualmente 😢😢😢");
        } else {
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
        }
    }

    public static void verPelicula() {
        String codigo = sc.pideTexto("Introduce el codigo: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula == null) {
            System.out.println("La pelicula con el codigo introducido no existe");
        } else {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
            registrarVisualizacion(pelicula);
            System.out.println("Pelicula vista exitosamente");
        }
    }

    public static Pelicula getPelicula(String codigo) {
        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Descktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {
                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("Codigo: " + pelicula.getCodigo() + "\n");
                fw.write("Titulo: " + pelicula.getTitulo() + "\n");
                fw.write("Director: " + pelicula.getDirector() + "\n");
                fw.write("------------------------\n");
            } catch (IOException e){
                System.out.println("Error al registrar la visualizacion. " + e.getMessage());
            }
        } else {
            System.out.println("Error fatal :(");
        }
    }

    private static boolean comprobarDirectorio (String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

    public static void estadisticasVisualizacion() {
        if (visualizaciones.isEmpty()) {
            System.out.println("No hay peliculas registradas por el momento 😢😢😢");
        } else {
            Utilidades.imprimirMap(visualizaciones);
        }
    }
}