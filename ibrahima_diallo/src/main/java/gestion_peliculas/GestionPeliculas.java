package gestion_peliculas;

import gestion_peliculas.clases.Pelicula;
import gestion_peliculas.enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionPeliculas {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new HashMap<Pelicula, Integer>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;

        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION PELICULAS ======" +
                    "\n1. Registrar Pelicula" +
                    "\n2. Mostrar peliculas" +
                    "\n3. Ver pelicula" +
                    "\n4. Mostrar estadísticas de visualizacion" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");
            switch (opcion) {
                case 1:
                    RegistrarPelicula();
                    break;
                case 2:
                    MostrarPeliculas();
                    break;
                case 3:
                    VerPelicula();
                    break;
                case 4:
                    estadisticasPeliculas();
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

    public static void RegistrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el Codigo: ").toUpperCase();

       } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fecha_estreno =  sc.pideTexto("Introduce la fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fecha_estreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero ,fecha);

        if (visualizaciones.containsKey(pelicula)) {
            System.out.println("La pelicula ya existe!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("La pelicula se ha registrado correctamente.");

    }

    public static boolean validarCodigo(String codigo) {

        String validadores = "^[A-Z]{3}[0-9]{2}$";

        if (!codigo.matches(validadores)) {
            System.out.println("El codigo es incorrecto! Ejemplo válido: ABC12");
            return false;
        }
        return true;
    }

    public static void MostrarPeliculas() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula :peliculas) {
                System.out.println(peliculas);
            }
        } else {
            System.out.println("No hay peliculas que mostrar.");
    }
    }

    public static void VerPelicula() {
        String codigoPelicula = sc.pideTexto("Introduce el código: ");
        Pelicula pelicula = getPelicula(codigoPelicula);

        if (pelicula != null) {
            int visualizacionNueva = visualizaciones.getOrDefault(pelicula, 0) + 1;
            visualizaciones.put(pelicula, visualizacionNueva);

            System.out.println("La película se ha visualizado correctamente. Total de visualizaciones: "
                    + visualizacionNueva);
        } else {
            System.out.println("No se ha encontrado la película.");
        }
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/proyectos/peliculas";
        if (comprobarDirectorio(ruta)) {
            LocalDateTime fecha =  LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmm");
            String fecha_formateada = formatter.format(fecha);
            File archivo = new File(ruta + pelicula.getCodigo() + "-" + fecha_formateada + ".txt");

            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("----- VerPelicula -----\n");
                fw.write("Fecha visualizacion: " + formatter2.format(fecha) + "\n");
                fw.write("Pelicula:\n");
                fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getCodigo() + "\n");
                fw.write("\tDirector: " + pelicula.getCodigo() + "\n");
                fw.write("----------------");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de ver!" + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }



    public static Pelicula getPelicula(String codigo) {
        for (Pelicula peliculas : peliculas) {
            if (peliculas.getCodigo().equals(codigo)) {
                return peliculas;
            }
        }
        return null;
    }

    public static void registrarArchivoPelicula(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/proyectos/peliculas";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "pelicula.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- PELICULA -----\n");
                fw.write("Fecha visualizacion: " + LocalDate.now() + "\n");
                fw.write("pelicula:\n");
                fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getCodigo() + "\n");
                fw.write("\tDirector: " + pelicula.getCodigo() + "\n");
                fw.write("-----------------------");

            } catch (IOException e) {
                System.out.println("Error al registrar la pelicula. " + e.getMessage());
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

    public static void estadisticasPeliculas() {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo());
        }
        for (Pelicula pelicula : peliculas) {
            System.out.println("Pelicula: " + pelicula.getTitulo());
        }
    }






}
