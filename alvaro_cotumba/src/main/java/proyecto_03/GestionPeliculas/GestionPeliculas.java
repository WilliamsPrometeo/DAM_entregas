import proyecto_03.GestionPeliculas.clases.Pelicula;
import proyecto_03.GestionPeliculas.clases.enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static proyecto_03.GestionPeliculas.clases.Pelicula.codigo;

/**
 * Clase principal para gestionar la gestion de peliculas.
 *
 * @author Alumno - Alvaro Cotumba
 * @version 1.0
 */

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    /**
     * Metodo principal que inicia el programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * Muestra el menú principal y gestiona las opciones.
     */
    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION PELICULA =====" +
                    "\n1. Registrar pelicula" +
                    "\n2. Mostrar peliculas" +
                    "\n3. Ver pelicula" +
                    "\n4. Mostrar estadistica de visualizaciones" +
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
                    mostrarVisualizaciones();
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

    /**
     * Agrega una nueva pelicula a la gestion de peliculas.
     */
    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el codigo (3 letras y 2 números): ").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fechaEstreno =  sc.pideTexto("Introduce la fecha publicacion (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if (visualizaciones.containsKey(pelicula)) {
            System.out.println("❌ La pelicula ya existe!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("✅ La pelicula ha sido agregado exitosamente!");

    }

    /**
     * Valida el formato del Codigo.
     *
     * @param codigo Codigo a validar.
     * @return true si es válido, false si no.
     */
    public static boolean validarCodigo(String codigo) {

        String validadores = "^[A-Z]{3}[0-9]{2}$";

        if (!codigo.matches(validadores)) {
            System.out.println("❌ Codigo incorrecto. Ejemplo válido: ABC12");
            return false;
        }
        return true;
    }

    /**
     * Muestra todos las peliculas en la gestion peliculas.
     */
    public static void mostrarPeliculas() {

        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println("Visualizaciones: " + visualizaciones.get(pelicula));
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No hay pelis que mostrar.");
        }
    }

    /**
     * Gestiona el la operacion para ver una peli.
     */
    public static void verPelicula() {
        String codigo = sc.pideTexto("Introduce el ISBN: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            int nueva_visulazacion = sc.pedirNumero("Introduce la peli " + pelicula.getTitulo() + ": ");
            if (nueva_visulazacion > 0) {
                visualizaciones.put(pelicula, nueva_visulazacion);
            }
        } else {
            System.out.println("❌ El peli no existe con el codigo dado!");
        }

    }

    /**
     * Busca un libro por Codigo.
     *
     * @param Codigo Codigo del libro a buscar.
     * @return Peli encontrado o null.
     */
    public static Pelicula getPelicula(String Codigo) {
        String codigo = sc.pideTexto("Introduce el codigo: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) - 1);
            registrarPrestamo(pelicula);
            System.out.println("✅ Peli para ver seleccionada exitosamente!");
        } else {
            System.out.println("❌ La peli no existe con el codigo dado!");
        }
        return pelicula;
    }

/**
 * Crea un archivo individual para cada préstamo.
 *
 * @param pelicula peli vista.
 */
public static void crearArchivoPrestamo(Pelicula pelicula) {
    String ruta = System.getProperty("user.home") + "/Desktop/DAM/simulacros/";
    if (comprobarDirectorio(ruta)) {
        LocalDateTime fecha =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmm");
        String fecha_formateada = formatter.format(fecha);
        File archivo = new File(ruta + Pelicula.getCodigo() + "-" + fecha_formateada + ".txt");

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write("----- Pelis para ver -----\n");
            fw.write("Fecha visualizacion de peli: " + formatter2.format(fecha) + "\n");
            fw.write("Peli:\n");
            fw.write("\tCodigo: " + Pelicula.getCodigo() + "\n");
            fw.write("\tTitulo: " + Pelicula.getTitulo() + "\n");
            fw.write("\tDirector: " + Pelicula.getDirector() + "\n");
            fw.write("-----------------------");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo de prestamo!" + e.getMessage());
        }
    } else {
        System.out.println("Algo ha fallado.");
    }
}

/**
 * Registra un préstamo en el archivo general.
 *
 * @param pelicula Libro prestado.
 */
public static void registrarPrestamo(Pelicula pelicula) {
    String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
    if (comprobarDirectorio(ruta)) {
        File archivo = new File(ruta + "prestamos.txt");

        try (FileWriter fw = new FileWriter(archivo, true)) {

            fw.write("----- PRESTAMO -----\n");
            fw.write("Fecha prestamo: " + LocalDate.now() + "\n");
            fw.write("Pelicula:\n");
            fw.write("\tCodigo: " + Pelicula.getCodigo() + "\n");
            fw.write("\tTitulo: " + Pelicula.getTitulo() + "\n");
            fw.write("\tDirector: " + Pelicula.getDirector() + "\n");
            fw.write("-----------------------");

        } catch (IOException e) {
            System.out.println("Error al registrar el prestamo. " + e.getMessage());
        }
    } else {
        System.out.println("Algo ha fallado.");
    }
}

/**
 * Comprueba y crea el directorio si no existe.
 *
 * @param ruta Ruta del directorio.
 * @return true si existe o se crea, false si no.
 */
private static boolean comprobarDirectorio(String ruta) {
    if (Utilidades.existDirectory(ruta)) {
        return true;
    } else {
        return Utilidades.crearDirectorio(ruta);
    }
}

    /**
     * Muestra visualizaciones.
     */
    public static Pelicula mostrarVisualizaciones() {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                return pelicula;
            }
        }
        return null;
    }
