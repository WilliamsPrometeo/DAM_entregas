package practica3.clases;

import daw_entregas.excepciones.CodigoInvalidoException;
import recursos.Miscanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {

    private static final Miscanner miscanner = new Miscanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    public static void main(String[] args) throws CodigoInvalidoException {
        menu();
    }

    public static void menu() throws CodigoInvalidoException {
        boolean exit;
        do {
            exit = false;
            int opcion = miscanner.pedirNumero("🗿Bienvenido al Videoclub Bloste 🗿" +
                    "\n1. Registrar película" +
                    "\n2. Mostrar películas registradas" +
                    "\n3. Ver película" +
                    "\n4. Mostrar estadísticas de visualización" +
                    "\n5. Salir" +
                    "\n¿Qué quieres hacer? Selecciona una opción: ");
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
                    estadisticas();
                    break;
                case 5:
                    System.out.println("Que qué es el bloste? Venga, hasta luego! 🗿");
                    exit = true;
                    break;
                default:
                    System.out.println("Campeón, que eres un campeón. Anda, pon una opción válida.");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() throws CodigoInvalidoException {
        String codigo;
        do {
            codigo = miscanner.pideTexto("Introduce el código de la película que vayas a registrar (sólo 7 caracteres, y sólo numeros y letras): ").toUpperCase();
        } while (!validarCodigo(codigo));

        String titulo = miscanner.pideTexto("Introduce el título: ");
        String director = miscanner.pideTexto("Introduce el nombre del director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fechaEstreno = miscanner.pideTexto("Introduce el fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if (visualizaciones.containsKey(pelicula)) {
            System.out.println("Pero ya teníamos esa película! Anda, mete una nueva, no pierdas el tiempo.");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("Ale! La película ha sido registrada de manera adecuada.👌");

        int visualizaciones_pelicula = 0;
        visualizaciones.put(pelicula, visualizaciones_pelicula);
    }

    private static boolean validarCodigo(String codigo) throws CodigoInvalidoException {
        String validadores = "[A-Za-z0-9]+";
        if (codigo.length() != 7) {
            throw new CodigoInvalidoException("El código debe tener al menos 7 caracteres.");
        }
        if (!codigo.matches(validadores)) {
            System.out.println("No vayas de listo... No vayas de listo. Usa sólo caracteres válidos, vamos, letras y números. Repítelo de nuevo anda.");
            return false;
        }return true;
    }

    private static void mostrarPeliculas(){
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println("Visualizaciones: " + visualizaciones.get(pelicula));
                //Si pongo los ---------- ya sería una copia descarada del Gestión librería.java
                //Ale
            }
        }
    }

    private static void verPeliculas(){
        String codigo = miscanner.pideTexto("Introduce el código de la película: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            int nueva_visualizacion = visualizaciones.get(pelicula) + 1;
            visualizaciones.put(pelicula, nueva_visualizacion);
            System.out.println("Nuevo conteo de visualizaciones: " + nueva_visualizacion);
        } else {
            System.out.println("No existe una película con ese código, inténtalo de nuevo, tarao.");
        }

        String ruta = System.getProperty("user.home") + "/Desktop/DAM/proyectos/peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- Registro visualizacion -----\n");
                fw.write("Fecha visualizacion: " + LocalDate.now() + "\n");
                fw.write("Pelicula:\n");
                fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------");

            } catch (IOException vinicius) {
                System.out.println("Error al registrar la visualización. " + vinicius.getMessage());
            }
        } else {
            System.out.println("Algo ha fallao");
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

    public static boolean comprobarDirectorio(String ruta) {
        if ((Utilidades.existDirectory(ruta))) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

    public static void estadisticas(){
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo());
        }
        for(Pelicula pelicula : visualizaciones.keySet()) {
            System.out.println("Visualizaciones: " + visualizaciones.get(pelicula));
        }
    }
}
