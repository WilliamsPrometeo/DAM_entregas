package entrega3;

import entrega3.enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            int opcion = sc.pedirNumero("=== Gestión de películas ===" +
                    "\n1. Registrar película" +
                    "\n2. Mostrar películas disponibles" +
                    "\n3. Ver una película" +
                    "\n4. Mostrar estadísticas de visualización" +
                    "\n5. Salir" +
                    "\nInserte opción: ");
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
                    System.out.println("Saliendo...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de la película (3 letras y 3 números en ese orden): ").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el título de la película: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fecha_estreno = sc.pideTexto("Introduce la fecha de estreno: (YYYY-MM-DD)");
        LocalDate fecha = LocalDate.parse(fecha_estreno);

        Pelicula pelicula = new Pelicula(codigo, director, fecha, genero, titulo);

        if (peliculas.contains(pelicula)) {
            System.out.println("La película ya existe");
            return;
        }

        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);
        System.out.println("La película se ha agregado correctamente\n");

    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^[A-Z]{3}[0-9]{3}$";

        if (!codigo.matches(validadores)) {
            System.out.println("Código incorrecto, vuelva a realizar (3 letras y 3 números en ese orden)");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }
        } else {
            System.out.println("No hay películas registradas");
        }
    }

    public static void verPeliculas() {
        String codigo = sc.pideTexto("Introduce el código de la película").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            if (visualizaciones.containsKey(pelicula)) {
                int visualizacion = visualizaciones.get(pelicula) + 1;
                visualizaciones.put(pelicula, visualizacion);
            }
            System.out.println("Disfruta de la peli.");
        } else {
            System.out.println("No hay películas por ver ahora mismo. :(");
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

    public static void crearArchivoVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Películas/";
        if (comprobarDirectorio(ruta)) {
            LocalDate fecha = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String fecha_formateada = formatter.format(fecha);
            File archivo = new File(ruta + pelicula.getCodigo() + "-" + fecha_formateada);
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha visualización: " + formatter2.format(fecha) + "\n");
                fw.write("Código: " + pelicula.getCodigo() + "\n");
                fw.write("Título: " + pelicula.getTitulo() + "\n");
                fw.write("Director: " + pelicula.getDirector() + "\n");
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo" + e.getMessage());
            }
        } else {
            System.out.println("Algo no ha funcionado. :(");
        }
    }

    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Películas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha visualización: " + LocalDate.now() + "\n");
                fw.write("Código: " + pelicula.getCodigo() + "\n");
                fw.write("Título: " + pelicula.getTitulo() + "\n");
                fw.write("Director: " + pelicula.getDirector() + "\n");
                fw.write("--------------------------");
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo" + e.getMessage());
            }
        } else {
            System.out.println("Algo no ha funcionado. :(");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

    public static void mostrarEstadisticas(){
        for (Pelicula pelicula : visualizaciones.keySet()) {
            System.out.println("Nombre: " + pelicula.getTitulo() + "Autor: " + pelicula.getDirector()+ visualizaciones.get(pelicula));
        }
    }
}