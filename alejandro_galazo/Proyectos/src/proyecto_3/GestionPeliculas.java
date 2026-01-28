package proyecto_3;

import proyecto_3.clases.Pelicula;
import proyecto_3.enums.Genero;
import proyecto_3.recursos.MyScanner;
import proyecto_3.recursos.Utilidades;

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
    private static Map<String, Pelicula> visualizaciones = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION DE PELÍCULAS =====" +
                    "\n1. Registrar Pelicula" +
                    "\n2. Mostrar peliculas" +
                    "\n3. Ver pelicula" +
                    "\n4. Mostrar estadisticas de visualizacion" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");
            switch (opcion) {
                case 1:
                    agregarPelicula();
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
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }


    public static void agregarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el ISBN (3 letras y 2 números): ").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fecha_publicacion = sc.pideTexto("Introduce la fecha publicacion (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fecha_publicacion);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if (visualizaciones.containsKey(pelicula)) {
            System.out.println("❌ La pelicula ya existe!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("✅ La pelicula ha sido agregado exitosamente!");

    }

    public static boolean validarCodigo(String codigo) {

        String validadores = "^[A-Z]{3}[0-9]{2}$";

        if (!codigo.matches(validadores)) {
            System.out.println("❌ Código incorrecto. Ejemplo válido: ABC12");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {

        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println();
                System.out.println("------------------------");
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

    public static void verPeliculas() {
        int visualizacion = 0;
        String codigo = sc.pideTexto("Introduce el código: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            int visualizaciones= +1;
            registrarVisualizacion(pelicula);
            System.out.println("✅ reproduciendo pelicula!");
        } else {
            System.out.println("❌ La pelicula no existe con el codigo dado!");
        }
    }

    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- Visualización -----\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------");

            } catch (IOException e) {
                System.out.println("Error al ver pelicula. " + e.getMessage());
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

    public static void mostrarEstadisticas() {
        for (Map.Entry<String, Pelicula> e : visualizaciones.entrySet()) {
            String v = e.getKey();
            Pelicula s = e.getValue();
            System.out.printf("Título: %s, Visualizaciones: %d", v, s);
        }

    }
}



