package proyecto_03;

import proyecto_03.clases.Pelicula;
import proyecto_03.enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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

    public static void menu(){
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION DE PELÍCULAS =====" +
                    "\n1. Registrar películas" +
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
                    mostrarPelicula();
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

    public static void registrarPelicula(){
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el Código de la película (3 Letras y 3 Números): ").toUpperCase();
        } while (!validarCodigo(codigo));

        String titulo = sc.pideTexto("Introduce el título: ");
        String director = sc.pideTexto("Introduce el nombre del director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el género: ");
        LocalDate fecha = LocalDate.parse(sc.pideTexto("Introduce la fecha publicación (YYYY-MM-DD): "));

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);
        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);

        System.out.println("✅ Película registrada correctamente\n");
    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^[A-Z]{3}[0-9]{3}$";

        if ((!codigo.matches(validadores))) {
            System.out.println("❌ Código incorrecto. Ejemplo válido: MOV123\n");
            return false;
        }
        return true;
    }

    public static void mostrarPelicula(){
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }
        } else {
            System.out.println("No hay películas registradas.\n");
        }
    }

    public static void verPelicula(){
        String codigo = sc.pideTexto("Introduce el Código: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);

        if (pelicula != null) {
            int vistas = visualizaciones.getOrDefault(pelicula, 0);
            visualizaciones.put(pelicula, vistas + 1);

            System.out.println("Reproduciendo: " + pelicula.getTitulo() + "..........");
            System.out.println("Visualizaciones: " + (vistas + 1) + "👁️\n");
        } else {
            System.out.println("❌ La película no existe con el código dado!\n");
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

    public static void mostrarEstadisticas() {
        String codigo = sc.pideTexto("Introduce el Código: ");
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) - 1);
            registrarEstadisticas(pelicula);
            System.out.println("Película registrada exitosamente!\n");
        } else {
            System.out.println("❌ La película no existe con el Código dado!\n");
        }
    }

    public static void registrarEstadisticas(Pelicula pelicula){
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Películas/";
        if (Utilidades.crearDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("Película:\n");
                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTítulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------");

            } catch (IOException e) {
                System.out.println("Error al registrar el película." + e.getMessage() +"\n" );
            }
        } else {
            System.out.println("Algo ha fallado.\n");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectorio(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}