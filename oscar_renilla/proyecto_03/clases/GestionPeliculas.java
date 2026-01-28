package programacion.proyecto_03.clases;

import com.sun.security.jgss.GSSUtil;
import programacion.proyecto_03.clases.enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase GestionPeliculas
 *
 * @author Alumno - Óscar Renilla
 * @version 1.0
 */
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
            int opcion = sc.pedirNumero("\n===== GESTION PELICULAS =====" +
                    "\n1. Registrar pelicula" +
                    "\n2. Mostrar peliculas" +
                    "\n3. Ver pelicula" +
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
                    mostrarEstaisticas();
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
            codigo = sc.pideTexto("Introduce el código de la peícula (3 letras y 2 números): ").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero de la película: ");
        String fecha_estreno = sc.pideTexto("Introduce la fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fecha_estreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if (visualizaciones.containsKey(pelicula)) {
            System.out.println("La película ya existe!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("La película ha sido registrada correctamente!");

        int visualizaciones_pelicula = 0;
        visualizaciones.put(pelicula, visualizaciones_pelicula);
    }



    public static boolean validarCodigo(String codigo) {

        String validadores = "^[A-Z]{3}[0-9]{3}$";

        for(Pelicula pelicula : peliculas){
            if(pelicula.getCodigo().equals(codigo)){
                System.out.println("Ese codiyo ya existe");
            }
            return false;
        }

        if (!codigo.matches(validadores)) {
            System.out.println("Código incorrecto. Ejemplo válido: ABC123");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {

        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
//                System.out.println("Visualizaciones: " + visualizaciones.get(pelicula));
            }
        } else {
            System.out.println("No hay películas que mostrar.");
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
        String codigo = sc.pideTexto("Introduce el código: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
            registrarVisualizacion(pelicula);
            System.out.println("Película visualizada correctamente!");
        } else {
            System.out.println("La pleícula no existe con el código dado!");
        }
    }

    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("\n----- VISUALIZACIÓN -----\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("Código: " + pelicula.getCodigo() + "\n");
                fw.write("Titulo: " + pelicula.getTitulo() + "\n");
                fw.write("Director: " + pelicula.getDirector() + "\n");
                fw.write("-------------------------\n");

            } catch (IOException e) {
                System.out.println("Error al registrar la visualización de la película. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

    public static void mostrarEstaisticas() {
        System.out.println("Estadísticas de visualización de películas: \n");
        if (!visualizaciones.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println("Película: " + pelicula.getTitulo() + " | Visualizaciones: " + visualizaciones.get(pelicula));
                System.out.println("--------------------------------------");
            }
        } else {
            System.out.println("No hay visualizaciones");
        }
    }
}
